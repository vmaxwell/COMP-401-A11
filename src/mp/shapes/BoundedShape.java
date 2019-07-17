package mp.shapes;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"BoundedShape"})
@PropertyNames({"X", "Y", "Width", "Height"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})

public class BoundedShape extends Locatable implements BoundedShapeImpl{
	protected int width;
	protected int height;
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setWidth(int newWidth) {
		int oldWidth = getWidth();
		width = newWidth;
		notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, width));
	}
	
	public void setHeight(int newHeight) {
		int oldHeight = getHeight();
		height = newHeight;
		notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, height));
	}
	
	
}
