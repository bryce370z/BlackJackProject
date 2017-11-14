package blackjack;

public class Card {
	private int value;
	private String suit;
	private String type;
	private String img_path;
	
	public Card(int value, String suit, String type, String img_path){
		this.value = value;
		this.suit = suit;
		this.type = type;
		this.img_path = img_path;
		
	}
	
	public int getValue(){
		return this.value;
		
	}
	
	public String getSuit(){
		return this.suit;
		
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getImg_Path(){
		return this.img_path;
	}
}
