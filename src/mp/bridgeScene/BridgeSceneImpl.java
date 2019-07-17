package mp.bridgeScene;

import mp.shapes.OvalImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
import util.models.PropertyListenerRegisterer;

@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Lancelot", "Robin", "Galahad", "Guard", "Gorge", "KnightArea", "GuardArea", "Occupied", "KnightTurn"})

public interface BridgeSceneImpl extends PropertyListenerRegisterer{
	AvatarImpl getArthur();
	AvatarImpl getLancelot();
	AvatarImpl getRobin();
	AvatarImpl getGalahad();
	AvatarImpl getGuard();
	GorgeAndBridgeImpl getGorge();
	OvalImpl getKnightArea();
	OvalImpl getGuardArea();
	void scaleAllAvatars(double scaleUnit);
	@Tags({"Approach"})
	void approach(AvatarImpl avatar);
	@Tags({"Say"})
	void say(String string);
	@Tags({"Passed"})
	void passed();
	@Tags({"Failed"})
	void failed();
	@Tags({"Occupied"})
	boolean getOccupied();
	@Tags({"KnightTurn"})
	boolean getKnightTurn();
	@Visible(false)
	AvatarImpl getInteractingKnight();
}
