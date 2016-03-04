package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.swing.JPanel;

import org.jfugue.midi.MidiParser;

import enums.NotePitch;
import midi.MusicPlayer;
import midi.NoteBlockParserListener;
import models.noteBlocks.NoteBlock;

@SuppressWarnings("serial")
public class NotePanel extends JPanel {

	//MidiMessage 144: Note
	
	private ArrayList<NoteBlock> noteBlocks;
	private HashMap<NotePitch, Boolean> notesPlayed;
	private HashMap<NotePitch, Boolean> validKeys;
	private int score;
	private int combo;
	private Sequence song;

	NotePanel(String filePath) {
		noteBlocks = new ArrayList<NoteBlock>();
		score = 0;
		combo = 0;
		notesPlayed = new HashMap<NotePitch, Boolean>();
		validKeys = new HashMap<NotePitch, Boolean>();
		initializeHashMap(notesPlayed);
		initializeHashMap(validKeys);
		try {
			song = MidiSystem.getSequence(new File(filePath));
			
		} catch (InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		}
	}

	public void initializeHashMap(HashMap<NotePitch, Boolean> h) {
		h.put(NotePitch.C, false);
		h.put(NotePitch.CS, false);
		h.put(NotePitch.D, false);
		h.put(NotePitch.DS, false);
		h.put(NotePitch.E, false);
		h.put(NotePitch.F, false);
		h.put(NotePitch.FS, false);
		h.put(NotePitch.G, false);
		h.put(NotePitch.GS, false);
		h.put(NotePitch.A, false);
		h.put(NotePitch.AS, false);
		h.put(NotePitch.B, false);
	}

	public void createBlocksFromSong(){
		MidiParser parser = new MidiParser();
		NoteBlockParserListener listener = new NoteBlockParserListener(song);
		parser.addParserListener(listener);
		parser.parse(song);
		noteBlocks = listener.getBlocks();
	}
	
	public void cascadeNotes() {
		Thread musicThread = new Thread(new MusicPlayer(song));
		musicThread.start();
		createBlocksFromSong();
		int time = 0;
		while (true) {
			try {
				Thread.sleep(10);
				for (NoteBlock b : noteBlocks) {
					b.tick(time);

					if (b.getCurrentLength() + b.getYPosition() >= this.getHeight() - 20) {
						noteReachedBottom(b);
					}
				}
				time++;
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void noteReachedBottom(NoteBlock b) {
		validKeys.put(b.getPitch(), true);
		if (b.getCurrentLength() + b.getYPosition() <= this.getHeight() + 20) {
			inGracePeriod(b);
		} else if (b.getYPosition() < this.getHeight()) {
			if (!b.getSuccessful()) {
				combo = 0;
			}
			if (b.getSuccessful() && notesPlayed.get(b.getPitch())) {
				increaseScore();
			} else {
				b.setColor(Color.RED);
			}
		} else if(b.getYPosition() >= this.getHeight() + 20){
			validKeys.put(b.getPitch(), false);
		}
	}

	public void inGracePeriod(NoteBlock b) {
		if (notesPlayed.get(b.getPitch())) {
			if (!b.getSuccessful() || b.getYPosition() >= this.getHeight() + 20) {
				combo++;
			}
			b.setSuccessful(true);
		} else {
			b.setSuccessful(false);
		}
	}

	public void increaseScore() {
		if (combo == 0) {
			score++;
		} else {
			score += combo;
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if(noteBlocks.size() != 0){
			for (NoteBlock b : noteBlocks) {
				g.setColor(b.getColor());
				g.fillRect(b.getXPosition(), b.getYPosition(), b.getNoteWidth(), b.getCurrentLength());
				g.setColor(Color.BLACK);
				g.drawRect(b.getXPosition(), b.getYPosition(), b.getNoteWidth(), b.getCurrentLength());
			}
		}
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), 70);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Impact", Font.ITALIC, 35));
		g.drawString("Score: " + this.score, 50, 50);
		g.drawString("COMBO: x" + this.combo, this.getWidth() - 250, 50);
	}

	public void addNotesPlayed(NotePitch p) {
		notesPlayed.put(p, true);
	}

	public void removeNotesPlayed(NotePitch p) {
		notesPlayed.put(p, false);
	}

	public int getScore() {
		return this.score;
	}

	public void keyPressed(NotePitch p) {
		addNotesPlayed(p);
		if(!validKeys.get(p)){
			combo = 0;
		}
	}
	
}
