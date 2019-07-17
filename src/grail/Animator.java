package grail;

import mp.bridgeScene.AvatarImpl;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"Animator"})

public class Animator implements AnimatorImpl{
	
	@Tags({"animateAvatar"})
	public synchronized void animateAvatar(AvatarImpl anAvatar){
		int moveX = 10;
		int moveY = 0;
		int leftRotate = 7;
		int rightRotate = 1;
		for(int i = 0; i < 4; i++){
			anAvatar.moveAvatar(moveX, moveY);
			anAvatar.rotateLeftArm(leftRotate);
			anAvatar.rotateRightArm(rightRotate);
			anAvatar.rotateLeftLeg(leftRotate);
			anAvatar.rotateRightLeg(rightRotate);
			
			if(i == 1){
				moveX = -moveX;
			}
			int temp = leftRotate;
			leftRotate = rightRotate;
			rightRotate = temp;
			ThreadSupport.sleep(500);
		}
	}
	
	public void animateGuard(AvatarImpl anAvatar, int numClaps){
		int leftRotate = 7;
		int rightRotate = 1;
		for(int i = 0; i < numClaps*2; i++){
			anAvatar.rotateLeftArm(leftRotate);
			anAvatar.rotateRightArm(rightRotate);
			
			int temp = leftRotate;
			leftRotate = rightRotate;
			rightRotate = temp;
			ThreadSupport.sleep(1000);
		}
	}
	
}
