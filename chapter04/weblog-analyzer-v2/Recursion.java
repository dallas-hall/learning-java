
/**
 * Write a description of class Recursion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recursion
{
    public static void main(String[] args)
    {
        recursivePrint(1);
    }
   
    static void recursivePrint(int i)
    {
        System.out.printf("%4d ", i);
        i++;
        if (i <= 10)
        {
            recursivePrint(i);
        }
    }
}
