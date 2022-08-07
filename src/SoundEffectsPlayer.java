import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffectsPlayer implements Runnable{
    private final String path;

    public SoundEffectsPlayer(String path){
        this.path = path;
    }

    @Override
    public void run() {
        try {
            File music = new File(path);
            AudioInputStream audio = AudioSystem.getAudioInputStream(music);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e){
            e.printStackTrace();
            System.exit(1);
            System.out.println("The audio is not supported, program closing...");
        }
    }
}
