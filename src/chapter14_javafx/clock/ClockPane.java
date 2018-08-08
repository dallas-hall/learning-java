package chapter14_javafx.clock;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.time.LocalDateTime;


/**
 * <h1>ClockPane</h1>
 * <p>
 * This program creates an analogue clock face with JavaFx.
 * </p>
 * <p>
 * tags:	LocalDateTime;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-08-08
 */
public class ClockPane extends Pane
{
	//@@@ CLASS VARIABLES @@@
	private int hour;
	private int minute;
	private int second;
	
	private double clockWidth = 250;
	private double clockHeight = 250;
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	
	
	//@@@ CONSTRUCTOR(S) @@@
	public ClockPane()
	{
		setCurrentTime();
	}
	
	public ClockPane(int hour, int minute, int second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paintClock();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getHour()
	{
		return hour;
	}
	
	public int getMinute()
	{
		return minute;
	}
	
	public int getSecond()
	{
		return second;
	}
	
	public double getClockWidth()
	{
		return clockWidth;
	}
	
	public double getClockHeight()
	{
		return clockHeight;
	}
	
	//### SETTERS ###
	public void setHour(int hour)
	{
		this.hour = hour;
		paintClock();
	}
	
	public void setMinute(int minute)
	{
		this.minute = minute;
		paintClock();
	}
	
	public void setSecond(int second)
	{
		this.second = second;
		paintClock();
	}
	
	public void setClockWidth(double clockWidth)
	{
		this.clockWidth = clockWidth;
		paintClock();
	}
	
	public void setClockHeight(double clockHeight)
	{
		this.clockHeight = clockHeight;
		paintClock();
	}
	
	public void setCurrentTime()
	{
		LocalDateTime localDateTime = LocalDateTime.now();
		
		this.hour = localDateTime.getHour();
		this.minute = localDateTime.getMinute();
		this.second = localDateTime.getSecond();
		
		paintClock();
	}
	
	//### HELPERS ###
	protected void paintClock()
	{
		double clockRadius = Math.min(clockWidth, clockHeight) * 0.8 * 0.5;
		double centreX = clockWidth / 2;
		double centreY = clockHeight / 2;
		
		Circle clockFace = new Circle(centreX, centreY, clockRadius);
		clockFace.setFill(Color.WHITE);
		clockFace.setStroke(Color.BLACK);
		
		Text number12 = new Text(centreX - 5, centreY - clockRadius + 12, "12");
		Text number3 = new Text(centreX + clockRadius - 10, centreY + 3, "3");
		Text number6 = new Text(centreX - 3, centreY + clockRadius - 3, "6");
		Text number9 = new Text(centreX - clockRadius + 3, centreY + 5, "9");
		
		double secondHandLength = clockRadius * 0.8;
		double secondHandX = centreX + secondHandLength * Math.sin(second * (2 * Math.PI / 60));
		double secondHandY = centreY - secondHandLength * Math.cos(second * (2 * Math.PI / 60));
		Line secondHandLine = new Line(centreX, centreY, secondHandX, secondHandY);
		secondHandLine.setStroke(Color.RED);
		
		double minuteHandLength = clockRadius * 0.65;
		double minuteHandX = centreX + minuteHandLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteHandY = centreY - minuteHandLength * Math.cos(minute * (2 * Math.PI / 60));
		Line minuteHandLine = new Line(centreX, centreY, minuteHandX, minuteHandY);
		minuteHandLine.setStroke(Color.BLUE);
		
		double hourHandLength = clockRadius * 0.5;
		double hourHandX = centreX + hourHandLength * Math.sin(hour * (2 * Math.PI / 60));
		double hourHandY = centreY - hourHandLength * Math.cos(hour * (2 * Math.PI / 60));
		Line hourHandLine = new Line(centreX, centreY, hourHandX, hourHandY);
		hourHandLine.setStroke(Color.GREEN);
		
		this.getChildren().clear();
		this.getChildren().addAll(clockFace, number12, number3, number6, number9, secondHandLine, minuteHandLine, hourHandLine);
	}
	//@@@ INNER CLASS(ES) @@@
}
