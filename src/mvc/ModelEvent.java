package mvc;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import blackjack.Card;

/**
 *  Used to notify interested objects of
 *  changes in the state model
 */
public class ModelEvent extends ActionEvent{

    private ArrayList<Card> player_hand;
    private ArrayList<Card> dealer_hand;
    private int player_money;

    public ModelEvent(Object source, int id, String message, ArrayList<Card> player_hand, int player_money, ArrayList<Card> dealer_hand) {
        super(source, id, message);
        this.player_hand = player_hand;
        this.player_money = player_money;
        this.dealer_hand = dealer_hand;
        System.out.println("Event Created.");
    }
    
    public ArrayList<Card> getPlayer_Hand(){
    	return this.player_hand;
    }
    
    public ArrayList<Card> getDealer_Hand(){
    	return this.dealer_hand;
    }
    
}
