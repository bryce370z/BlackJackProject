package blackjack;

import java.util.ArrayList;

public abstract class Person {
	private int score;
	private ArrayList<Card> hand;
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setHand(ArrayList<Card> hand){
		this.hand = hand;
	}
	
	public ArrayList<Card> getHand(){
		return this.hand;
	}
		
}
