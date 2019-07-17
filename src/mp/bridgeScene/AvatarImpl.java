package mp.bridgeScene;

import mp.shapes.AngleShapeImpl;
import mp.shapes.ImageImpl;
import mp.shapes.LineImpl;
import mp.shapes.StringShapeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"StringShape", "Head", "Arms", "Legs", "OtherBodyParts"})

public interface AvatarImpl {
	StringShapeImpl getStringShape();
	ImageImpl getHead();
	AngleShapeImpl getArms();
	AngleShapeImpl getLegs();
	LineImpl getOtherBodyParts();
	void connectBodyParts();
	@Tags({"move"})
	void moveAvatar(int moveX, int moveY);
	void moveAvatarToPosition(int moveX, int moveY);
	@Tags({"scale"})
	void scaleAvatar(double scale);
	void rotateLeftArm(int units);
	void rotateRightArm(int units);
	void rotateLeftLeg(int units);
	void rotateRightLeg(int units);
}
