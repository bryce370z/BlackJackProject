package blackjack;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Person{
	private int money = 0;
	public Player(){
		setScore(0);
		setHand(new ArrayList<Card>(Arrays.asList(new Card[2])));
		setMoney(0);
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return this.money;
	}
}
