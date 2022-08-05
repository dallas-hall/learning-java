
/**
 * Write a description of class TestClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestClass
{
    private MusicOrganizer musicOrg1;
    private MusicPlayer musicPly1;

    public TestClass()
    {
        setUpData();
    }

    private void setUpData()
    {
        musicOrg1 = new MusicOrganizer();
        musicPly1 = new MusicPlayer();
        musicOrg1.setUpData(); 
    }
    
    /**
     * Play song 1
     */
    public void test01()
    {
        musicOrg1.listFile(0);
        musicOrg1.startPlaying(0);
    }
    
    /**
     * Play song 2
     */
    public void test02()
    {
        musicOrg1.listFile(1);
        musicOrg1.startPlaying(1);    
    }
    
    /**
     * Play song 3
     */
    public void test03()
    {
        musicOrg1.listFile(2);        
        musicOrg1.startPlaying(2);   
    }
    
    /**
     * Play song 4
     */
    public void test04()
    {
        musicOrg1.listFile(3);        
        musicOrg1.startPlaying(3);           
    }

    /**
     * Play any song from user input
     */
    public void test05(int index)
    {
        musicOrg1.startPlaying(index);           
    }
    
    /**
     * stop song
     */
    public void testStopSong()
    {
        System.out.println("Stopping the current song.");
        musicOrg1.stopPlaying();
    }
    
    /**
     * remove file
     */
    public void testRemoveFile(int index)
    {
        musicOrg1.removeFile(index);
    }
    
    /**
     * list 1 file
     */
    public void testListFile(int index)
    {
        musicOrg1.listFile(index);
    }
    
    /**
     * list all files - using for each loop WITHOUT counter
     */
    public void testListAllFiles1()
    {
        musicOrg1.listAllFiles();
    } 
    
     /**
     * list all files - using for each loop WITH counter
     */
    public void testListAllFiles2()
    {
        musicOrg1.listAllFiles2();
    }    

     /**
     * list all files - using for each loop WITH counter
     */
    public void testListFileByName(String searchString)
    {
        musicOrg1.listMatching(searchString);
    }     
    
    /*
     * readd a file after deleting
     */
    public void testAddFile(int fileNumber)
    {
        if(fileNumber == 1) {
            musicOrg1.addFile("audio/BigBillBroonzy-BabyPleaseDontGo1.mp3");
        }
        else if (fileNumber == 2) {
            musicOrg1.addFile("audio/BlindBlake-EarlyMorningBlues.mp3");            
        }
        else if (fileNumber == 3) {
            musicOrg1.addFile("audio/BlindLemonJefferson-matchBoxBlues.mp3"); 
        }
        else if (fileNumber == 4) {    
            musicOrg1.addFile("audio/BlindLemonJefferson-OneDimeBlues.mp3");
        }
        else {
            System.out.println("Wrong file number - must be between 1 and 4");
        }
    }
}
