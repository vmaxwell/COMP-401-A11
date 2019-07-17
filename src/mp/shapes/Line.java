package mp.shapes;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height", "Radius", "Angle"})
@EditablePropertyNames({"X", "Y", "Width", "Height", "Radius", "Angle"})

public class Line extends BoundedShape implements LineImpl{
	private double conversionToRadians = Math.PI/180;
	private double angleInDegrees;
	
	private double radius;
	private double angle;
	
	private int endX;
	private int endY;

	public Line(){
		x = 0;
		y = 0;
	}
	
	public Line(int initX, int initY, double initRadius, double initAngle){
		x = initX;
		y = initY;
		radius = initRadius;
		angle = initAngle * conversionToRadians;
		angleInDegrees = initAngle;
		height = (int) (radius*Math.sin(getAngle()));
		width = (int) (radius*Math.cos(getAngle()));
		endX = x + width;
		endY = y + height;
	}
	
	public double getRadius() {
		return radius;
	}

	
	public double getAngle() {
		return angle;
	}
	
	public void setX(int newX){
		super.setX(newX);
		endX = x + width;
	}
	
	public void setY(int newY){
		super.setY(newY);
		endY = y + height;
	}
	
	public void setRadius(double newRadius) {
		radius = newRadius;
		setHeight((int) (radius*Math.sin(getAngle())));
		setWidth((int) (radius*Math.cos(getAngle())));
		endX = x + width;
		endY = y + height;
	}

	
	public void setAngle(double newAngle) {
		angleInDegrees = newAngle;
		angle = newAngle * conversionToRadians;
		setHeight((int) (radius*Math.sin(getAngle())));
		setWidth((int) (radius*Math.cos(getAngle())));
		endX = x + width;
		endY = y + height;
	}

	@Tags({"rotate"})
	public void rotateLine(int units) {
		double scale = 45;
		setAngle(angleInDegrees + units*scale);
	}
	
	@Visible(false)
	public int getEndX(){
		return endX;
	}
	
	@Visible(false)
	public int getEndY(){
		return endY;
	}
	
}
