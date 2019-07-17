package grail.commands;

import mp.bridgeScene.BridgeSceneImpl;
import util.annotations.Tags;

@Tags({"FailCommand"})

public class RunnableFailCommand implements Runnable{

	private BridgeSceneImpl bridgeScene;
	
	public RunnableFailCommand(BridgeSceneImpl aBridgeScene){
		bridgeScene = aBridgeScene;
	}
	
	public void run() {
		bridgeScene.failed();
	}

}
