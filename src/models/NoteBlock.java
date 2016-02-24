package models;

import java.awt.Color;

import enums.NotePitch;

public class NoteBlock {

	private NotePitch pitch;
	int currentLength;
	private int noteLength;
	private int yPosition;
	private int startTime;
	private boolean wasSuccessful;
	private Color color;

	public NoteBlock(NotePitch pitch, int duration, int startTime){
		this.wasSuccessful = true;
		this.pitch = pitch;
		this.currentLength = 0;
		this.yPosition = 0;
		this.startTime = startTime;
		color = Color.GREEN;
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
	
	public int getStartTime(){
		return startTime;
	}
	
	public int getNoteLength() {
		return noteLength;
	}
	
	public boolean getSuccessful(){
		return this.wasSuccessful;
	}
	
	public void setSuccessful(boolean success){
		this.wasSuccessful = success;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void setColor(Color c){
		color = c;
	}
	
	public void tick(int time){
		if(time >= this.getStartTime()){
			if(currentLength < noteLength){
				currentLength += 5;
			}
			else{
				yPosition += 5;
			}
		}
	}
	
}
