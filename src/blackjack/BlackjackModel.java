package blackjack;
import java.util.ArrayList;
import java.util.Arrays;

import mvc.*;

public class BlackjackModel extends AbstractModel{
	Deck deck = new Deck();
	Player player = new Player();
	Dealer dealer = new Dealer();
	//TODO Initialize Game
	public void startGame(){
		player.setHand(new ArrayList<Card>(Arrays.asList(deck.generateHand())));
		player.setMoney(0);
		dealer.setHand(new ArrayList<Card>(Arrays.asList(deck.generateHand())));
		System.out.println("Model: startGame.");
        ModelEvent me = new ModelEvent(this, 1, "", player.getHand(), player.getMoney(), dealer.getHand());
        notifyChanged(me);
	}
	// TODO Make method to update Player hand
	public void Hit(){
		ArrayList<Card> current_hand = player.getHand();
		current_hand.add(deck.getNextCard());
		player.setHand(current_hand);
		System.out.println("Model: Hit.");
		ModelEvent me = new ModelEvent(this, 2, "", player.getHand(), player.getMoney(), dealer.getHand());
		notifyChanged(me);
	}
	
	// TODO Make method to update Dealer hand
	
	// TODO Make method to refresh hands
	
	// TODO Make method to evaluate hands
	
	// TODO Make method to update Player funds
	
	// TODO Make method to evaluate Player funds
	
}
