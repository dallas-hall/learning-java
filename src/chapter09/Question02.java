/**
 *
 */
package chapter09;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 17 Apr 2017
 * @program:
 */
public class Question02
{
	
	/**
	 * @param args
	 */
	
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;
	
	public Question02(String symbol, String name, double previousClosingPrice, double currentPrice)
	{
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = previousClosingPrice;
		this.currentPrice = currentPrice;
	}
	
	public double getCurrentPrice()
	{
		return this.currentPrice;
	}
	
	public double getPreviousPrice()
	{
		return this.previousClosingPrice;
	}
	
	// https://www.mathsisfun.com/numbers/percentage-change.html
	// Step 1: Divide the New Value by the Old Value (you will get a decimal
	// number)
	// Step 2: Convert that to a percentage (by multiplying by 100 and adding a
	// "%" sign)
	// Step 3: Subtract 100% from that
	public double getPercentChange()
	{
		return (((getCurrentPrice() / getPreviousPrice()) * 100) - 100);
	}
	
	public static void main(String[] args)
	{
		Question02 stock1 = new Question02("ORCL", "Oracle Corp.", 34.5, 34.35);
		System.out.println("Previous price: " + stock1.getPreviousPrice());
		System.out.println("Current price: " + stock1.getCurrentPrice());
		System.out.println("Percentage change: " + stock1.getPercentChange());
	}
}
