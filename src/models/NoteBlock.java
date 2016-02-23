package models;

import enums.NotePitch;

public class NoteBlock {

	private NotePitch pitch;
	int currentLength;
	private int noteLength;
	private int yPosition;

	public NoteBlock(NotePitch pitch, int duration){
		this.pitch = pitch;
		this.currentLength = 0;
		this.yPosition = 0;
		//CHANGE THESE LATER
		noteLength = duration;
	}
	
	public NotePitch getPitch(){
		return this.pitch;
	}
	
	public int getCurrentLength(){
		return currentLength;
	}
	
	public int getYPosition(){
		return yPosition;
	}
	
	public int getNoteLength() {
		return noteLength;
	}
	
	public void tick(){
		if(currentLength < noteLength){
			currentLength++;
		}
		else{
			yPosition++;
		}
	}
	
}
