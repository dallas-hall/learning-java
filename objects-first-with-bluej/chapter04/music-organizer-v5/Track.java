/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
   //ex 4,35 - how many times the track was played
    private int playCount;
    //ex 4.47
    private String genre;
    
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     * 
     * @param playCount The track's played amount - ex 4.35
     */
    public Track(String artist, String title, String filename, int playCount, String genre)
    {
        setDetails(artist, title, filename, 0, genre);
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     * 
     * added playCount for ex 4.35
     */
    public Track(String filename)
    {
        setDetails("unknown", "unknown", filename, 0, genre);
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
    
    /**
     * ex 4.35 - return the playCount
     */
    
    public int getPlayCount()
    {
        return playCount;
    }
    
    /**
     * ex 4.35 - playCount method reset
     */
    
    public void resetPlayCount()
    {
        playCount = 0;
    }
    
    /**
     * ex 4.35 - playCount method update
     */
    
    public void updatePlayCount()
    {
        playCount++;
    }
    
    /**
     * ex 4.37 - return genre
     */
    
    public String getGenre()
    {
        return genre;
    }
    
    /**
     * ex 4.37 - set genre
     */
    
    public void setGenre(String input)
    {
        genre = input;
    }
    
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     * 
     *  added playCount for ex 4.35
     *  added genre for ex 4.37
     */
    public String getDetails()
    {
        return artist + ": " + title + "  (file: " + filename + ") played: " + playCount + " times. Genre: " + genre;
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file.
     * 
     * @param playCount The track's played amount - ex 4.35
     */
    private void setDetails(String artist, String title, String filename, int playCount, String genre)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
        this.playCount = playCount; //ex 4,35
        this.genre = genre; //ex4.37
    }
    
    
}
