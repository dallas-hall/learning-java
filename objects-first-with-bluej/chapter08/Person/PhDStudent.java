
/**
 * Write a description of class Teacher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhDStudent extends Student
{
    private String thesis;

    public PhDStudent (String name, String major, boolean graduated, String thesis)
    {
        super(name, major, graduated);
        this.thesis = thesis;
    }

    public String getThesis()
    {
        return thesis;
    }
}
