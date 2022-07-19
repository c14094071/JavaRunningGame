package Main;

import java.awt.MediaTracker;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.File;
import java.io.IOException;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	static Clip clip;
	
	public Music(String addr) {
		
		try {
			play_music(addr);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void play_music(String addr) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		String soundName = addr;
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
		
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}
	
	public static void stop_music() {
		clip.stop();
	}
}