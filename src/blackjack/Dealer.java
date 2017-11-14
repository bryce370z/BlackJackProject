package blackjack;

import java.util.ArrayList;
import java.util.Arrays;

public class Dealer extends Person{
	private boolean finished;

	public Dealer(){
		setHand(new ArrayList<Card>(Arrays.asList(new Card[2])));
		setName("Dealer");
		setFinished(false);
	}
	
	public void setFinished(boolean finished){
		this.finished = finished;
	}
	
	public boolean getFinished(){
		return this.finished;
	}
}
