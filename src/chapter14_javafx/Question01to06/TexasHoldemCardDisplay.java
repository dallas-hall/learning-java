package chapter14_javafx.Question01to06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>TexasHoldemCardDisplay</h1>
 * <p>
 * This program simulates a final display of 5 cards in Texas Hold`em. It initially removes 10 random cards, to simulate 5 people playing. It then burns 1 card, deals 3, burns 1 card, deals 1, burns 1, and deals the final card.
 * </p>
 * <p>
 * tags:	HBox; HashMap; String[]; boolean[]; Image; ImageView;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-08-11
 */
public class TexasHoldemCardDisplay extends Application
{
	//@@@ CLASS VARIABLES @@@
	private String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
	private String[] ranks = {"AceOf", "TwoOf", "ThreeOf", "FourOf", "FiveOf", "SixOf", "SevenOf", "EightOf", "NineOf", "TenOf", "JackOf", "QueenOf", "KingOf"};
	private boolean[] inDeck = {
		true, true, true, true, true, true, true, true, true, true, true, true, true, true, // Spades
		true, true, true, true, true, true, true, true, true, true, true, true, true, true, // Clubs
		true, true, true, true, true, true, true, true, true, true, true, true, true, true, // Hearts
		true, true, true, true, true, true, true, true, true, true, true, true, true, true  // Diamonds
	};
	private Map<String, String> cards;
	
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
		cards = new HashMap<>();
		for (int i = 1; i <= 13; i++) {
			switch (i) {
				case 1:
					cards.put("AceOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/ace_of_spades.png");
					cards.put("AceOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/ace_of_clubs.png");
					cards.put("AceOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/ace_of_hearts.png");
					cards.put("AceOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/ace_of_diamonds.png");
					break;
				case 2:
					cards.put("TwoOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/2_of_spades.png");
					cards.put("TwoOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/2_of_clubs.png");
					cards.put("TwoOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/2_of_hearts.png");
					cards.put("TwoOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/2_of_diamonds.png");
					break;
				case 3:
					cards.put("ThreeOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/3_of_spades.png");
					cards.put("ThreeOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/3_of_clubs.png");
					cards.put("ThreeOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/3_of_hearts.png");
					cards.put("ThreeOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/3_of_diamonds.png");
					break;
				case 4:
					cards.put("FourOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/4_of_spades.png");
					cards.put("FourOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/4_of_clubs.png");
					cards.put("FourOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/4_of_hearts.png");
					cards.put("FourOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/4_of_diamonds.png");
					break;
				case 5:
					cards.put("FiveOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/5_of_spades.png");
					cards.put("FiveOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/5_of_clubs.png");
					cards.put("FiveOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/5_of_hearts.png");
					cards.put("FiveOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/5_of_diamonds.png");
					break;
				case 6:
					cards.put("SixOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/6_of_spades.png");
					cards.put("SixOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/6_of_clubs.png");
					cards.put("SixOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/6_of_hearts.png");
					cards.put("SixOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/6_of_diamonds.png");
					break;
				case 7:
					cards.put("SevenOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/7_of_spades.png");
					cards.put("SevenOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/7_of_clubs.png");
					cards.put("SevenOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/7_of_hearts.png");
					cards.put("SevenOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/7_of_diamonds.png");
					break;
				case 8:
					cards.put("EightOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/8_of_spades.png");
					cards.put("EightOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/8_of_clubs.png");
					cards.put("EightOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/8_of_hearts.png");
					cards.put("EightOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/8_of_diamonds.png");
					break;
				case 9:
					cards.put("NineOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/9_of_spades.png");
					cards.put("NineOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/9_of_clubs.png");
					cards.put("NineOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/9_of_hearts.png");
					cards.put("NineOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/9_of_diamonds.png");
					break;
				case 10:
					cards.put("TenOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/10_of_spades.png");
					cards.put("TenOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/10_of_clubs.png");
					cards.put("TenOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/10_of_hearts.png");
					cards.put("TenOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/10_of_diamonds.png");
					break;
				case 11:
					cards.put("JackOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/jack_of_spades.png");
					cards.put("JackOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/jack_of_clubs.png");
					cards.put("JackOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/jack_of_hearts.png");
					cards.put("JackOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/jack_of_diamonds.png");
					break;
				case 12:
					cards.put("QueenOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/queen_of_spades.png");
					cards.put("QueenOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/queen_of_clubs.png");
					cards.put("QueenOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/queen_of_hearts.png");
					cards.put("QueenOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/queen_of_diamonds.png");
					break;
				case 13:
					cards.put("KingOfSpades", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/king_of_spades.png");
					cards.put("KingOfClubs", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/king_of_clubs.png");
					cards.put("KingOfHearts", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/king_of_hearts.png");
					cards.put("KingOfDiamonds", "https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/king_of_diamonds.png");
					break;
			}
		}
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(15, 15, 15, 15));
		
		// Remove 10 random cards to simulate 5 players.
		removeCards(10);
		
		// Burn a card
		removeCards(1);
		
		// Deal 3 cards
		for (int i = 0; i < 3; i++) {
			hBox.getChildren().add(new ImageView(new Image(cards.get(dealCard()))));
		}
		
		// Burn a card
		removeCards(1);
		
		// Deal 1 card
		hBox.getChildren().add(new ImageView(new Image(cards.get(dealCard()))));
		
		// Burn a card
		removeCards(1);
		
		// Deal 1 cards
		hBox.getChildren().add(new ImageView(new Image(cards.get(dealCard()))));
		
		// Create and set the Scene
		Scene scene = new Scene(hBox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("DisplayImagesGridPane");
		primaryStage.show();
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	private void removeCards(int amount)
	{
		for (int i = 0; i < amount; i++) {
			while (true) {
				// Random number between 0 and 51 inclusive
				int prn = (int) (Math.random() * 52);
				if (i == 0) {
					inDeck[prn] = false;
				}
				else if (!inDeck[prn]) {
					continue;
				}
				else {
					inDeck[prn] = false;
				}
				System.out.println("[INFO] REMOVED CARD NUMBER " + (i + 1));
				System.out.println("prn: " + prn);
				System.out.println("modulo: " + prn % 13);
				System.out.println("rank: " + ranks[prn % 13]);
				System.out.println("integer division: " + prn / 13);
				System.out.println("suit: " + suits[prn / 13]);
				System.out.println("inDeck: " + inDeck[prn]);
				break;
			}
		}
	}
	
	private String dealCard()
	{
		while (true) {
			// Random number between 0 and 51 inclusive
			int prn = (int) (Math.random() * 52);
			if (inDeck[prn]) {
				System.out.println("[INFO] DEALT CARD");
				System.out.println("prn: " + prn);
				System.out.println("modulo: " + prn % 13);
				System.out.println("rank: " + ranks[prn % 13]);
				System.out.println("integer division: " + prn / 13);
				System.out.println("suit: " + suits[prn / 13]);
				System.out.println("inDeck: " + inDeck[prn]);
				return ranks[prn % 13] + suits[prn / 13];
			}
		}
	}
}
