package main;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;

import org.jfugue.midi.MidiParser;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.staccato.StaccatoParserListener;

public class PianoPlayer {
	
	public static void main(String[] args) {
		
		//PianoFrame p = new PianoFrame();
		
		Pattern pattern;
		try {
			MidiParser parser = new MidiParser();
	        StaccatoParserListener listener = new StaccatoParserListener();
	        parser.addParserListener(listener);
	        parser.parse(MidiSystem.getSequence(new File("test.mid")));
	        Pattern staccatoPattern = listener.getPattern();
	        System.out.println(staccatoPattern);

	        Player player = new Player();
	        player.play(staccatoPattern);
		} catch (IOException | InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//TODO: Refactor keyUI to paint rectangles instead of images
		//TODO: Allow polyphony
		//TODO: Allow MIDI file reading
		//TODO: Add octave support
		//TODO: Transform MIDI file into game rectangles
		//TODO: Link key presses to game rectangle locations
	}
	
}
