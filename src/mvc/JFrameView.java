package mvc;


import javax.swing.*;

public class JFrameView extends JFrame implements View, ModelListener {

    private Model model;
    private Controller controller;

    public JFrameView (Model model, Controller controller){
        setModel(model);
        setController(controller);
    }

    public void registerWithModel() {
        ((AbstractModel) model).addModelListener(this);
    }

    @Override
    public Controller getController() {
        return controller;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
        registerWithModel();
    }

    @Override
    public void modelChanged(ModelEvent event) {
    }
}
