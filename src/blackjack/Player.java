package blackjack;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Person{
	private int money = 0;
	private boolean stayed;
	public Player(){
		setHand(new ArrayList<Card>(Arrays.asList(new Card[2])));
		setMoney(0);
		setName("Player");
		setStayed(false);
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public void setStayed(boolean stayed){
		this.stayed = stayed;
	}
	
	public boolean getStayed(){
		return this.stayed;
	}
}
