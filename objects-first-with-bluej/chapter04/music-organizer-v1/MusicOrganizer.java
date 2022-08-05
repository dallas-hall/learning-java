import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
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
            newLine();
        }
    }
    
    /**
     * ex 4,16 - rewriting listFile
     */
    
    public void listFileRewrite(int index)
    {
        if( validIndex(index)) {
            String filename = files.get(index);
            System.out.println("oi cunt I found this fucker: index " + index + " named: " + filename);
            newLine();
        }
        else {
            System.out.println("get fuked cunt dat shit doesn't even exist");
            newLine();
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            System.out.println("fuking off song:");
            listFileRewrite(index);
            System.out.println("*** memba dat da index numbers will change afta da reshuffle of da ArrayList ***");
            newLine();
            files.remove(index);
        }
        
    }
    
    /**
     * 
     */
    public void exercise4Point9(int index)
    {
        if (index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * ex 4,16 - rewriting removeFile
     */
    
    public void removeFileRewrite(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println("we are fucking off " + filename);
            files.remove(index);
            newLine();
        }
        else {
            System.out.println("lol u avin a giggle m8???");
            newLine();
        }
        
    }
    
    /**
     * Check the index position ex 4.14
     *  @param input
     *  
     *  the files.size will be 1 larger than the last array position number
     *  so if files.size = 3 than array index numbers are 0-2 as the array starts at 0
     *  below logic checks if index is valid based on above 
     *  
     */
    public void checkIndex(int index)
    {
        //same logic implemented below, one does math to minus 1, the other doesn't
        //if(index >= 0 && index <= files.size()-1 ) { //do math, ArrayList size - 1
     
        if(index >= 0 && index < files.size()) { //make sure below ArrayList size (same as minus 1)
            String filename = files.get(index);
            System.out.println("yo bro i found dis little gem @ index " + index + " wit da name: " + filename);
            newLine();
        }
        else {
            System.out.println("soz ur input iz garbage coz its not index size minus 1 or it dun fukn exist");
            newLine();
        }
    }
    
    /**
     * Alternate version ex 4.15
     * 
     *  the files.size will be 1 larger than the last array position number
     *  so if files.size = 3 than array index numbers are 0-2 as the array starts at 0
     *  below logic checks if index is valid based on above 
     *  
     */
    
    public boolean validIndex(int index)
    {
        boolean valid;
        //same logic implemented below, one does math to minus 1, the other doesn't
        //if(index >= 0 && index <= files.size()-1 ) { //do math, ArrayList size - 1
        if(index >= 0 && index < files.size()) { //make sure below ArrayList size (same as minus 1)
            valid = true;
            //System.out.println("logic check: index " + index + " = " + valid); //check - should be true
            return true;
        }
        else {
            valid = false;
            //System.out.println("logic check: index " + index + " = " + valid); //check - should be false
            return false;
        }
        //return valid; //only needed if we comment out return in the if else logic
    }
    
    private boolean validIndexFromBook(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    public void newLine()
    {
        System.out.println();
    }
}
