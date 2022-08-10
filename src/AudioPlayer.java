import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer implements Runnable {
    private final String path;

    public AudioPlayer(String path){
        this.path = path;
    }

    @Override
    public void run() {
        try {
            File music = new File(path);
            AudioInputStream audio = AudioSystem.getAudioInputStream(music);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // audio keeps playing until being interrupted
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e){
            e.printStackTrace();
            System.exit(1);
            System.out.println("The music file is not supported, program closing...");
        }
    }
}
