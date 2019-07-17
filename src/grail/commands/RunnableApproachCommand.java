package grail.commands;

import mp.bridgeScene.AvatarImpl;
import mp.bridgeScene.BridgeSceneImpl;
import util.annotations.Tags;

@Tags({"ApproachCommand"})

public class RunnableApproachCommand implements Runnable{

	private BridgeSceneImpl bridgeScene;
	private AvatarImpl avatar;
	
	public RunnableApproachCommand(BridgeSceneImpl aBridgeScene, AvatarImpl anAvatar){
		bridgeScene = aBridgeScene;
		avatar = anAvatar;
	}
	
	public void run() {
		bridgeScene.approach(avatar);
	}

}
