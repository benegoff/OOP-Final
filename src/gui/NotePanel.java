package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.NotePitch;
import models.NoteBlock;

@SuppressWarnings("serial")
public class NotePanel extends JPanel {

	private ArrayList<NoteBlock> noteBlocks;
	private HashMap<NotePitch, Boolean> notesPlayed;
	private int score;
	private int combo;
	
	NotePanel(){
		score = 0;
		notesPlayed = new HashMap<NotePitch, Boolean>();
		initializeHashMap();
		noteBlocks = new ArrayList<NoteBlock>();
		NoteBlock block = new NoteBlock(NotePitch.AS, 1000, 0);
		NoteBlock block2 = new NoteBlock(NotePitch.E, 452, 450);
		NoteBlock block3 = new NoteBlock(NotePitch.D, 856, 1000);
		noteBlocks.add(block);
		noteBlocks.add(block2);
		noteBlocks.add(block3);
		this.setLayout(new BorderLayout());
		JLabel score = new JLabel("SCORE: " + this.score);
		this.setVisible(true);
		score.setVisible(true);
		this.add(score, BorderLayout.PAGE_START);
	}
	
	public void initializeHashMap(){
		notesPlayed.put(NotePitch.C, false);
		notesPlayed.put(NotePitch.CS, false);
		notesPlayed.put(NotePitch.D, false);
		notesPlayed.put(NotePitch.DS, false);
		notesPlayed.put(NotePitch.E, false);
		notesPlayed.put(NotePitch.F, false);
		notesPlayed.put(NotePitch.FS, false);
		notesPlayed.put(NotePitch.G, false);
		notesPlayed.put(NotePitch.GS, false);
		notesPlayed.put(NotePitch.A, false);
		notesPlayed.put(NotePitch.AS, false);
		notesPlayed.put(NotePitch.B, false);
	}
	
	public int getNoteBlockXPosition(NoteBlock b){
		return b.getPitch().ordinal() * (this.getWidth() / 12);
	}
	
	public void cascadeNotes(){
		int time = 0;
		while(true){
			try {
				Thread.sleep(10);
				for(NoteBlock b : noteBlocks){
					b.tick(time);
					
					if(b.getCurrentLength() + b.getYPosition() >= this.getHeight() - 10){
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
	
	public void noteReachedBottom(NoteBlock b){
		if(b.getCurrentLength() + b.getYPosition() <= this.getHeight() + 10){
			inGracePeriod(b);
		}
		else if(b.getYPosition() < this.getHeight()){
			if(b.getSuccessful() && notesPlayed.get(b.getPitch())){
				System.out.println("Rack up the score here");
			}
			else{
				b.setColor(Color.RED);
				System.out.println("Note was missed.");
			}
		}
	}
	
	public void inGracePeriod(NoteBlock b){
		if(notesPlayed.get(b.getPitch())){
			b.setSuccessful(true);
			System.out.println("Good Job!");
		}
		else {
			b.setSuccessful(false);
			System.out.println("Try again");
		}
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(NoteBlock b : noteBlocks){
			g.setColor(b.getColor());
			g.fillRect(getNoteBlockXPosition(b), b.getYPosition(), this.getWidth() / 12, b.getCurrentLength());
			g.setColor(Color.BLACK);
			g.drawRect(getNoteBlockXPosition(b), b.getYPosition(), this.getWidth() / 12, b.getCurrentLength());
		}
	}
	
	public void addNotesPlayed(NotePitch p){
		notesPlayed.put(p, true);
	}
	
	public void removeNotesPlayed(NotePitch p){
		notesPlayed.put(p, false);
	}
	
}
