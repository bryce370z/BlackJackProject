package mvc;

/**
 * Created by ecborera on 10/29/17.
 */
public interface View {
    Controller getController();
    void setController(Controller controller);
    Model getModel();
    void setModel(Model model);
}
