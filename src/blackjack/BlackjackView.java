package blackjack;
import mvc.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class BlackjackView extends JFrameView{
	
	public static final String HIT = "HIT";
	public static final String STAY = "STAY";
	public static final String START = "START";
	
	// public ArrayList<Card> dealer_hand = new ArrayList<Card>();
	// public ArrayList<Card> player_hand = new ArrayList<Card>();
	
	private JLabel[] dealer_card_images = new JLabel[10];
	private JLabel[] player_card_images = new JLabel[10];
	
	private int player_card_index = 0;
	private int dealer_card_index = 0;
	
	JPanel WinScreen = new JPanel();
	private JLabel display_winner = new JLabel();
	private JLabel display_score = new JLabel();
	
	JPanel Content = new JPanel();
	//JLabel dealer_card1 = new JLabel();

	public BlackjackView(BlackjackModel model, BlackjackController controller) {
		super(model, controller);
		
		// initialize JPanel and handler
		Handler handler = new Handler();
		Content.setLayout(null);
		Content.setBackground(new Color((float)0.007, (float)0.67, (float)0.03));
		WinScreen.setLayout(null);
		WinScreen.setVisible(false);
		
		// display text for winner
		display_winner.setLocation(310, 100);
		display_winner.setSize(100, 100);
		
		display_score.setLocation(275,200);
		display_score.setSize(500, 100);
		WinScreen.add(display_winner);
		WinScreen.add(display_score);
		
		// display hand images
		int offset = 0;
		for(int i = 0; i < player_card_images.length; i++){
			JLabel label = new JLabel();
			label.setSize(50,75);
			label.setLocation(20 + offset, 400);
			Content.add(label);
			player_card_images[i] = label;
			offset += 70;
		}
		
		offset = 0;
		for(int i = 0; i < dealer_card_images.length; i++){
			JLabel label = new JLabel();
			label.setSize(50,75);
			label.setLocation(20 + offset, 100);
			Content.add(label);
			dealer_card_images[i] = label;
			offset += 70;
		}
		
		// initialize buttons
		JButton hitButton = new JButton(HIT);
		JButton stayButton = new JButton(STAY);
		JButton startButton = new JButton(START);
		
		// set button location
		hitButton.setBounds(50,500,100,60);
		stayButton.setBounds(200,500,100,60);
		startButton.setBounds(570,500,100,60);
		
		// add button handlers
		hitButton.addActionListener(handler);
		stayButton.addActionListener(handler);
		startButton.addActionListener(handler);
		
		// add buttons to panel
		Content.add(stayButton);
		Content.add(hitButton);
		Content.add(startButton);
		
		// add components to frame
		add(Content);
	    setDefaultCloseOperation(3);
	    setSize(720, 600);
	    setVisible(true);
	    add(WinScreen);
	    
		// pack();
	}
	
	public ImageIcon ScaleImage(JLabel label, String img_path) throws IOException{
		BufferedImage img = ImageIO.read(new File(img_path));
		Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		return new ImageIcon(dimg);
	}
	
	@Override
    public void modelChanged(ModelEvent event) {
		String card_owner = event.getCard_Owner();
		String img_path  = event.getNew_Card().getImg_Path();
		JLabel label = new JLabel();
		// System.out.println(player_card_index);
    	try{
    		switch(card_owner){
    		case "Player":
    			label = player_card_images[player_card_index];
    			label.setIcon(ScaleImage(label, img_path));
    			player_card_index++;
    			break;
    		case "Dealer":
    			label = dealer_card_images[dealer_card_index];
    			label.setIcon(ScaleImage(label, img_path));
    			dealer_card_index++;
    			break;
    		}
    		
    	} catch(IOException e){
    		System.out.println("IOException");
    	}
    	String winner = event.getWinner();
    	if(winner.equals("Player")){
    		display_winner.setText("Player Wins");
    		display_score.setText("PLAYER: " + event.getPlayer_Score() + " DEALER: " + event.getDealer_Score());
    		Content.setVisible(false);
    		WinScreen.setVisible(true);
    		// System.out.println("WINNER:" + winner);
    	}
    	if(winner.equals("Dealer")){
    		display_winner.setText("Dealer Wins");
    		display_score.setText("PLAYER: " + event.getPlayer_Score() + " DEALER: " + event.getDealer_Score());
    		Content.setVisible(false);
    		WinScreen.setVisible(true);
    		// System.out.println("WINNER:" + winner);
    	}
    }
	
    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ((BlackjackController)getController()).operation(e.getActionCommand());
        }
    }
    
}
