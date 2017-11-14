package mvc;

/**
 * Created by ecborera on 10/29/17.
 */
public interface Controller {
    void setModel(Model model);
    Model getModel();
    View getView();
    void setView(View view);
}
