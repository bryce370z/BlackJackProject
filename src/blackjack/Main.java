package blackjack;

public class Main {

	public static void main(String[] args) {
		/*
		Deck deck = new Deck();
		Card [] cards = deck.getCards();
		for(int i = 0; i < cards.length; i++){
			Card card = cards[i];
			System.out.println("VALUE: " + card.getValue() + " SUIT: " + card.getSuit() + " TYPE: " + card.getType()
					+ " PATH: " + card.getImg_Path());
		}
		*/
		new BlackjackController();

	}

}
