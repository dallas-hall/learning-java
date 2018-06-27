package chapter13_abstract_classes_and_interfaces.Question11;

/**
 * <h1>Main</h1>
 * <p>
 * This program is the driver for the Octagon class.
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-27
 */
public class Main
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Octagon octagon = new Octagon();
		System.out.println(octagon.toString());
		Octagon octagon2 = new Octagon("Green", false, 1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d);
		System.out.println(octagon2.toString());
		System.out.println("Do the 2 octagons have the same area? 0 is yes, -1 or 1 for no. " + octagon.compareTo(octagon2));
		System.out.println("Are the 2 octagon objects the same in any way? " + octagon.equals(octagon2));
	}
}
