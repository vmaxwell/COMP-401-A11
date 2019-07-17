package mp.shapes;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Angle"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftLine", "RightLine"})

public interface AngleShapeImpl {
	LineImpl getLeftLine();
	LineImpl getRightLine();
	@Tags({"move"})
	void moveAngleShape(int moveX, int moveY);
}
