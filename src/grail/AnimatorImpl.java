package grail;

import mp.bridgeScene.AvatarImpl;
import util.annotations.Tags;

@Tags({"Animator"})

public interface AnimatorImpl {
	@Tags({"animateAvatar"})
	void animateAvatar(AvatarImpl anAvatar);
	void animateGuard(AvatarImpl anAvatar, int numClaps);
}
