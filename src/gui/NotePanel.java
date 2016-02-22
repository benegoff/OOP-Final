package gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import models.NoteBlock;

@SuppressWarnings("serial")
public class NotePanel extends JPanel {

	private ArrayList<NoteBlock> noteBlocks;
	
	NotePanel(){
		noteBlocks = new ArrayList<NoteBlock>();
	}
	
}
