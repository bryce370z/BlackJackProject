package blackjack;
import mvc.*;

public class BlackjackController extends AbstractController{
	private boolean started;
	public BlackjackController(){
		started = false;
		setModel(new BlackjackModel());
		setView(new BlackjackView((BlackjackModel)getModel(),this));
		((JFrameView)getView()).setVisible(true);
		
	}
	
	public void operation(String op){
		switch(op){
		case BlackjackView.START:
			System.out.println("Controller: START.");
			if(started == false){
				((BlackjackModel)getModel()).startGame();
			}
			started = true;
			break;
		case BlackjackView.HIT:
			System.out.println("Controller: HIT.");
			if(started){
				((BlackjackModel)getModel()).Hit(((BlackjackModel)getModel()).getPlayer());
			}
			break;
		case BlackjackView.STAY:
			System.out.println("Controller: STAY.");
			if(started){
				((BlackjackModel)getModel()).Stay();
			}
			break;
		}
			
			
	}
}
