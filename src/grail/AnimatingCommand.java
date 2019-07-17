package grail;

import mp.bridgeScene.AvatarImpl;
import util.annotations.Tags;

@Tags({"AnimatingCommand"})

public class AnimatingCommand implements Runnable{
	private AnimatorImpl animator;
	private AvatarImpl avatar;
	private int numOfClaps;
	
	public AnimatingCommand(AnimatorImpl anAnimator, AvatarImpl anAvatar){
		animator = anAnimator;
		avatar = anAvatar;
	}
	
	public AnimatingCommand(AnimatorImpl anAnimator, AvatarImpl anAvatar, int claps){
		animator = anAnimator;
		avatar = anAvatar;
		numOfClaps = claps;
	}
	
	public void run(){
		if("guard.jpg".equals(avatar.getHead().getImageFileName())){
			animator.animateGuard(avatar, numOfClaps);
		} else{
			animator.animateAvatar(avatar);
		}
	}
	
}
