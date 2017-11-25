
/**
 * Write a description of class TestClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestClass
{
    private MusicOrganizer musicOrg1;

    public TestClass()
    {
        setUpData();
    }

    private void setUpData() //only accessed within the class, not externally
    {
        musicOrg1 = new MusicOrganizer();
        musicOrg1.addFile("Davynals - I touch myself.mp3");
        musicOrg1.addFile("Madonnnnnnnna - Like a fukn virgin.flac");
        musicOrg1.addFile("David Guerta - Fuk me im famouz.mp3");   
    }
    
    public void test01()
    {
        musicOrg1.checkIndex(0); //return song - inside index range of 0-2
        musicOrg1.validIndex(0); //true - inside index range of 0-2
        musicOrg1.checkIndex(1); //return song - inside index range of 0-2 
        musicOrg1.validIndex(1); //true - inside index range of 0-2
        musicOrg1.checkIndex(2); //return song - inside index range of 0-2
        musicOrg1.validIndex(2); //true - inside index range of 0-2
        musicOrg1.checkIndex(3); //error - outside index range of 0-2
        musicOrg1.validIndex(3); //false - outside index range of 0-2
    }
    
    public void test02()
    {
        musicOrg1.listFile(0); //return song - inside index range of 0-2
        musicOrg1.listFileRewrite(1); //return song - inside index range of 0-2
        musicOrg1.listFileRewrite(2); //return song - inside index range of 0-2     
        musicOrg1.listFileRewrite(3); //error - outside index range of 0-2
    }
    
    public void test03()
    {
        musicOrg1.listFileRewrite(1); //return song - inside index range of 0-2
        musicOrg1.removeFile(1); //remove file - inside index range of 0-2
        musicOrg1.listFileRewrite(1); //return song - inside index range of 0-1 (note 2 is now 1)
        musicOrg1.listFileRewrite(2); //error - outside index range of 0-1
        musicOrg1.removeFileRewrite(2); //error - outside index range of 0-1
       
    }
}
