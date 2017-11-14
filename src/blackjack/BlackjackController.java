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
		BlackjackModel model = ((BlackjackModel)getModel());
		switch(op){
		case BlackjackView.START:
			System.out.println("Controller: START.");
			if(started == false){
				model.startGame();
			}
			started = true;
			break;
		case BlackjackView.HIT:
			System.out.println("Controller: HIT.");
			if(started){
				model.playerHit();
			}
			break;
		case BlackjackView.STAY:
			System.out.println("Controller: STAY.");
			if(started){
				model.playerStay();
			}
			break;
		}
			
			
	}
}
