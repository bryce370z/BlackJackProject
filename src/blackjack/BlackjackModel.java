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
        ModelEvent me = new ModelEvent(this, 1, "", player.getHand().get(0), player.getMoney(), player.getName());
        notifyChanged(me);
        me = new ModelEvent(this, 1, "", player.getHand().get(1), player.getMoney(), player.getName());
        notifyChanged(me);
        me = new ModelEvent(this, 1, "", dealer.getHand().get(0), player.getMoney(), dealer.getName());
        notifyChanged(me);
        me = new ModelEvent(this, 1, "", dealer.getHand().get(1), player.getMoney(), dealer.getName());
        notifyChanged(me);
		System.out.println("Model: startGame.");
	}
	// TODO Make method to update hand
	public void Hit(Person person){
		ArrayList<Card> current_hand = person.getHand();
		Card next_card = deck.getNextCard();
		current_hand.add(next_card);
		person.setHand(current_hand);
		System.out.println("Model: Hit.");
		ModelEvent me = new ModelEvent(this, 2, "", next_card, player.getMoney(), person.getName());
		notifyChanged(me);
	}
	
	public void Stay(){
		System.out.println("Model: Stay.");
		// Will be a dealer action only
	}
	
	// TODO Make method to update Dealer hand
	
	// TODO Make method to refresh hands
	
	// TODO Make method to evaluate hands
	
	// TODO Make method to update Player funds
	
	// TODO Make method to evaluate Player funds
	
	public Player getPlayer(){
		return this.player;
	}
	
}
