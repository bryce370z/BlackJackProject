package mvc;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ecborera on 10/29/17.
 */
public abstract  class AbstractModel implements Model {
    private ArrayList listeners = new ArrayList(5);

    public void notifyChanged(ModelEvent event) {

        ArrayList list = (ArrayList) listeners.clone();
        Iterator it = list.iterator();

        while (it.hasNext()){
            ModelListener ml = (ModelListener)it.next();
            ml.modelChanged(event);
        }
    }

    // -------------------------
    // Add to objects interested
    // in ModelEvents
    // -------------------------
    public void addModelListener(ModelListener listener){
        listeners.add(listener);
    }

    // ----------------------------------------
    // Remove a ModelListener from the list of
    // objects interested in ModelEvents
    // ----------------------------------------
    public void removeModelListener(ModelListener listener){
        listeners.remove(listener);
    }
}
