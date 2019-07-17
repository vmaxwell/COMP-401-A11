package mp.views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import mp.bridgeScene.AvatarImpl;
import mp.shapes.AngleShapeImpl;
import mp.shapes.ImageImpl;
import mp.shapes.LineImpl;

public class AvatarView {
	public void drawLine(Graphics2D g, LineImpl aLine){
		g.drawLine(aLine.getX(), aLine.getY(), aLine.getEndX(), aLine.getEndY());
	}
	
	public void drawAvatarBody(Graphics2D g, AvatarImpl avatar){
		AngleShapeImpl avatarArms = avatar.getArms();
		AngleShapeImpl avatarLegs = avatar.getLegs();
		drawLine(g, avatarArms.getLeftLine());
		drawLine(g, avatarArms.getRightLine());
		drawLine(g, avatar.getOtherBodyParts());
		drawLine(g, avatarLegs.getLeftLine());
		drawLine(g, avatarLegs.getRightLine());
	}
	
	public void drawAvatarHead(Graphics2D g, AvatarImpl avatar){
		ImageImpl head = avatar.getHead();
		Image img = Toolkit.getDefaultToolkit().getImage(head.getImageFileName());
        
	}
}
