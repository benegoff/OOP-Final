package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.NoteBlock;

@SuppressWarnings("serial")
public class NotePanel extends JPanel {

	private ArrayList<NoteBlock> noteBlocks;
	
	NotePanel(){
		noteBlocks = new ArrayList<NoteBlock>();
		repaint();
	}
	
	@Override
	public void paint(Graphics g){
		
	}
	
}
