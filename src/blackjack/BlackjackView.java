package blackjack;
import mvc.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class BlackjackView extends JFrameView{
	
	public static final String HIT = "HIT";
	public static final String STAY = "STAY";
	public static final String START = "START";
	
	public ArrayList<Card> dealer_hand = new ArrayList<Card>();
	public ArrayList<Card> player_hand = new ArrayList<Card>();
	
	public JLabel[] dealer_card_images = new JLabel[10];
	public JLabel[] player_card_images = new JLabel[10];
	
	//JLabel dealer_card1 = new JLabel();

	public BlackjackView(BlackjackModel model, BlackjackController controller) {
		super(model, controller);
		// initialize frame
		JFrame frame = new JFrame();
		
		// initialize JPanel and handler
		JPanel buttonPanel = new JPanel();
		Handler handler = new Handler();
		buttonPanel.setLayout(null);
		
		// display hand images
		int offset = 0;
		for(int i = 0; i < player_card_images.length; i++){
			JLabel label = new JLabel();
			label.setSize(50,75);
			label.setLocation(20 + offset, 400);
			buttonPanel.add(label);
			player_card_images[i] = label;
			offset += 70;
		}
		
		offset = 0;
		for(int i = 0; i < dealer_card_images.length; i++){
			JLabel label = new JLabel();
			label.setSize(50,75);
			label.setLocation(20 + offset, 100);
			buttonPanel.add(label);
			dealer_card_images[i] = label;
			offset += 70;
		}
		/*
		dealer_card1.setSize(100, 150);
		dealer_card1.setLocation(100, 100);
		buttonPanel.add(dealer_card1);
		*/
		
		// initialize buttons
		JButton hitButton = new JButton(HIT);
		JButton stayButton = new JButton(STAY);
		JButton startButton = new JButton(START);
		
		// set button location
		hitButton.setBounds(50,500,100,60);
		stayButton.setBounds(200,500,100,60);
		startButton.setBounds(450,500,100,60);
		
		// add button handlers
		hitButton.addActionListener(handler);
		stayButton.addActionListener(handler);
		startButton.addActionListener(handler);
		
		// add buttons to panel
		buttonPanel.add(stayButton);
		buttonPanel.add(hitButton);
		buttonPanel.add(startButton);
		
		// add components to frame
		frame.add(buttonPanel);
	    frame.setDefaultCloseOperation(3);
	    frame.setSize(720, 600);
	    frame.setVisible(true);
	    
		pack();
	}
	
	public ImageIcon ScaleImage(JLabel label, String img_path) throws IOException{
		BufferedImage img = ImageIO.read(new File(img_path));
		Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		return new ImageIcon(dimg);
	}
	
	@Override
    public void modelChanged(ModelEvent event) {
    	player_hand = event.getPlayer_Hand();
    	dealer_hand = event.getDealer_Hand();
    	try{
    		for(int i = 0; i < player_hand.size(); i++){
    			String img_path = player_hand.get(i).getImg_Path();
    			JLabel label = player_card_images[i];
    			label.setIcon(ScaleImage(label, img_path));
    		}
    		
    		for(int i = 0; i < dealer_hand.size(); i++){
    			String img_path = dealer_hand.get(i).getImg_Path();
    			JLabel label = dealer_card_images[i];
    			label.setIcon(ScaleImage(label, img_path));
    		}
    		
    	} catch(IOException e){
    		System.out.println("IOException");
    	}
    }
	
    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ((BlackjackController)getController()).operation(e.getActionCommand());
        }
    }
    
}
