package mvc;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import blackjack.Card;

/**
 *  Used to notify interested objects of
 *  changes in the state model
 */
public class ModelEvent extends ActionEvent{

    private Card new_card;
    private int player_money;
    String card_owner;

    public ModelEvent(Object source, int id, String message, Card new_card, int player_money, String card_owner) {
        super(source, id, message);
        this.new_card = new_card;
        this.player_money = player_money;
        this.card_owner = card_owner;
        System.out.println("Event Created.");
    }
    
    public Card getNew_Card(){
    	return this.new_card;
    }
    
    public String getCard_Owner(){
    	return this.card_owner;
    }
    
    public int getPlayer_Money(){
    	return this.player_money;
    }
    
}
