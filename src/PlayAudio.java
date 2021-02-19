import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class PlayAudio {
	
	public PlayAudio(String file_name, float volume) throws Exception {
		
		AudioInputStream ais = AudioSystem.getAudioInputStream(ClassLoader.getSystemResourceAsStream(file_name));
		
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		float range = gainControl.getMaximum() - gainControl.getMinimum();
		float gain = (range * volume) + gainControl.getMinimum();
		gainControl.setValue(gain);
		
		clip.setFramePosition(0);
		clip.start();
		
		//Thread.sleep(50000);
	}
	
	public static void main(String[] args) throws Exception {
		new PlayAudio("stayinalive.wav", 0.7f);
	}
}
