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
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(String filename : files) {
            System.out.println(filename);
        }
    }
    
    
    public void listAllFiles2()
    {
        int position = 0;
        for(String filename : files) {
            System.out.println("position: " + position + " &filename: " + filename);
            position++;
        }
    }
    
    /**
     * list all files in a while loop
     */
    
    public void listAllFilesWhileLoop()
    {
        int index = 0;
        while (index < files.size()) {
            String filename = files.get(index);
            System.out.println("heres ya fukn song bro :" + filename);
            index++;
        }
    }
 
    /** ex 4.83
     * list all files in a while loop
     */
    
    public void listAllFilesForLoop()
   {
        for(int i = 0; i < files.size(); i++)
        {
            String filename = files.get(i);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
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
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= files.size()) {
            System.out.println("Index is too large.");
            System.out.println("Index variable = " + index);
            System.out.println("The ArrayList size = " + files.size());
            System.out.println("Index must be >= 0 or < " + files.size());
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    /**
     * ex 4.25 - for loop - only prints at end of arrarylist search. so if found, prints each time, if nothing found,
     * prints once at the end.
     * 
     */
    public void listMatching(String searchString)
    {
        newLine();
        boolean found = false;
        for (String filename : files) {
            if(filename.contains(searchString)) {
                // a match
                System.out.println(filename);
                found = true;
            }
        }
        if (found != true)
        {
            System.out.println("can't find shit bra");
        }
    }
    
    /**
     * ex 4.25 - for loop - crappy way because it prints everything in the arraylist
     * 
     */
    public void listMatchingCrappyWay(String searchString)
    {
        newLine();
        boolean found;
        for (String filename : files) {
            if(filename.contains(searchString)) {
                // a match
                System.out.println(filename);
                found = true;
            }
            
            if (!filename.contains(searchString)) {
            found = false;
            System.out.println("can't find shit bra");
            }
        }
        
    }
    
    public void newLine()
    {
        System.out.println();
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
     * ex 4.27 - play all files matching the search string for a few seconds and move on
     */
    
    public void playAll(String searchString)
    {
        newLine();
        boolean found;
        for (String filename : files) {
            if(filename.contains(searchString)) {
                // a match
                found = true;
                System.out.println("now playing " + filename);
                player.playSample(filename);
                
            }
            else if (!filename.contains(searchString)) {
                found = false;
                System.out.println("can't find shit bra");
            }
        }
    }
    
    
    public void playAllCUDying(String searchString)
    {
        newLine();
        boolean found;
        for (String filename : files) {
            found = filename.contains(searchString);
            if(found) {
                System.out.println("now playing " + filename);
                player.playSample(filename);
            }
            else {
                System.out.println("can't find shit bra");
            }
        }
    }
    
    /**
     * ex 4.30 - while loop to call multiples of 5 between 10 and 95
     */
    
    public void mutliplesOfFive()
    {
        int start = 10;
        int end = 95;
        while (start <= end) {
            System.out.println(start);
            start += 5;
        }
    }
    
    /**
     * ex 4.31 and 4.32 combined - while loop to add from 1 to 10 and print at the end.
     */
    
    public void sumInclusive(int a, int b)
    {
        /**
         * ex 4.31
         * 
         * int start = 1;
         * int end = 10;
         * int answer = 0;
         * while (start < end) {
         *     answer = answer + a;
         *     a++;
         * }
         * System.out.println(answer);    
         */
        int answer = 0;
        while (a <= b) {
            //System.out.println(a);
            answer = answer + a;
            a++;
        }
        System.out.println(answer);
    }
    
        public void sumExclusive(int a, int b)
    {
        /**
         * ex 4.31
         * 
         * int start = 1;
         * int end = 10;
         * int answer = 0;
         * while (start < end) {
         *     answer = answer + a;
         *     a++;
         * }
         * System.out.println(answer);    
         */
        int answer = 0;
        //increment a so we can skip it
        a++;
        while (a < b) {
            //System.out.println(a);
            answer+= a;
            a++;
        }
        System.out.println(answer);
    }
    
    /** 
     * ex 4.33 - prime number finder
     * 
     * write a method isPrime(int n) that returns  true if the n parameter is a prime number, 
     * false if not.  to implement, write a while loop that divides n by all numbers between 2 and 
     * (n - 1) and tests whether the divsion yeilds a whole number.  you can test this using modulo % 
     * to see whehter the integer division leaves a remainder of 0
     *  
     * https://www.mathsisfun.com/prime-composite-number.html
     * 
     * A Prime Number can be divided evenly only by 1 or itself (it has 2 factors only, 1 and itself).
     * Any whole number greater than 1 is either Prime or Composite, 
     * 1 is not Prime and also not Composite, it is a neutral number.
     * 
     *  n % 1 == 0 is true for ALL integers
     *  n % n (n being same number both times but != 0) always == 0
     * 
     *  prime numbers only have 2 divisors (factors) - 1 and itself
     *  composite numbers have at least 3 divisors (factors), they can have more depending on the number.
     *  
     *  example: 12 is composite, its factors are 1,12, 3,4, 6,2
     *  because: 1x12=12, 3x4=12 and 6x2=12
     * 
     *  This is why (n % i == 0) is not prime - 12 % 2 ==
     * 
     * 20:39 - CUdyin: how many whole divisors does a prime have?
     * 20:39 - blindcan't.: only 2 factors, 1 and itself
     * 20:39 - CUdyin: yep, how many divisors does any integer that is _not_ a prime have _at least_?
     * 20:40 - blindcan't.: well that depends what the number is, so at least 3?
     * 20:40 - CUdyin: precisely, any integer that isn't prime (and >1 ;) is the product of at least 2 primes
     * 20:40 - CUdyin: so at least 2 prime factors and 1 are its divisors
     * 20:41 - CUdyin: so let's assume that a given number n is prime
     * 20:41 - CUdyin: what happens if we find another divisor for n that isn't one of 1 or n itself?
     * 20:42 - blindcan't.: ah, its now a composite number and thus not prime
     * 20:42 - CUdyin: precisely, and that's what the loop is doing
     * 20:43 - CUdyin: it tries to find another divisor
     * 20:43 - CUdyin: and if that thing divides the 'prime', then n%x == 0 :P
     * 20:44 - CUdyin: so n wasn't a prime to start with
     * 20:44 - CUdyin: and we can return false :)
     * 
     */
    
    public boolean isPrime(int n) 
    {
        int i = 2; //starting at 2 because the exercise wants to divide n by all numbers between 2 and (n - 1)
        /**
         * CUDyin's while comment - technically, ceil(sqrt(n)) as limit would suffice
         * 
         * 9 % 2 = 4 remainder of 1 - (2 x 4 = 8) + 1 = 9)
         * 9 % 3 = 3 remainder of 0 - 3 x 3 = 9
         * 9 % 4 = 2 remainder of 1 - (4 x 2 = 8) + 1 = 9
         * 
         */ 
        if (n == 1 || n == 0) {
            System.out.println(n + " is a neutral number.");
            return false; 
        }
        else if (n < 0) {
            System.out.println(n + " is a negative number.");
            return false;
        }
        else {
            while (i < n) { //continue the loop while i is less than n
                if (n % i == 0) { //check that the modulo remainder of n and i is equal to 0, if so, execute next block
                    System.out.println(n + " isn't prime."); //the number is not prime because it shouldn't divide evenly if prime, unless it is the number 2
                    return false; //return false if n % i == 0
                }
                i++; //increase i so we can keep going through the loop if false hasn't been returned yet
            }
            System.out.println(n + " is prime."); //returns true if n == 2, as it will bypass all if else checks above, this is correct as 2 is prime
            return true; //return true if the entire loop has been executed, i is now greater than n and n % 1 never equalled 0
        }
    }
    
    /** the current time (value, which could be for hours or minutes ) has one added to it.
      * The new values is modulod with limit, if value and limit are the same it will equal 0 and that is assigned,
      * If they are not the same, value + 1 will be assigned.
      *  //ex 3.32 - 2015
      * 
      * 
      * if (value == (limit -1)) {
      *   value = 0;
      * }
      * else {
      *     value = (value + 1);
      * }
      *
      * value = (value + 1) % limit; //modulo of the same thing above
      *
      */
     
    public boolean isPrime2(int n) {
        int i = 2; //starting at 2 because the exercise wants to divide n by all numbers between 2 and (n - 1)
        if (n <= 1 ) { //catch numbers that don't need to be checked as prime
            if ( n == 1 || n == 0 ) { //catch neutral numbers
                System.out.println(n + " isn't prime.  It is a neutral number.");
                return false; 
            }
            else { //catch negative numbers
                System.out.println(n + " isn't prime.  It is a negative number.");
                return false; 
            }
        }
        else { //check if number is prime
            while (i < n) { //continue the loop while i is less than n
                if (n % i == 0) { //check that the modulo remainder of n and i is equal to 0, if so, execute next block, if it ever equals 0 the number isn't prime
                    System.out.println(n + " isn't prime."); //the number is not prime because it shouldn't divide evenly if prime, unless it is the number 2
                    return false; //return false if n % i == 0
                }
                i++; //increase i so we can keep going through the loop if false hasn't been returned yet
            }
            System.out.println(n + " is prime."); //returns true if n == 2, as it will bypass all if else checks above, this is correct as 2 is prime
            return true; //return true if the entire loop has been executed, i is now greater than n and n % 1 never equalled 0
        }
    }
}