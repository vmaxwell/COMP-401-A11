package grail.commands;

import mp.bridgeScene.AvatarImpl;
import util.annotations.Tags;

@Tags({"MoveCommand"})

public class RunnableMoveCommand implements Runnable{
	private AvatarImpl avatar;
	private int x;
	private int y;
	
	
	public RunnableMoveCommand(AvatarImpl anAvatar, int xOffset, int yOffset){
		avatar = anAvatar;
		x = xOffset;
		y = yOffset;
	}
	
	public void run() {
		avatar.moveAvatar(x, y);
	}

}
