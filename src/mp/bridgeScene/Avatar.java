package mp.bridgeScene;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import mp.shapes.AngleShape;
import mp.shapes.AngleShapeImpl;
import mp.shapes.ImageImpl;
import mp.shapes.Line;
import mp.shapes.LineImpl;
import mp.shapes.StringShape;
import mp.shapes.StringShapeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"StringShape", "Head", "Arms", "Legs", "OtherBodyParts"})

public class Avatar implements AvatarImpl{
	private int textYOffset = 10;
	
	private StringShapeImpl stringShape;
	private ImageImpl head;
	private AngleShapeImpl arms;
	private AngleShapeImpl legs;
	private LineImpl otherBodyParts;
	
	public Avatar(ImageImpl initHead){
		head = initHead;
		stringShape = new StringShape("", head.getX(), head.getY());
		arms = new AngleShape(head.getX(), head.getY());
		legs = new AngleShape(head.getX(), head.getY());
		otherBodyParts = new Line(head.getX(), head.getY(), 80, 90);
		connectBodyParts();
		
		
	}
	
	public void connectBodyParts(){
		String headFileName = head.getImageFileName();
		Icon headIcon = new ImageIcon(headFileName);
		int headWidth = headIcon.getIconWidth();
		int headHeight = headIcon.getIconHeight();
		
		LineImpl leftArm = arms.getLeftLine();
		LineImpl rightArm = arms.getRightLine();
		LineImpl leftLeg = legs.getLeftLine();
		LineImpl rightLeg = legs.getRightLine();
		
		stringShape.setX(head.getX() + headWidth);
		stringShape.setY(head.getY() - textYOffset);
		leftArm.setX(head.getX() + headWidth/2);
		leftArm.setY(head.getY() + headHeight);
		rightArm.setX(head.getX() + headWidth/2);
		rightArm.setY(head.getY() + headHeight);
		otherBodyParts.setX(head.getX() + headWidth/2);
		otherBodyParts.setY(head.getY() + headHeight);
		leftLeg.setX(head.getX() + headWidth/2);
		leftLeg.setY(head.getY() + headHeight + (int)otherBodyParts.getRadius());
		rightLeg.setX(head.getX() + headWidth/2);
		rightLeg.setY(head.getY() + headHeight + (int)otherBodyParts.getRadius());
	}
	
	@Tags({"move"})
	public void moveAvatar(int moveX, int moveY){
		int headX = head.getX();
		int headY = head.getY();
		
		head.setX(headX + moveX);
		head.setY(headY + moveY);
		connectBodyParts();
	}
	
	public void moveAvatarToPosition(int moveX, int moveY){
		head.setX(moveX);
		head.setY(moveY);
		connectBodyParts();
	}
	
	@Tags({"scale"})
	public void scaleAvatar(double scale){
		LineImpl leftArm = arms.getLeftLine();
		LineImpl rightArm = arms.getRightLine();
		double currentArmRadius = leftArm.getRadius();
		leftArm.setRadius(currentArmRadius * scale);
		rightArm.setRadius(currentArmRadius * scale);
		
		double currentBodyRadius = otherBodyParts.getRadius();
		otherBodyParts.setRadius(currentBodyRadius * scale);
		
		LineImpl leftLeg = legs.getLeftLine();
		LineImpl rightLeg = legs.getRightLine();
		double currentLegRadius = leftLeg.getRadius();
		leftLeg.setRadius(currentLegRadius * scale);
		rightLeg.setRadius(currentLegRadius * scale);
		
		connectBodyParts();
	}
	
	public void rotateLeftArm(int units){
		LineImpl leftArm = arms.getLeftLine();
		leftArm.rotateLine(units);
	}
	
	public void rotateRightArm(int units){
		LineImpl rightArm = arms.getRightLine();
		rightArm.rotateLine(units);
	}
	
	public void rotateLeftLeg(int units){
		LineImpl leftLeg = legs.getLeftLine();
		leftLeg.rotateLine(units);
	}
	
	public void rotateRightLeg(int units){
		LineImpl rightLeg = legs.getRightLine();
		rightLeg.rotateLine(units);
	}

	public StringShapeImpl getStringShape() {
		return stringShape;
	}

	public ImageImpl getHead() {
		return head;
	}

	public AngleShapeImpl getArms() {
		return arms;
	}

	public AngleShapeImpl getLegs() {
		return legs;
	}

	public LineImpl getOtherBodyParts() {
		return otherBodyParts;
	}
}
