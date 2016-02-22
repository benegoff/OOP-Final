package gui;

import java.awt.Graphics;
import java.util.HashMap;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.jfugue.player.Player;
import org.jfugue.realtime.RealtimePlayer;

import models.Piano;

@SuppressWarnings("serial")
public class PianoPanel extends JPanel {
	
	private Piano piano;
	private HashMap<String, ImageIcon> pressedNotes;
	private RealtimePlayer musicPlayer;

	public PianoPanel(){
		piano = new Piano();
		try {
			musicPlayer = new RealtimePlayer();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pressedNotes = new HashMap<String, ImageIcon>();
		setVisible(true);
	}
	
	public void playNote(String note, int keyNum){
		getPressedNotes().put(note, getPiano().getLitKeys()[keyNum]);
		repaint();
		musicPlayer.play(note + "o");
	}
	
	public void releaseNote(String note){
		getPressedNotes().remove(note);
		repaint();
	}
	
	public HashMap<String, ImageIcon> getPressedNotes() {
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
		
		for(String s : pressedNotes.keySet()){
			g.drawImage(pressedNotes.get(s).getImage(), 0, 0, getWidth(), getHeight(), null);
		}

	}
	
}
