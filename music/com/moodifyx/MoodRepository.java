package com.moodifyx;

import java.util.*;

public class MoodRepository {
    private final Map<String, List<Song>> moodSongs = new HashMap<>();//title and list of songs

//Constructor 
    public MoodRepository(){
        initializeMoodSongs();

    }
    //method to store different moods and corresponding songs
    private void initializeMoodSongs(){
        Map<String, String[]> moodFiles = Map.of(
            "Happy", new String[]{"happygirlie.wav", "happy.girlie.wav"},
            "Angry", new String[]{"angrygirlie.wav", "angrygirlie.wav"},
            "Chill", new String[]{"chillgirlie.wav", "chillgirlie.wav"},
           "Mysterious", new String[]{"mysteriousgirlie.wav", "mysteriousgirlie.wav"},
           "Moody", new String[]{"moodygirlie.wav", "moodygirlie.wav"},
           "Practice", new String[]{"practicegirlie.wav", "practicegirlie.wav"},
            "Romantic", new String[]{"romanticgirlie.wav", "romanticgirlie.wav"},
            "Peaceful", new String[]{"peacefulgirlie.wav", "peacefulgirlie.wav"},
            "Positive", new String[]{"positivegirlie.wav", "positivegirlie.wav"}
        );
         

        for(Map.Entry<String, String[]>entry : moodFiles.entrySet()){
            addMood(entry.getKey(), entry.getValue());
        }

    }
    //method of how a user sees the title of the song 
    private String formatTitle(String fileName){
        String base = fileName.replace(".wav","");
        if(base.endsWith("girl"))base = base.replace("girl","");
        else if(base.endsWith("girlie")) base = base.replace("girlie","");
        base = base.trim();
        return base.substring(0, 1).toUpperCase() + base.substring(1)+ "vibes";

    }
    //method to convert file names into list
    private void addMood(String mood, String[] files){
        List<Song> songs = new ArrayList<>();

        //to be able to add different audio files inside song list
        for(String file: files){
            songs.add(new Song (formatTitle(file), "music/" + file));
        }
        
        moodSongs.put(mood, songs);

    }
    //default song to play
    public List<Song> getSongsForMood(String mood){
        return moodSongs.getOrDefault(mood, List.of(new Song("Default Vibe","music/happygirl.wav")));
    }
    public Set<String> getAllMoods(){
        return moodSongs.keySet();
    }
    
}
