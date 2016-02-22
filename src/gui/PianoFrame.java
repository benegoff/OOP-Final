package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

@SuppressWarnings("serial")
public class PianoFrame extends JFrame {
	
	private PianoPanel pianoPanel;

	
	public PianoFrame(){
		pianoPanel = new PianoPanel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(400, 500);
		add(pianoPanel, BorderLayout.CENTER);
//		JButton playSongButton = new JButton("Play a sample song");
//		playSongButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//
//			}
//			
//		});
//		add(playSongButton, BorderLayout.PAGE_START);
		this.addKeyListener(new PianoKeys());
	}
	
	private class PianoKeys extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			switch (e.getKeyCode()){
			case KeyEvent.VK_A:
				pianoPanel.playNote("C", 0);
				break;
			case KeyEvent.VK_W:
				pianoPanel.playNote("C#", 1);
				break;
			case KeyEvent.VK_S:
				pianoPanel.playNote("D", 2);
				break;
			case KeyEvent.VK_E:
				pianoPanel.playNote("D#", 3);
				break;
			case KeyEvent.VK_D:
				pianoPanel.playNote("E", 4);
				break;
			case KeyEvent.VK_F:
				pianoPanel.playNote("F", 5);
				break;
			case KeyEvent.VK_U:
				pianoPanel.playNote("F#", 6);
				break;
			case KeyEvent.VK_J:
				pianoPanel.playNote("G", 7);
				break;
			case KeyEvent.VK_I:
				pianoPanel.playNote("G#", 8);
				break;
			case KeyEvent.VK_K:
				pianoPanel.playNote("A", 9);
				break;
			case KeyEvent.VK_O:
				pianoPanel.playNote("A#", 10);
				break;
			case KeyEvent.VK_L:
				pianoPanel.playNote("B", 11);
				break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()){
			case KeyEvent.VK_A:
				pianoPanel.releaseNote("C");
				break;
			case KeyEvent.VK_W:
				pianoPanel.releaseNote("C#");
				break;
			case KeyEvent.VK_S:
				pianoPanel.releaseNote("D");
				break;
			case KeyEvent.VK_E:
				pianoPanel.releaseNote("D#");
				break;
			case KeyEvent.VK_D:
				pianoPanel.releaseNote("E");
				break;
			case KeyEvent.VK_F:
				pianoPanel.releaseNote("F");
				break;
			case KeyEvent.VK_U:
				pianoPanel.releaseNote("F#");
				break;
			case KeyEvent.VK_J:
				pianoPanel.releaseNote("G");
				break;
			case KeyEvent.VK_I:
				pianoPanel.releaseNote("G#");
				break;
			case KeyEvent.VK_K:
				pianoPanel.releaseNote("A");
				break;
			case KeyEvent.VK_O:
				pianoPanel.releaseNote("A#");
				break;
			case KeyEvent.VK_L:
				pianoPanel.releaseNote("B");
				break;
			}
		}
		
	}
	
}
