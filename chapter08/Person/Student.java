
/**
 * Write a description of class Teacher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Person
{
    private String major;
    private boolean graduated;

    public Student (String name, String major, boolean graduated)
    {
        super(name);
        this.major = major;
        this.graduated = graduated;
    }

    public String getMajor()
    {
        return major;
    }
    
    public boolean hasGraduated()
    {
        return graduated;
    }
}
