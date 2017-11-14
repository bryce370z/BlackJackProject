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
		dealer.setHand(new ArrayList<Card>(Arrays.asList(deck.generateHand())));
		System.out.println("Model Activated.");
        ModelEvent me = new ModelEvent(this, 1, "", player.getHand(), dealer.getHand());
        notifyChanged(me);
	}
	// TODO Make method to update Player hand
	
	// TODO Make method to update Dealer hand
	
	// TODO Make method to refresh hands
	
	// TODO Make method to evaluate hands
	
	// TODO Make method to update Player funds
	
	// TODO Make method to evaluate Player funds
	
}
