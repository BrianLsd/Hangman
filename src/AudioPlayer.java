import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioPlayer implements Runnable {
    private final String path;

    public AudioPlayer(String path){
        this.path = path;
    }

    // URL for the jar file to access the audio
    public URL musicURL(){
        return getClass().getResource(path);
    }

    @Override
    public void run() {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(musicURL());
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
