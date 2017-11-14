package blackjack;
import mvc.*;

public class BlackjackController extends AbstractController{
	public BlackjackController(){
		setModel(new BlackjackModel());
		setView(new BlackjackView((BlackjackModel)getModel(),this));
		((JFrameView)getView()).setVisible(true);
		
	}
	
	public void operation(String op){
		if(op.equals(BlackjackView.START)){
			System.out.println("Controller: START.");
			((BlackjackModel)getModel()).startGame();
		}
		if(op.equals(BlackjackView.HIT)){
			System.out.println("Controller: HIT.");
			((BlackjackModel)getModel()).Hit();
		}
			
	}
}
