package models;

public abstract class PianoKey {

	private final String noteToPlay;
	private boolean isBeingPlayed;
	
	public PianoKey(String note){
		noteToPlay = note;
		isBeingPlayed = false;
	}

	public boolean isBeingPlayed() {
		return isBeingPlayed;
	}

	public void setBeingPlayed(boolean isBeingPlayed) {
		this.isBeingPlayed = isBeingPlayed;
	}
	
	public String getNoteToPlay(){
		return noteToPlay;
	}
	
}
