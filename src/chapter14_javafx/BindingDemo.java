package chapter14_javafx;
/*
 * <h1>BindingDemo</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-29
 */

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;

public class BindingDemo
{

	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		DoubleProperty doubleProperty1 = new SimpleDoubleProperty(1);
		DoubleProperty doubleProperty2 = new SimpleDoubleProperty(2);
		// bind 1 to 2, so 1 listens for the changes in 2. 1 cannot change without 2 changing.
		System.out.println("[INFO] Unidirectional Binding.");
		doubleProperty1.bind(doubleProperty2);
		System.out.println("doubleProperty1: " + doubleProperty1.getValue());
		System.out.println("doubleProperty2: " + doubleProperty1.getValue());
		doubleProperty2.setValue(46.2);
		System.out.println("doubleProperty1: " + doubleProperty1.getValue());
		System.out.println("doubleProperty2: " + doubleProperty1.getValue());
		// update to bi-directional binding
		System.out.println("[INFO] Bidirectional Binding.");
		doubleProperty1.unbind();
		doubleProperty1.bindBidirectional(doubleProperty2);
		doubleProperty1.setValue(8);
		System.out.println("doubleProperty1: " + doubleProperty1.getValue());
		System.out.println("doubleProperty2: " + doubleProperty1.getValue());
		doubleProperty2.setValue(22);
		System.out.println("doubleProperty1: " + doubleProperty1.getValue());
		System.out.println("doubleProperty2: " + doubleProperty1.getValue());
	}
}
