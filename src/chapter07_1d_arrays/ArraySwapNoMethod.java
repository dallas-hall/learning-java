/**
 * 
 */
package chapter07_1d_arrays;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 25 Mar 2017
 * @program:
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
// public class Test
// {
// public static void main(String[] args)
// {
// int[] list = {1, 2, 3, 5, 4};
//
// for (int i = 0; i < list.length; i++)
// {
// System.out.print(list[i]);
// }
// System.out.println();
//
// for (int i = 0, j = list.length - 1; i < list.length; i++, j--)
// {
// System.out.println("Before Swap: " + list[i] + " " + list[j]);
// // Swap list[i] with list[j]
// int temp = list[i];
// list[i] = list[j];
// list[j] = temp;
// System.out.println("After Swap: " + list[i] + " " + list[j]);
// for (int i2 = 0; i2 < list.length; i2++)
// {
// System.out.print(list[i2]);
// }
// System.out.println();
// }
//
// for (int i = 0; i < list.length; i++)
// {
// System.out.print(list[i]);
// }
// }
// }