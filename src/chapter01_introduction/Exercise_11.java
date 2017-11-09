/**
 *
 */
package chapter01_introduction;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 4 Mar 2017
 * @program: population projection
 * <p>
 * one birth every 7 seconds
 * one death every 13 seconds
 * one immigrant every 45 seconds
 * current population = 312,032,486
 * year = 365 (no leap years considered)
 */
public class Exercise_11
{
	
	public static void main(String[] args)
	{
		
		final int seconds_between_births = 7;
		final int seconds_between_deaths = 13;
		final int seconds_between_immigrants = 45;
		//per minute: 60 seconds / seconds_between_item = how many per minute
		final double births_per_minute = (60 / seconds_between_births);
		final double deaths_per_minute = (60 / seconds_between_deaths);
		final double immigrants_per_minute = (60 / seconds_between_immigrants);
		//per hour: rate_in_minutes * 60 minutes = how many per hour
		final double births_per_hour = (births_per_minute * 60);
		final double deaths_per_hour = (deaths_per_minute * 60);
		final double immigrants_hour = (immigrants_per_minute * 60);
		//per day: rate_in_hours * 24 minutes = how many per day
		final double births_per_day = (births_per_hour * 24);
		final double deaths_per_day = (deaths_per_hour * 24);
		final double immigrants_day = (immigrants_hour * 24);
		//per year: rate_in_days * 365 days = how many per year (assuming no leap years)
		final double births_per_year = (births_per_day * 365);
		final double deaths_per_year = (deaths_per_day * 365);
		final double immigrants_year = (immigrants_day * 365);
		//people
		final int starting_population = 312032486;
		
		System.out.println("Starting population: " + starting_population);
		System.out.println("Births per year: " + births_per_year);
		System.out.println("Deaths per year: " + deaths_per_year);
		System.out.println("Immigrations per year: " + immigrants_year);
		System.out.println("The projected population after 1 year is: " + (starting_population + (births_per_year) - (deaths_per_year) + (immigrants_year)));
		System.out.println("The projected population after 2 years is: " + (starting_population + (births_per_year * 2) - (deaths_per_year * 2) + (immigrants_year * 2)));
		System.out.println("The projected population after 3 years is: " + (starting_population + (births_per_year * 3) - (deaths_per_year * 3) + (immigrants_year * 3)));
		System.out.println("The projected population after 4 years is: " + (starting_population + (births_per_year * 4) - (deaths_per_year * 4) + (immigrants_year * 4)));
		System.out.println("The projected population after 5 years is: " + (starting_population + (births_per_year * 5) - (deaths_per_year * 5) + (immigrants_year * 5)));
		
	}
}
