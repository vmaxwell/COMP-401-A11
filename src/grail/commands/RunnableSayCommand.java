package grail.commands;

import mp.bridgeScene.BridgeSceneImpl;
import util.annotations.Tags;

@Tags({"SayCommand"})

public class RunnableSayCommand implements Runnable{
	private BridgeSceneImpl bridgeScene;
	private String words;
	
	public RunnableSayCommand(BridgeSceneImpl aBridgeScene, String someWords){
		bridgeScene = aBridgeScene;
		words = someWords;
	}
	
	public void run() {
		bridgeScene.say(words);
	}

}
