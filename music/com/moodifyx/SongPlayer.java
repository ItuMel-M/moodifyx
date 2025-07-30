package com.moodifyx;
//audio imports from sound package 
import javax.sound.sampled.*;//wildcard
import java.io.File;

public class SongPlayer {
    //variable to determine when to play and stop music
    private static Clip clip;

    //method of how the song is played 
    public static void play(String filePath){
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioStream);//location
            clip.start();//to start the song 
        }catch(Exception e){
            System.out.println("Error Playing Sound: " + e.getMessage());
        }
        
    }
    //method of how the song is stopped
    public static void stop(){
        if (clip !=null && clip.isRunning()){
            clip.stop();
            clip.close();
        }
    }
}
