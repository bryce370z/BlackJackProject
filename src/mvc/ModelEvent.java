package mvc;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import blackjack.Card;

/**
 *  Used to notify interested objects of
 *  changes in the state model
 */
public class ModelEvent extends ActionEvent{

    private Card new_card;
    private int player_money;
    private String card_owner;
    private String winner;
    private int player_score;
    private int dealer_score;
    
    public ModelEvent(Object source, int id, String message, Card new_card, int player_money, String card_owner, String winner, int player_score, int dealer_score) {
        super(source, id, message);
        this.new_card = new_card;
        this.player_money = player_money;
        this.card_owner = card_owner;
        this.winner = winner;
        this.player_score = player_score;
        this.dealer_score = dealer_score;
        // System.out.println("Event Created.");
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
    
    public String getWinner(){
    	return this.winner;
    }
    
    public int getPlayer_Score(){
    	return this.player_score;
    }
    
    public int getDealer_Score(){
    	return this.dealer_score;
    }
    
}
