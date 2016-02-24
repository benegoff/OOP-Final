package gui;

import java.awt.Graphics;
import java.util.HashMap;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.jfugue.realtime.RealtimePlayer;

import enums.NotePitch;
import models.Piano;

@SuppressWarnings("serial")
public class PianoPanel extends JPanel {
	
	private Piano piano;
	private HashMap<NotePitch, ImageIcon> pressedNotes;
	private RealtimePlayer musicPlayer;

	public PianoPanel(){
		piano = new Piano();
		try {
			musicPlayer = new RealtimePlayer();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		pressedNotes = new HashMap<NotePitch, ImageIcon>();
		setVisible(true);
	}
	
	public void playNote(NotePitch note, int keyNum){
		getPressedNotes().put(note, getPiano().getLitKeys()[keyNum]);
		repaint();
		//musicPlayer.play(note + "o");
	}
	
	public void releaseNote(String note){
		getPressedNotes().remove(note);
		repaint();
	}
	
	public HashMap<NotePitch, ImageIcon> getPressedNotes() {
		return pressedNotes;
	}
	
	public RealtimePlayer getMusicPlayer(){
		return musicPlayer;
	}
	
	public Piano getPiano() {
		return piano;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(piano.getPianoImage().getImage(), 0, 0, getWidth(), getHeight(), null);
		
		for(NotePitch s : pressedNotes.keySet()){
			g.drawImage(pressedNotes.get(s).getImage(), 0, 0, getWidth(), getHeight(), null);
		}

	}
	
}
