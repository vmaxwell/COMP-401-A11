package mp.shapes;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})

public class Oval extends BoundedShape implements OvalImpl{
	
	public Oval(int initX, int initY, int initWidth, int initHeight){
		x = initX;
		y = initY;
		width = initWidth;
		height = initHeight;
	}
}
