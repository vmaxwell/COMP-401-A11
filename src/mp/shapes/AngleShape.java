package mp.shapes;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Angle"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"LeftLine", "RightLine"})

public class AngleShape implements AngleShapeImpl{
	private int xValue = 100;
	private int yValue = 100;
	private int radiusValue = 50;
	private int leftLineAngle = 135;
	private int rightLineAngle = 45;
	
	private LineImpl leftLine;
	private LineImpl rightLine;
		
	public AngleShape(){
		leftLine = new Line(xValue, yValue, radiusValue, leftLineAngle);
		rightLine = new Line(xValue, yValue, radiusValue, rightLineAngle);
	}
	
	public AngleShape(int initX, int initY){
		leftLine = new Line(initX, initY, radiusValue, leftLineAngle);
		rightLine = new Line(initX, initY, radiusValue, rightLineAngle);
	}

	public LineImpl getLeftLine() {
		return leftLine;
	}

	public LineImpl getRightLine() {
		return rightLine;
	}

	@Tags({"move"})
	public void moveAngleShape(int moveX, int moveY) {
		int leftLineX = leftLine.getX();
		int leftLineY = leftLine.getY();
		int rightLineX = rightLine.getX();
		int rightLineY = rightLine.getY();
		
		leftLine.setX(leftLineX + moveX);
		leftLine.setY(leftLineY + moveY);
		rightLine.setX(rightLineX + moveX);
		rightLine.setY(rightLineY + moveY);
	}
	
}
