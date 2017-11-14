package blackjack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import mvc.*;

public class BlackjackModel extends AbstractModel{
	Deck deck = new Deck();
	Player player = new Player();
	Dealer dealer = new Dealer();
	String winner = "pending";
	//TODO Initialize Game
	public void startGame(){
		player.setHand(new ArrayList<Card>(Arrays.asList(deck.generateHand())));
		player.setMoney(0);
		dealer.setHand(new ArrayList<Card>(Arrays.asList(deck.generateHand())));
		Card player_card1 = player.getHand().get(0);
		Card player_card2 = player.getHand().get(1);
		Card dealer_card1 = dealer.getHand().get(0);
		Card dealer_card2 = dealer.getHand().get(1);
		updateScore(player, player_card1);
		updateScore(player, player_card2);
		updateScore(dealer, dealer_card1);
		updateScore(dealer, dealer_card2);
        ModelEvent me = new ModelEvent(this, 1, "", player_card1, player.getMoney(), player.getName(), winner);
        notifyChanged(me);
        me = new ModelEvent(this, 1, "", player_card2, player.getMoney(), player.getName(), winner);
        notifyChanged(me);
        me = new ModelEvent(this, 1, "", dealer_card1, player.getMoney(), dealer.getName(), winner);
        notifyChanged(me);
        me = new ModelEvent(this, 1, "", dealer_card2, player.getMoney(), dealer.getName(), winner);
        notifyChanged(me);
		// System.out.println("Model: startGame.");
	}
	// TODO Make method to update hand
	public void Hit(Person person){
		person.setStayed(false);
		ArrayList<Card> current_hand = person.getHand();
		Card next_card = deck.getNextCard();
		updateScore(person, next_card);
		evalPersonScore(person);
		current_hand.add(next_card);
		person.setHand(current_hand);
		// System.out.println("Model: Hit.");
		ModelEvent me = new ModelEvent(this, 2, "", next_card, player.getMoney(), person.getName(), winner);
		notifyChanged(me);
	}
	
	public void playerHit(){
		Hit(player);
		dealerDecision();
		System.out.println("Model: playerHit.");
	}
	
	public void dealerHit(){
		Hit(dealer);
		System.out.println("Model: dealerHit.");
	}
	
	public void Stay(Person person){
		person.setStayed(true);
		evalPersonScore(person);
		// System.out.println("Model: Stay.");
	}
	
	public void playerStay(){
		Stay(player);
		System.out.println("Model: playerStay.");
		dealerDecision();
	}
	
	public void dealerStay(){
		Stay(dealer);
		System.out.println("Model: dealerStay.");
	}
	
	public void dealerDecision(){
		
		if(playerGreaterOrEqual()){
			dealerHit();
		}
		else{
			dealerStay();
		}
	}
	
	public boolean playerGreaterOrEqual(){
		if(player.getScore() >= dealer.getScore()){
			return true;
		}
		return false;
	}
	
	// TODO Make method to evaluate hands
	public void updateScore(Person person, Card card){
		person.setScore(person.getScore() + card.getValue());
		System.out.println(person.getName() + " " + person.getScore());
	}
	
	public void evalPersonScore(Person person){
		int score = person.getScore();
		String name = person.getName();
		Person other = dealer;
		int other_score = other.getScore();
		String other_name = other.getName();
		
		if(name == "Dealer"){
			other = player;
			other_score = player.getScore();
			other_name = player.getName();
		}
		if(score == 21){
			winner = name;
		}
		else if(score > 21){
			winner = other_name;
		}
		else{
			if(dealer.getStayed() && player.getStayed()){
				if(score > other_score){
					winner = name;
				}
				else{
					winner = other_name;
				}
			}
		}
		// System.out.println("THE WINNER IS: " + winner);
		
	}
	public Player getPlayer(){
		return this.player;
	}
	
}
