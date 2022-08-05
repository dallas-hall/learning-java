public class Compare
{
    public static void main (String[] args)
    {
        int y = 5;
        int z = 8;
        
        int x1 = y++ + z++;
        int x2 = y++ + ++z;
        int x3 = ++y + z++;
        int x4 = ++y + ++z;
        
        System.out.println("x = y++ + z++ which is:" + x1);
        System.out.println("x = y++ + ++z which is:" + x2);
        System.out.println("x = ++y + z++ which is:" + x3);
        System.out.println("x = ++y + ++z which is:" + x4);
    }
}