import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     * 
     * added error checking logic
     * 
     */
    public void startPlaying(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            player.startPlaying(filename);
            System.out.println("Now playing: " + filename);
        }
        else {
            System.out.println("Error: no file exists @ index: " + index);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     *  add songs
     */
    public void setUpData()
    {
        addFile("audio/BigBillBroonzy-BabyPleaseDontGo1.mp3");
        addFile("audio/BlindBlake-EarlyMorningBlues.mp3");
        addFile("audio/BlindLemonJefferson-matchBoxBlues.mp3");   
        addFile("audio/BlindLemonJefferson-OneDimeBlues.mp3");   
    }
    
    /**
     * ex 420 - the for each loop (definitive iteration)
     * 
     * for (ElementType elementName : collectionName) {
     *     loop body
     * }
     * 
     * for each (ELEMENT in COLLECTION DO: {
     *      loop body   
     *  }
     * 
     */
    
    public void listAllFiles()
    {
        newLine();
        for(String filename : files) {
            System.out.println(filename);
        }
    }
    
    /**
     * ex 4.24 - the for each loop (definitive iteration)
     * 
     *  With an index counter, as the for each loop doesn't have one by default
     * 
     * for (ElementType elementName : collectionName) {
     *     loop body
     * }
     * 
     * for each (ELEMENT in COLLECTION DO: {
     *      loop body   
     *  }
     * 
     */
    
    public void listAllFiles2()
    {
        newLine();
        int position = 0;
        for(String filename : files) {
            System.out.println("index position " + files + " and filename " + filename);
            position++;
        }
    }
    
    /**
     * ex 4.25 - for loop
     * 
     */
    public void listMatching(String searchString)
    {
        newLine();
        for (String filename : files) {
            if(filename.contains(searchString)) {
                // a match
                System.out.println(filename);
            }
        }
    }
    
    
    public void newLine()
    {
        System.out.println();
    }
}
