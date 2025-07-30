//Structure of the sound class
package com.moodifyx;

public class Song{
    private final String title;
    private final String filePath;

    //using 'this' to initialize 
    public Song ( String title, String filePath){
        this.title = title;
        this.filePath = filePath;
    
    }
    //allowing access to the title and filePath using getters and setters
    public String getTitle(){
        return title;
    }
    public String getFilePath(){
        return filePath;
    }
}
