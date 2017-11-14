package blackjack;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
	private Card[] deck;
	private int nextCard;
	
	public Deck(){
		/*
		 * Constructs a shuffled deck of cards
		 */
		this.deck = this.buildDeck();
		this.shuffle();
		this.nextCard = 0;
	}
	
	public Card[] getCards(){
		/*
		 * Accessor for deck attribute
		 */
		return this.deck;
	}
	
	private Card[] buildDeck(){
		/*
		 * Builds a 52 card deck
		 */
		int size = 52;
		Card[] init_deck = new Card[size];
		int arr_index = 0;
		// suits of a cards
		String[] card_suit = {"hearts", "spades", "clubs", "diamonds"};
		// types of cards
		String[] card_type = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
		// create Card objects relative to size of deck
		for(int i = 0; i < card_suit.length; i++){
			for(int j = 0; j < card_type.length; j++){
				String suit = card_suit[i];
				String type = card_type[j];
				int value = findValue(type);
				String img_path = "cards/" + type + "_of_" + suit + ".png";
				init_deck[arr_index] = new Card(value, suit, type, img_path);
				arr_index++;
			}
		}
		
		return init_deck;
	}
	
	private int findValue(String type){
		/*
		 * Helper function for the Deck Builder. Finds the point value of a card based on its type.
		 */
		int value;
		switch(type){
		case "2":
			value = 2;
			break;
		case "3":
			value = 3;
			break;
		case "4":
			value = 4;
			break;
		case "5":
			value = 5;
			break;
		case "6":
			value = 6;
			break;
		case "7":
			value = 7;
			break;
		case "8":
			value = 8;
			break;
		case "9":
			value = 9;
			break;
		case "ace":
			value = 11;
			break;
		default:
			value = 10;
			break;
		}
		return value;
	}
	
	public Card getNextCard(){
		/*
		 * Gets next card in the array. Resets index and shuffles deck, if last card is picked
		 */
		Card next_card = this.deck[this.nextCard];
		this.nextCard++;
		if(this.nextCard == 52){
			this.nextCard = 0;
			this.shuffle();
		}
		return next_card;
	}
	
	public Card[] generateHand(){
		/*
		 * Generates a 2 card hand from the deck
		 */
		Card [] hand = new Card[2];
		hand[0] = getNextCard();
		hand[1] = getNextCard();
		return hand;
	}
	public void shuffle(){
		/*
		 * Shuffles an array of cards using the Collections class
		 */
		Collections.shuffle(Arrays.asList(this.deck));
	}

}
