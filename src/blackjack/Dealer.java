package blackjack;

import java.util.ArrayList;
import java.util.Arrays;

public class Dealer extends Person{

	public Dealer(){
		setHand(new ArrayList<Card>(Arrays.asList(new Card[2])));
		setName("Dealer");
	}
}
