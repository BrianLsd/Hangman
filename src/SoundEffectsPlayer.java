import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundEffectsPlayer implements Runnable{
    private final String path;

    public SoundEffectsPlayer(String path){
        this.path = path;
    }

    // URL for the jar file to access the audio
    public URL soundEffectURL(){
        return getClass().getResource(path);
    }

    @Override
    public void run() {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundEffectURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e){
            e.printStackTrace();
            System.exit(1);
            System.out.println("The audio clip is not supported, program closing...");
        }
    }
}
