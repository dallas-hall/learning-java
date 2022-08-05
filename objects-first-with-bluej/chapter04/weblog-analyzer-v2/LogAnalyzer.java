import java.util.Iterator;

/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] monthCounts;
    private int[] dayCounts;
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        monthCounts = new int[12];
        dayCounts = new int[31];        
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /** ex 4.72
     * 
     * Create an object to analyze hourly web accesses.  The filename is passed in at run time.
     * The file needs to exist first, can be created by creating an LogFileCreator Object and running
     * the createFile method.  log.txt was generated this way.
     *  
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        monthCounts = new int[12];
        dayCounts = new int[31];
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }
 
    /** ex 4.79
     * Analyze the monthly access data from the log file.
     */
    public void analyzeMonthlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int month = entry.getMonth();
            monthCounts[month-1]++; //need minus 1 so we start at element 0
        }
        reader.reset(); //needed here, so we can reread the file.
    }
    
    /** ex 4.79
     * Analyze the daily access data from the log file.
     */
    public void analyzeDailyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int day = entry.getDay();
            dayCounts[day-1]++; //need minus 1 so we start at element 0
        }
        reader.reset(); //needed here, so we can reread the file.
    }    
    
    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
        reader.reset(); //needed here, so we can reread the file.       
    }
    
    /** ex 4.79
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printMonthlyCounts()
    {
        System.out.println("Month: Count");
        for(int month = 0; month < monthCounts.length; month++) {
            System.out.println((month + 1) + ": " + monthCounts[month]);
        }
    }
    
    /** ex 4.79
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printDailyCounts()
    {
        System.out.println("Day: Count");
        for(int day = 0; day < dayCounts.length; day++) {
            System.out.println((day + 1) + ": " + dayCounts[day]);
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hour: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /* ex - 4.69
     *  change the loop condition, it now stops at <= 24, not 23 as before, this is wrong. Out of bounds exception
    public void printHourlyCountsWrong()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour <= hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    */
        
    /** ex - 4.70
     *
     *  rewrite using while loop
     *
     */
    public void printHourlyCountsWhileLoop()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while (hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
       
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /** ex 4.73 & 4.74
     * Return the number of accesses recorded in the log file.
     */
    
    public int numberOfAcccesses() {
    
        int total = 0; //create our total variable
        System.out.println("Access counts"); //print some bullshit
        /*
         * for (initialise loop variable; loop condition; post-loop-body action) {
         *     statements to be repeated;
         * }
         */
        for(int hour = 0; hour < hourCounts.length; hour++) {
            total = total + hourCounts[hour];
        }
        System.out.println("Total access count: " + total); //print the total at the end
        return total; //return the number
    }
    
    /** ex 4.75
     * Return the busiest hour of the day by access total, assumes no ties
     */
    
    public void busiestHour()
    {
        int answer_hour = 0;
        int answer_total = 0; 
        
        /*
         * for (initialise loop variable; loop condition; post-loop-body action) {
         *     statements to be repeated;
         * }
         */
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            //check if the value found in array hoursCount[element position] is greater than what we have already
            if (hourCounts[hour] >= answer_total)
            {
                //keep the data found
                answer_total = hourCounts[hour];
                answer_hour = hour;
            }
        }
        System.out.println("Busiest hour is: " + answer_hour + " which was accessed " + answer_total + " time(s)"); //print some bullshit
    }
    
        /** ex 4.75
     * Return the busiest hour of the day by access total, assumes no ties
     */
    
    public void busiestHourv2()
    {
        int answer_hour = 0;
        int max_int = Integer.MIN_VALUE; //set to the minimum number possible, so we can keep adjusting it up during the loop
 
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            //check if the value found in array hoursCount[element position] is greater than what we have already, if so, store it
            if (hourCounts[hour] > max_int)
            {
                //keep the data found
                max_int = hourCounts[hour];
                answer_hour = hour;
            }
        }
        System.out.println("Busiest hour is: " + answer_hour + " which was accessed " + max_int + " time(s)"); //print some bullshit
    }
    
    /** ex 4.76
     * Return the quietest hour of the day by access total, assumes no ties and needs to know the busiest hour already
     */
    
    public void quietestHour()
    {
    
        int answer_hour = 0;
        int answer_total = 0; 
        
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            //check if the value found in array hoursCount[element position] is greater than what we have already
            if (hourCounts[hour] >= answer_total)
            {
                //keep the data found
                answer_total = hourCounts[hour];
                answer_hour = hour;
            }
        }
        
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            //check if the value found in array hoursCount[element position] is greater than what we have already
            if(hourCounts[hour] != 0 && hourCounts[hour] < answer_total)
            {
                //keep the data found
                answer_total = hourCounts[hour];
                answer_hour = hour;
            }
        }
        System.out.println("Quietest hour is: " + answer_hour + " which was accessed " + answer_total + " time(s)"); //print some bullshit
    }
   
    public void quietestHourv2()
    {
        int answer_hour = 0;
        int min_int = Integer.MAX_VALUE; //set to the maximum number possible, so we can keep adjusting it down during the loop and find the smallest number
  
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            //check if the value found in array hoursCount[element position] is less than what we have already, if so, store it.
            if (hourCounts[hour] < min_int)
            {
                //keep the data found
                min_int = hourCounts[hour];
                answer_hour = hour;
            }
        }
        System.out.println("Busiest hour is: " + answer_hour + " which was accessed " + min_int + " time(s)"); //print some bullshit
    }
    
    
    /** ex 4.75
     * Return the busiest hour of the day by access total across 2 hour blocks, assumes no ties
     * 
     * https://mathbits.com/MathBits/Java/Looping/NestedFor.htm
     * 
     */
    
    public void busiestTwoHours() {
    
        //tallys
        int current_block_total = 0;
        int highest_block_total = 0;
        String current_hour_block = ("");
        
        //final answers
        String answer_hour_block = ("");
        int answer_hour = 0;
        int answer_total = 0;        

        //iterate through the array and grab the current element's value, add it to the current tally
        for(int hour = 0; hour < hourCounts.length; hour++) {
            
            current_block_total = hourCounts[hour];
            System.out.println();
            System.out.println("Hour " +  hour + " total is: " + current_block_total);
            
            //iterate one element further in the array, grab that element's value, add it to the current tally
            for (int hour2 = hour + 1; hour2 < hourCounts.length && hour2 < hour + 2; hour2++) {
                
                System.out.println("Hour " + hour2 + " total is: " + hourCounts[hour2]);
                current_block_total = current_block_total + hourCounts[hour2];
                System.out.println("Combined 2 hour total is : " + current_block_total);
                current_hour_block = ("Hour block: " + hour + " & " + hour2);
                System.out.println(current_hour_block);
            }
            
            //on the first iteration, set the highest total and answers to current values
            if (hour == 0) {
                
                highest_block_total = current_block_total;
                answer_hour = hour;
                answer_total = hourCounts[hour];
                answer_hour_block = current_hour_block;
            }
            
            //for all subsequent iterations
            else {
                
                //check to see if we have a new highest total, store it if we do
                if (current_block_total > highest_block_total) {
                    
                    highest_block_total = current_block_total;
                    answer_hour = hour;
                    answer_total = hourCounts[hour];
                    answer_hour_block = current_hour_block;
                }
            }
        }
        
        //print out some bullshit (i.e. the results)
        System.out.println("Busiest hour block is: " + answer_hour_block + " and the busiest hour was " + answer_hour + " which was accessed " + answer_total + " time(s)"); //print some bullshit
    }
}

