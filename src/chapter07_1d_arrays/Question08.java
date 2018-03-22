package chapter07_1d_arrays;

import java.util.Scanner;

/**
 * <h1>Number Average</h1>
 * <p>
 * This program will accept number inputs and then return the average of them as an int and double.
 * </p>
 * <p>
 * tags:	Scanner; nextInt; for loop;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-17
 */
public class Question08
{
    public static void main(String[] args)
    {

        Scanner keyboard = new Scanner(System.in);
        double[] number = new double[10];
        
        for (int i = 0; i < number.length; i++)
        {
            System.out.print("Enter number: ");
            number[i] = Double.parseDouble(keyboard.nextLine());
        }
        
        average(number);
        
        int[] numberInt = new int[number.length];
        for (int i = 0; i < number.length; i++)
        {
            numberInt[i] = (int) number[i];
        }
        average(numberInt);
    }

    public static int average(int[] array)
    {
        int sum = 0;
        int average = 0;
        for (int i = 0; i < array.length; i++)
        {
            sum+=array[i];
        }
        
        average = sum / array.length;
        System.out.println(average);
        return average;
    }
    
    public static double average(double[] array)
    {
        double sum = 0;
        double average = 0;
        for (int i = 0; i < array.length; i++)
        {
            sum+=array[i];
        }
        
        average = sum / array.length;
        System.out.println(average);
        return average;
    }
}
