/**
 * 
 */
package chapter07;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 10 Apr 2017
 * @program:
 */
public class SelectionSorting
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // create array
        int[] list = {2, 9, 5, 4, 8, 1, 6};
        // display array
        //printArray(list);
        //use toString to show the array
        System.out.println(java.util.Arrays.toString(list));

        //go through each index once, hold here for inner loop
        for (int i = 0; i < list.length - 1; i++)
        {
            int currentMin = list[i];
            int currentMinIndex = i;
            
            //search the rest of the array and look for a smaller number
            for (int j = i + 1; j < list.length; j++)
            {
                // < is ascending, > is descending
                if (list[j] > currentMin)
                {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            //if one is found and it isn't in the same position, swap
            if (currentMinIndex != i)
            {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        // display array
        System.out.println(java.util.Arrays.toString(list));
    }

    public static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
