package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PianoFrame extends JFrame {
	
	private PianoPanel pianoPanel;
	private NotePanel notePanel;

	
	public PianoFrame(){
		pianoPanel = new PianoPanel();
		notePanel = new NotePanel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		setVisible(true);
		setSize(400, 500);
		GridBagConstraints notePanelGBC = new GridBagConstraints();
		notePanelGBC.gridx = 0;
		notePanelGBC.gridy = 0;
		notePanelGBC.fill = GridBagConstraints.BOTH;
		notePanelGBC.weighty = 3;
		add(notePanel, notePanelGBC);
		GridBagConstraints pianoPanelGBC = new GridBagConstraints();
		pianoPanelGBC.fill = GridBagConstraints.BOTH;
		pianoPanelGBC.weightx = 1;
		pianoPanelGBC.weighty = 1;
		pianoPanelGBC.gridx = 0;
		pianoPanelGBC.gridy = 1;
		add(pianoPanel, pianoPanelGBC);

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
