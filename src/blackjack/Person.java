package blackjack;

import java.util.ArrayList;

public abstract class Person {
	private int score;
	private ArrayList<Card> hand;
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	public void setHand(ArrayList<Card> hand){
		this.hand = hand;
	}
	
	public ArrayList<Card> getHand(){
		return this.hand;
	}
		
}
