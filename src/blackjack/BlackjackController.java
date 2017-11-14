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
			System.out.println("Controller Activated.");
			((BlackjackModel)getModel()).startGame();
		}
	}
}
