package mp.bridgeScene;

import mp.shapes.Image;
import mp.shapes.ImageImpl;
import mp.shapes.Line;
import mp.shapes.LineImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Bridge", "GorgeLeftSide", "GorgeLeftTopSide", "GorgeRightSide", "GorgeRightTopSide"})

public class GorgeAndBridge implements GorgeAndBridgeImpl{
	private String bridgeFileName = "bridge.jpg";
	private int bridgeX = 350;
	private int bridgeY = 150;
	private int bridgeWidth = 300;
	private int bridgeHeight = 100;
	
	private int gorgeLTSX = 0;
	private int gorgeLTSY = 100;
	private int gorgeLTSRadius = 350;
	private int gorgeLTSAngle = 0;
	
	private int gorgeRTSX = 650;
	private int gorgeRTSY = 100;
	private int gorgeRTSRadius = 200;
	private int gorgeRTSAngle = 0;
	
	private int gorgeLSX = 350;
	private int gorgeLSY = 100;
	private int gorgeLSRadius = 600;
	private int gorgeLSAngle = 90;
	
	private int gorgeRSX = 650;
	private int gorgeRSY = 100;
	private int gorgeRSRadius = 600;
	private int gorgeRSAngle = 90;
	
	private ImageImpl bridge;
	private LineImpl gorgeLeftSide;
	private LineImpl gorgeLeftTopSide;
	private LineImpl gorgeRightSide;
	private LineImpl gorgeRightTopSide;
	
	public GorgeAndBridge(){
		bridge = new Image(bridgeFileName, bridgeX, bridgeY, bridgeWidth, bridgeHeight);
		gorgeLeftTopSide = new Line(gorgeLTSX, gorgeLTSY, gorgeLTSRadius, gorgeLTSAngle);
		gorgeLeftSide = new Line(gorgeLSX, gorgeLSY, gorgeLSRadius, gorgeLSAngle);
		gorgeRightTopSide = new Line(gorgeRTSX, gorgeRTSY, gorgeRTSRadius, gorgeRTSAngle);
		gorgeRightSide = new Line(gorgeRSX, gorgeRSY, gorgeRSRadius, gorgeRSAngle);
	}

	public ImageImpl getBridge() {
		return bridge;
	}

	public LineImpl getGorgeLeftSide() {
		return gorgeLeftSide;
	}

	public LineImpl getGorgeLeftTopSide() {
		return gorgeLeftTopSide;
	}

	public LineImpl getGorgeRightSide() {
		return gorgeRightSide;
	}

	public LineImpl getGorgeRightTopSide() {
		return gorgeRightTopSide;
	}
	
}
