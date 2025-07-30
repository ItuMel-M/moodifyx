package com.moodifyx;

import javax.swing.*;//To handle UI
import java.util.List;//To handle moods
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;//to get random songs
import java.awt.Color;




public class MoodSelectorUI extends JFrame {
    private final MoodRepository repository = new MoodRepository();

    public MoodSelectorUI(){
        setTitle("Moodifyx");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setVisible(true);

    }
//Method for handling button logic 
private void setupUI(){
    Set<String> moods = repository.getAllMoods();
    JComboBox<String> moodDropDown =new JComboBox<>(moods.toArray(new String[0]));
    JButton detectMoodBtn = new JButton("Recommend Music");
   
    //declaring early 
    JPanel panel = new JPanel();
    panel.add(new JLabel("Select Your Mood: "));
    panel.add(moodDropDown); 
    panel.add(detectMoodBtn);
    add(panel);
    panel.setBackground(Color.PINK);


    detectMoodBtn.addActionListener (e -> {
        String mood = (String) moodDropDown.getSelectedItem();
    
        Color cColor;
    switch (mood) {
        case "Happy": cColor = Color.YELLOW;
         break;
        case "Angry": cColor = Color.RED;
         break;
        case "Chill": cColor = Color.PINK;
         break;
        case "Mysterious": cColor = Color.BLUE; 
        break;
        case "Moody": cColor = Color.GRAY;
         break;
        case "Practice": cColor = Color.LIGHT_GRAY;
        
        break;
        case "Romantic": cColor = Color.PINK;
         break;
        case "Peaceful": cColor = Color.GREEN; 
        break;
        case "Positive": cColor = Color.ORANGE;
         break;
        default: cColor = Color.WHITE; break;
    }
    //to change the backgroud color 
    getContentPane().setBackground(cColor);
    panel.setBackground(cColor);

        //collection of random song 
        while(true){
            List<Song> songs = repository.getSongsForMood(mood);
            Song selected = songs.get(ThreadLocalRandom.current().nextInt(songs.size()));
            SongPlayer.play(selected.getFilePath());
        
           // how the user chooses what they want to do next
        Object[] options = {" Another Song " , "Change Mood" , "Stop Music and Exit"};
        int choice = JOptionPane.showOptionDialog(
            this,
        "Now playing: "  + selected.getTitle() + "\nMood : " + mood,  "Your Mood Music",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[0]
        );

        SongPlayer.stop();

        //Choices of user to play or stop music
        if(choice == JOptionPane.YES_OPTION){
            continue;
        }
        else if(choice == JOptionPane.NO_OPTION){
            break;
        }
        else {
            System.exit(0);
        }
        }


    });
    
    




}
   

}
