import java.util.ArrayList;
import java.util.Iterator; // ex 4.39
import java.util.Random; //ex 4.43
import java.util.Collections; //ex 4.45

/**
 * A class to hold details of audio tracks.
 * Individual tracks may be played.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    // A player for the music tracks.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        readLibrary("audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }
    
    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }
    
    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }
    
    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    public void playTrack(int index)
    {
        if(indexValid(index)) {
            player.stop(); //ex 4.38
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            track.updatePlayCount(); //ex 4.36
        }
    }
    
    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }
    
    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
    }
    
    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracksForEachLoop()
    {
        System.out.println("Track listing: For Each Loop");

        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }

    /**
     * list all files in a while loop
     */
    
    public void listAllFilesWhileLoop()
    {
        System.out.println("Track listing: While Loop");
        int index = 0;
        while (index < tracks.size())
        {
            Track track = tracks.get(index);
            System.out.println(track.getDetails());
            index++;
        }
    }    
    
    /** ex 4.83
     * list all files in a while loop
     */
    
    public void listAllFilesForLoop()
    {
        System.out.println("Track listing: For Loop");
        for(int i = 0; i < tracks.size(); i++)
        {
            Track track = tracks.get(i);
            System.out.println(track.getDetails());
        }
    }
    
    /**
     * list all tracks using iterator
     * 
     * Iterator<elementType> it (variableName) = collectionName.iterator();
     * while (it.hasNext()) (Iterator method) {
     *     elementType loopVariable = variableName.next(); (Iterator Method)
     *     System.out.println(loopVariable storing object.call stored object method());
     *     }
     *     
     * 
     */
    
    public void listAllTracksWithIterator()
    {
        System.out.println("Track listing: Iterator");
        
        Iterator<Track> it = tracks.iterator();
        while (it.hasNext()) {
            Track t = it.next();
            System.out.println(t.getDetails());
        }
        System.out.println();
    }
    
    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }
    
    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }
    
    /**
     * ex 4.39 v1
     * 
     * Remove a track from the collection by searchin for a string.
     * @param input The index of the track to be removed.
     * 
     *  has an error because of no iterator, removes successfully but the arraylist finds a null where
     *  the old object was - so an error!
     */
    public void removeTrackByName(String input)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(input)) {
                tracks.remove(track); //ArrayList remove method, doesn't work.
            }
        }
    }
    
    /**
     * ex 4.39 v2 - Search the filenames of stored tracks and delete if found.
     */
    
    public void removeTrackByNameWithIterator(String input)
    {
        Iterator<Track> it = tracks.iterator();
        //Java Type<Element_Type> element_name IS ASSIGNED THE RESULT OF collection_name.methodName() value
        while (it.hasNext()) {
            Track t = it.next();
            //Element_Type variable_name IS ASSIGNED THE RESULT OF element_name.methodName() value
            String filename = t.getFilename();
            //if (artist.equals(input)) { //will work for exact match only
            if (filename.contains(input)) {  
                it.remove(); //iterator remove method, not the ArrayList
                //System.out.println(t.getDetails());
            }
        }
    }
    
    /**
     * Play the first track in the collection, if there is one.
     */
    public void playFirst()
    {
        if(tracks.size() > 0) {
            player.stop(); //ex 4.38
            player.startPlaying(tracks.get(0).getFilename());
            tracks.get(0).updatePlayCount(); //ex 4.36
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
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all thetracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }
    
    /**
     * ex 4.37 - setting a genre
     */
    
    public void setGenre(int index, String input)
    {
        if(indexValid(index)) {
            Track track = tracks.get(index);
            track.setGenre(input);
        }
    }
    
    /**
     * ex 4.43 select and play a random track
     */
    
    public void playRandomTrack()
    {
        Random rnd = new Random(); //create random object ex 4.43
        int randomTrack = rnd.nextInt(tracks.size()); //pass tracks arraylist size into nextInt as the limit for number generation
        Track track = tracks.get(randomTrack); //get track object from tracks arraylist
        System.out.println(randomTrack + " " + track.getDetails()); //test to print randomtrack num
        playTrack(randomTrack); //play the track based on random number generated
    }
    
    /**
     * ex 4.45 select and play a random track, but play all tracks in the list and only once each. using loops
     * doesn't work properly
     */
    
    public void playAllTracksRandomlyOnceVer1()
    {
        Random rnd = new Random(); //create random object ex 4.43
               
        for (Track track : tracks) {
            int randomTrack = rnd.nextInt(tracks.size()); //pass tracks arraylist size into nextInt as the limit for number generation
            int count = track.getPlayCount(); //get how many times it was played
            if (count == 0) { //check it hasn't been played before
                tracks.get(randomTrack); //get track object from tracks arraylist
                System.out.println(randomTrack + " " + track.getDetails()); //test to print randomtrack num
                playTrack(randomTrack); //play the track based on random number generated
                try {
                    Thread.sleep(15000);                 //1000 milliseconds is one second.
                } 
                catch(InterruptedException ex) {
                     Thread.currentThread().interrupt();
                }
            }
            
        }
    }
    
    /**
     * ex 4.45 select and play a random track, but play all tracks in the list and only once each. 
     * using collections.shuffle method
     */
    
    public void playAllTracksRandomlyOnceVer2()
    {
        //Random rnd = new Random(); //create random object ex 4.43int randomTrack = rnd.nextInt(tracks.size()); //pass tracks arraylist size into nextInt as the limit for number generation
        //int randomTrack = rnd.nextInt(tracks.size()); //pass tracks arraylist size into nextInt as the limit for number generation
        
        Collections.shuffle(tracks); //shuffle the arraylist
        int index = 0; //index counter
        
        for (Track track : tracks) {
            int count = track.getPlayCount(); //get how many times it was played
            if (count == 0) { //check it hasn't been played before
                tracks.get(index); //get track object from arraylist
                System.out.println(index + " " + track.getDetails()); //test to print randomtrack num
                playTrack(index); //play the track
                index++;
                try {
                    Thread.sleep(15000);                 //1000 milliseconds is one second. 
                } 
                catch(InterruptedException ex) {
                     Thread.currentThread().interrupt();
                }
            }
            else if (count != 0) { //if track has been read and played, still count it
                index++; //increment index
            }
        }
        System.out.println("finish playing");
    }
    
    /**
     * ex 4.45 select and play a random track, but play all tracks in the list and only once each. using loops
     * rewrite of version 1 into a while loop - will work fine if nothing is played first
     */
    
    public void playAllTracksRandomlyOnceVer3()
    {
        Random rnd = new Random(); //create random object ex 4.43
        int tracksRead = 0; //how many tracks the loop has read
        int tracksStored = tracks.size(); // how many tracks are in the arraylist
        
        
        while (tracksRead < tracksStored) { //tracks read versus tracks stored
            int randomTrack = rnd.nextInt(tracks.size()); //pass tracks arraylist size into nextInt as the limit for number generation
            Track track = tracks.get(randomTrack); //get track object from tracks arraylist
            int count = track.getPlayCount(); //get how many times it was played
            
            if (count == 0) { //check it hasn't been played before
               //tracks.get(randomTrack); //get track object from tracks arraylist - redundant due to shuffle method above
               System.out.println(randomTrack + " " + track.getDetails()); //test to print randomtrack num
               playTrack(randomTrack); //play the track based on random number generated
               tracksRead++;
               try {
                    Thread.sleep(15000);                 //1000 milliseconds is one second.
               } 
               catch(InterruptedException ex) {
                     Thread.currentThread().interrupt();
               }
            }
            //else if (count != 0) { //if track has been read and played, still count it
            //   tracksRead++; //increment tracks read
            //}
        }
        System.out.println("finish playing");
    }
    
    /**
     * ex 4.45 select and play a random track, but play all tracks in the list and only once each. using loops
     * rewrite of version 3 into a different while loop
     */
    
    public void playAllTracksRandomlyOnceVer4()
    {
        Collections.shuffle(tracks); //shuffle the arraylist
        int index = 0; //temporary index used for loop control and track selection
        int tracksStored = tracks.size(); //get collection size
        
        while (index < tracks.size()) { // removed so I am reading the value from buffer, not making multiple object calls
            Track track = tracks.get(index); //get track object from tracks arraylist
            int count = track.getPlayCount(); //get how many times it was played REMOVE,because we can just call it later
            
            //if (track.getPlayCount() == 0) { //check it hasn't been played before
            if (count == 0) { //check it hasn't been played before
               System.out.println(index + " " + track.getDetails()); //test to print randomtrack num
               playTrack(index); //play the track based on random number generated
               index++; //increment index
               try {
                    Thread.sleep(15000); //1000 milliseconds is one second.
               } 
               catch(InterruptedException ex) {
                     Thread.currentThread().interrupt();
               }
            }
            //else if (track.getPlayCount() != 0) {
            else if(count != 0) {                
                 index++; //increment index
            }
        }
        System.out.println("Finished playing.");
    }
}
