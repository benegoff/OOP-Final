package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import enums.NotePitch;

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
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);
		notePanel.cascadeNotes();
	}
	
	private class PianoKeys extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			switch (e.getKeyCode()){
			case KeyEvent.VK_A:
				pianoPanel.playNote(NotePitch.C, 0);
				notePanel.keyPressed(NotePitch.C);
				break;
			case KeyEvent.VK_W:
				pianoPanel.playNote(NotePitch.CS, 1);
				notePanel.keyPressed(NotePitch.CS);
				break;
			case KeyEvent.VK_S:
				pianoPanel.playNote(NotePitch.D, 2);
				notePanel.keyPressed(NotePitch.D);
				break;
			case KeyEvent.VK_E:
				pianoPanel.playNote(NotePitch.DS, 3);
				notePanel.keyPressed(NotePitch.DS);
				break;
			case KeyEvent.VK_D:
				pianoPanel.playNote(NotePitch.E, 4);
				notePanel.keyPressed(NotePitch.E);
				break;
			case KeyEvent.VK_F:
				pianoPanel.playNote(NotePitch.F, 5);
				notePanel.keyPressed(NotePitch.F);
				break;
			case KeyEvent.VK_U:
				pianoPanel.playNote(NotePitch.FS, 6);
				notePanel.keyPressed(NotePitch.FS);
				break;
			case KeyEvent.VK_J:
				pianoPanel.playNote(NotePitch.G, 7);
				notePanel.keyPressed(NotePitch.G);
				break;
			case KeyEvent.VK_I:
				pianoPanel.playNote(NotePitch.GS, 8);
				notePanel.keyPressed(NotePitch.GS);
				break;
			case KeyEvent.VK_K:
				pianoPanel.playNote(NotePitch.A, 9);
				notePanel.keyPressed(NotePitch.A);
				break;
			case KeyEvent.VK_O:
				pianoPanel.playNote(NotePitch.AS, 10);
				notePanel.keyPressed(NotePitch.AS);
				break;
			case KeyEvent.VK_L:
				pianoPanel.playNote(NotePitch.B, 11);
				notePanel.keyPressed(NotePitch.B);
				break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()){
			case KeyEvent.VK_A:
				pianoPanel.releaseNote(NotePitch.C);
				notePanel.removeNotesPlayed(NotePitch.C);
				break;
			case KeyEvent.VK_W:
				pianoPanel.releaseNote(NotePitch.CS);
				notePanel.removeNotesPlayed(NotePitch.CS);
				break;
			case KeyEvent.VK_S:
				pianoPanel.releaseNote(NotePitch.D);
				notePanel.removeNotesPlayed(NotePitch.D);
				break;
			case KeyEvent.VK_E:
				pianoPanel.releaseNote(NotePitch.DS);
				notePanel.removeNotesPlayed(NotePitch.DS);
				break;
			case KeyEvent.VK_D:
				pianoPanel.releaseNote(NotePitch.E);
				notePanel.removeNotesPlayed(NotePitch.E);
				break;
			case KeyEvent.VK_F:
				pianoPanel.releaseNote(NotePitch.F);
				notePanel.removeNotesPlayed(NotePitch.F);
				break;
			case KeyEvent.VK_U:
				pianoPanel.releaseNote(NotePitch.FS);
				notePanel.removeNotesPlayed(NotePitch.FS);
				break;
			case KeyEvent.VK_J:
				pianoPanel.releaseNote(NotePitch.G);
				notePanel.removeNotesPlayed(NotePitch.G);
				break;
			case KeyEvent.VK_I:
				pianoPanel.releaseNote(NotePitch.GS);
				notePanel.removeNotesPlayed(NotePitch.GS);
				break;
			case KeyEvent.VK_K:
				pianoPanel.releaseNote(NotePitch.A);
				notePanel.removeNotesPlayed(NotePitch.A);
				break;
			case KeyEvent.VK_O:
				pianoPanel.releaseNote(NotePitch.AS);
				notePanel.removeNotesPlayed(NotePitch.AS);
				break;
			case KeyEvent.VK_L:
				pianoPanel.releaseNote(NotePitch.B);
				notePanel.removeNotesPlayed(NotePitch.B);
				break;
			}
		}
		
	}
	
}
