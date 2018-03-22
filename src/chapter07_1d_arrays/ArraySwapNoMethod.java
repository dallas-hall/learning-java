package chapter07_1d_arrays;

/**
 * <h1>Array Reversing</h1>
 * <p>
 * This program will reverse an array's elements.
 * </p>
 * <p>
 * tags:	array; array-reversal; for loop; System.arraycopy;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-25
 */

public class ArraySwapNoMethod
{
    public static void main(String[] args)
    {
        // create the array
        int[] list = {1, 2, 3, 4, 5};

        // print the array contents
        System.out.print("{");
        for (int i = 0; i < list.length; i++)
        {
            if (i != list.length - 1)
            {
                System.out.print(list[i] + ",");
            }
            else
            {
                System.out.print(list[i]);
            }
        }
        System.out.print("}");
        System.out.println();

        // swap the array elements
        for (int i = 0, j = list.length - 1; i < list.length - 2; i++, j--)
        {
            // create temporary array for copying and swapping
            // int[] temp = new int[1];
            System.out.println("Before Swap:\tlist[" + i + "] is " + list[i]
                    + " & list[" + j + "] is " + list[j]);
            // Swap list[i] with list[j]
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            // System.arraycopy(list, i, temp, 0, 1);
            // System.arraycopy(list, j, list, i, 1);
            // System.arraycopy(temp, 0, list, j, 1);
            System.out.println("After Swap:\tlist[" + i + "] is " + list[i]
                    + " & list[" + j + "] is " + list[j] + " tmp:" + temp);
            System.out.println();
        }

        // print the array contents
        System.out.print("{");
        for (int i = 0; i < list.length; i++)
        {
            if (i != list.length - 1)
            {
                System.out.print(list[i] + ",");
            }
            else
            {
                System.out.print(list[i]);
            }
        }
        System.out.print("}");
        System.out.println();
    }
}