package chapter15_event_driven_programming;

import chapter12_exceptions_and_text_io.Question04.LoanCalculator;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * <h1>LoanCalculatorJavaFX</h1>
 * <p>
 * This program gets user input, uses the LoanCalculator from chapter 12, and displays the information in a JavaFX GUI.
 * </p>
 * <p>
 * tags:	lambda; setText; getText;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-09-03
 */
public class LoanCalculatorJavaFX extends Application
{
	//@@@ CLASS VARIABLES @@@
	private TextField textField_annualInterestRate = new TextField();
	private TextField textField_numberOfYears = new TextField();
	private TextField textField_loanAmount = new TextField();
	private TextField textField_monthlyPayment = new TextField();
	private TextField textField_totalPayment = new TextField();
	private Button button_calculate = new Button("Calculate");
	
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	//@@@ JAVAFX @@@
	@Override
	public void start(Stage primaryStage)
	{
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Annual Interest Rate"), 0, 0);
		gridPane.add(textField_annualInterestRate, 1, 0);
		gridPane.add(new Label("Number of Years"), 0, 1);
		gridPane.add(textField_numberOfYears, 1, 1);
		gridPane.add(new Label("Loan Amount"), 0, 2);
		gridPane.add(textField_loanAmount, 1, 2);
		gridPane.add(new Label("Monthly Payment"), 0, 3);
		gridPane.add(textField_monthlyPayment, 1, 3);
		gridPane.add(new Label("Total Payment"), 0, 4);
		gridPane.add(textField_totalPayment, 1, 4);
		gridPane.add(button_calculate, 1, 5);
		
		gridPane.setAlignment(Pos.CENTER);
		textField_annualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
		textField_numberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
		textField_loanAmount.setAlignment(Pos.BOTTOM_RIGHT);
		textField_monthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
		textField_totalPayment.setAlignment(Pos.BOTTOM_RIGHT);
		textField_monthlyPayment.setEditable(false);
		textField_totalPayment.setEditable(false);
		GridPane.setHalignment(button_calculate, HPos.RIGHT);
		
		button_calculate.setOnAction(e -> calculateLoanPayment());
		
		Scene scene = new Scene(gridPane, 640, 480);
		primaryStage.setTitle("LoanCalculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	//@@@ METHODS @@@
	//### HELPERS ###
	private void calculateLoanPayment()
	{
		double interest = Double.parseDouble(textField_annualInterestRate.getText());
		int year = Integer.parseInt(textField_numberOfYears.getText());
		double loanAmount = Double.parseDouble(textField_loanAmount.getText());
		
		LoanCalculator loanCalculator = new LoanCalculator(interest, year, loanAmount);
		
		textField_monthlyPayment.setText(String.format("$%.2f", loanCalculator.getMonthlyPayment()));
		textField_totalPayment.setText(String.format("$%.2f", loanCalculator.getTotalPayment()));
	}
}
