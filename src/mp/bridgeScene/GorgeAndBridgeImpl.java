package mp.bridgeScene;

import mp.shapes.ImageImpl;
import mp.shapes.LineImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Bridge", "GorgeLeftSide", "GorgeLeftTopSide", "GorgeRightSide", "GorgeRightTopSide"})

public interface GorgeAndBridgeImpl {
	ImageImpl getBridge();
	LineImpl getGorgeLeftSide();
	LineImpl getGorgeLeftTopSide();
	LineImpl getGorgeRightSide();
	LineImpl getGorgeRightTopSide();
}
