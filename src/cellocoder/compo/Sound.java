package cellocoder.compo;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Sound {

	public static Audio EXPLOSION = loadSound("./explosion.wav");
	public static Audio SUCCESS = loadSound("./success.wav");
	public static Audio TIMERTICK = loadSound("./timertick.wav");
	public static Audio TYPE = loadSound("./type.wav");
	
	public static Audio loadSound(String fileName) {
		try {
			return AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream(fileName));
		} catch (IOException e) {
			throw new RuntimeException("Error loading WAV sound: " + fileName);
		}
	}
	
	public static void play(Audio audio) {
		audio.playAsSoundEffect(1f, 1f, false);
	}
	
}
