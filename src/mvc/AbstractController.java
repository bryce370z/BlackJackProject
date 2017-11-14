package mvc;

/**
 * Created by ecborera on 10/29/17.
 */
public abstract class AbstractController implements Controller {

    private View view;
    private Model model;

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}
