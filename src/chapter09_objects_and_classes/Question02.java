package chapter09_objects_and_classes;

/**
 * <h1>Rectangle</h1>
 * <p>
 * This program creates a Stock object holding the current price and previous price, it can calculate the change as a percentage.
 * </p>
 * <p>
 * tags:	constructor; getter; setter; percentage change;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-17
 */
public class Question02
{
	//@@@ INSTANCE VARIABLES @@@
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Question02 stock1 = new Question02("ORCL", "Oracle Corp.", 34.5, 34.35);
		System.out.println("Previous price: " + stock1.getPreviousPrice());
		System.out.println("Current price: " + stock1.getCurrentPrice());
		System.out.println("Percentage change: " + stock1.getPercentChange());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question02(String symbol, String name, double previousClosingPrice, double currentPrice)
	{
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = previousClosingPrice;
		this.currentPrice = currentPrice;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getCurrentPrice()
	{
		return this.currentPrice;
	}
	
	public double getPreviousPrice()
	{
		return this.previousClosingPrice;
	}
	
	/*
	https://www.mathsisfun.com/numbers/percentage-change.html
	Step 1: Divide the New Value by the Old Value (you will get a decimal number)
	Step 2: Convert that to a percentage (by multiplying by 100 and adding a "%" sign)
	Step 3: Subtract 100% from that
	*/
	public double getPercentChange()
	{
		return (((getCurrentPrice() / getPreviousPrice()) * 100) - 100);
	}
	
	

}
