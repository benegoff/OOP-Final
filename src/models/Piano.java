package models;

import javax.swing.ImageIcon;

public class Piano {

	private final ImageIcon[] litKeys;


	private ImageIcon pianoImage;
	
	public Piano(){
		
		ImageIcon[] images = {new ImageIcon("resources/images/PianoC.png"),
				new ImageIcon("resources/images/PianoCS.png"),
				new ImageIcon("resources/images/PianoD.png"),
				new ImageIcon("resources/images/PianoDS.png"),
				new ImageIcon("resources/images/PianoE.png"),
				new ImageIcon("resources/images/PianoF.png"),
				new ImageIcon("resources/images/PianoFS.png"),
				new ImageIcon("resources/images/PianoG.png"),
				new ImageIcon("resources/images/PianoGS.png"),
				new ImageIcon("resources/images/PianoA.png"),
				new ImageIcon("resources/images/PianoAS.png"),
				new ImageIcon("resources/images/PianoB.png")};
		litKeys = images;
		pianoImage = new ImageIcon("resources/images/PianoSkeleton.png");
	}
	
	
	public ImageIcon[] getLitKeys() {
		return litKeys;
	}
	
	public ImageIcon getPianoImage(){
		return pianoImage;
	}
	
}
