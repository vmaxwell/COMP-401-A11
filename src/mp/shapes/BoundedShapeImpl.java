package mp.shapes;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"BoundedShape"})
@PropertyNames({"X", "Y", "Width", "Height"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})

public interface BoundedShapeImpl extends LocatableImpl{
	int getWidth();
	int getHeight();
	void setWidth(int newWidth);
	void setHeight(int newHeight);
}
