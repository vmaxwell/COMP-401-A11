package grail.commands;

import mp.bridgeScene.BridgeSceneImpl;
import util.annotations.Tags;

@Tags({"PassCommand"})

public class RunnablePassCommand implements Runnable{
	
	private BridgeSceneImpl bridgeScene;
	
	public RunnablePassCommand(BridgeSceneImpl aBridgeScene){
		bridgeScene = aBridgeScene;
	}
	
	public void run() {
		bridgeScene.passed();
	}

}
