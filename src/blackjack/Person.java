package blackjack;

import java.util.ArrayList;

public abstract class Person {
	private int score;
	private ArrayList<Card> hand;
	private String name;
	private boolean stayed;
		
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
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setStayed(boolean stayed){
		this.stayed = stayed;
	}
	
	public boolean getStayed(){
		return this.stayed;
	}
		
}
