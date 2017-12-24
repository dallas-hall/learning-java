/**
 * 
 */
package chapter01_introduction.string_printing;

/**
 * @author:		blindcant
 * @version:	0.1
 * @date:		4 Mar 2017
 * @program:	compute the perimeter / area of a circle
 * @tags: String printing; PI
 */
public class Exercise_08 {

    public static void main(String[] args) {
        
        //declare variables
        double radius = 5.5;
        double PI = Math.PI;
        
        //calculations
        System.out.println("Circle perimeter formula = 2 x radius x π");
        System.out.println("Circle area forumla = radius x radius x π");
        System.out.println("radius = " + radius);
        System.out.println("π = " + PI);
        System.out.println("Perimeter = " + (2 * radius * PI));
        System.out.println("Area = " + (radius * radius * PI));
        }
}
