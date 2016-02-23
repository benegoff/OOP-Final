package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import enums.NotePitch;
import models.NoteBlock;

@SuppressWarnings("serial")
public class NotePanel extends JPanel {

	private ArrayList<NoteBlock> noteBlocks;
	
	NotePanel(){
		noteBlocks = new ArrayList<NoteBlock>();
		NoteBlock block = new NoteBlock(NotePitch.AS, 100);
		NoteBlock block2 = new NoteBlock(NotePitch.E, 10);
		NoteBlock block3 = new NoteBlock(NotePitch.D, 35);
		noteBlocks.add(block);
		noteBlocks.add(block2);
		noteBlocks.add(block3);
	}
	
	public int getNoteBlockXPosition(NoteBlock b){
		return b.getPitch().ordinal() * (this.getWidth() / 12);
	}
	
	public void cascadeNotes(){
		while(true){
			try {
				Thread.sleep(10);
				for(NoteBlock b : noteBlocks){
					b.tick();
					repaint();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(NoteBlock b : noteBlocks){
			g.setColor(Color.GREEN);
			g.fillRect(getNoteBlockXPosition(b), b.getYPosition(), this.getWidth() / 12, b.getCurrentLength());
			g.setColor(Color.BLACK);
			g.drawRect(getNoteBlockXPosition(b), b.getYPosition(), this.getWidth() / 12, b.getCurrentLength());
		}
	}
	
}
