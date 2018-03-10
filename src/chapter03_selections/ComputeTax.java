/**
 * <h1>Calculate Tax</h1>
 * <p>
 * This program will Calculate the taxable income based on the person's current marital status.
 * </p>
 * <p>
 * tags:	String printing; math; Scanner; nextDouble; for loop; switch; case; nested if;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-03-13
 */
package chapter03_selections;

import java.util.Scanner;

public class ComputeTax
{
    public static void main(String[] args)
    {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter filing status
        System.out.print("0-single filer\n"
                + "1-married jointly or qualifying widow(er)\n"
                + "2-married separately"
                + "\n3-head of household\n"
                + "Enter the filing status: ");

        int status = input.nextInt();

        // Prompt the user to enter taxable income
        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();

        // Compute tax
        double tax = 0;
        
        //does the same as nested if
       
        switch (status)
        {
            case 0: //compute tax single filer
            
                if (income <= 8350)
                {
                    tax = income * 0.10;
                }
                else if (income <= 33950)
                {
                    tax = 8350 * 0.10 + (income - 8350) * 0.15;
                }
                else if (income <= 82250)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (income - 33950) * 0.25;
                }
                else if (income <= 171550)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
                }
                else if (income <= 372950)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                            + (income - 171550) * 0.33;
                }
                else
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                            + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
                }
            
            break;
            
            case 1: //compute tax for married jointly or qualifying widow(er);
                
                if (income <= 16700)
                {
                    tax = income * 0.10;
                }
                else if (income <= 67900)
                {
                    tax = 8350 * 0.10 + (income - 8350) * 0.15;
                }
                else if (income <= 137050)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (income - 33950) * 0.25;
                }
                else if (income <= 208850)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
                }
                else if (income <= 372950)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                            + (income - 171550) * 0.33;
                }
                else
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                            + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
                }
                
            break;
            
            case 2: //compute tax for married filing separately;
            
                if (income <= 8350)
                {
                    tax = income * 0.10;
                }
                else if (income <= 33950)
                {
                    tax = 8350 * 0.10 + (income - 8350) * 0.15;
                }
                else if (income <= 68525)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (income - 33950) * 0.25;
                }
                else if (income <= 104425)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
                }
                else if (income <= 186475)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                            + (income - 171550) * 0.33;
                }
                else
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                            + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
                }
                
            break;
            
            case 3: //compute tax for head of household;
                
                if (income <= 11950)
                {
                    tax = income * 0.10;
                }
                else if (income <= 45500)
                {
                    tax = 8350 * 0.10 + (income - 8350) * 0.15;
                }
                else if (income <= 117450)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (income - 33950) * 0.25;
                }
                else if (income <= 190200)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
                }
                else if (income <= 372950)
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                            + (income - 171550) * 0.33;
                }
                else
                {
                    tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                            + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                            + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
                }
                
            break;
            
            default: System.out.println("Error: invalid status");
            System.exit(1);
        }
   
        /*
        if (status == 0)
        { // Compute tax for single filers
            if (income <= 8350)
            {
                tax = income * 0.10;
            }
            else if (income <= 33950)
            {
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            }
            else if (income <= 82250)
            {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (income - 33950) * 0.25;
            }
            else if (income <= 171550)
            {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
            }
            else if (income <= 372950)
            {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                        + (income - 171550) * 0.33;
            }
            else
            {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                        + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
            }
        }
        // Compute tax for married file jointly or qualifying widow(er)
        else if (status == 1)
        {
            if (income <= 8350)
            {
                tax = income * 0.10;
            }
            else if (income <= 33950)
            {
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            }
            else if (income <= 82250)
            {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (income - 33950) * 0.25;
            }
            else if (income <= 171550)
            {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
            }
            else if (income <= 372950)
            {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                        + (income - 171550) * 0.33;
            }
            else
            {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                        + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
            }          
        }
        // Compute tax for married separately
        else if (status == 2)
        { 

        }
        // Compute tax for head of household
        else if (status == 3)
        { 
       
        } 
        else
        {
            System.out.println("Error: invalid status");
            System.exit(1);
        }
        */
        
        // Display the result
        System.out.println("Tax is " + (int) (tax * 100) / 100.0);
    }
}