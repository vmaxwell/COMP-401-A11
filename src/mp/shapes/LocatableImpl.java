package mp.shapes;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"Locatable"})
@PropertyNames({"X", "Y"})
@EditablePropertyNames({"X", "Y"})

public interface LocatableImpl extends PropertyListenerRegisterer{
	int getX();
	int getY();
	void setX(int newX);
	void setY(int newY);
	void notifyAllListeners(PropertyChangeEvent event);
}
