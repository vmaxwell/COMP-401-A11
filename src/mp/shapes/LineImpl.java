package mp.shapes;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height", "Radius", "Angle"})
@EditablePropertyNames({"X", "Y", "Width", "Height", "Radius", "Angle"})

public interface LineImpl extends BoundedShapeImpl{
	double getRadius();
	double getAngle();
	void setRadius(double newRadius);
	void setAngle(double newAngle);
	@Tags({"rotate"})
	void rotateLine(int units);
	int getEndX();
	int getEndY();
}
