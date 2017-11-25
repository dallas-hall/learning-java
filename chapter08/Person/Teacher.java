
/**
 * Write a description of class Teacher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teacher extends Person
{
    private int salary;
    
    public Teacher (String name, int salary)
    {
        super(name);
        this.salary = salary;
    }
    
    public int getSalary()
    {
        return salary;
    }
}
