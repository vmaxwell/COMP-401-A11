package mp.views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;

import grail.SingletonsCreator;
import mp.bridgeScene.BridgeSceneImpl;
import mp.bridgeScene.GorgeAndBridgeImpl;
import mp.shapes.ImageImpl;
import mp.shapes.LineImpl;
import mp.shapes.OvalImpl;
import util.annotations.Tags;

@Tags({"PaintListener"})

public class BackgroundView implements PaintListenerImpl{
	private BridgeScenePainterImpl painter;
	private BridgeSceneImpl bridgeScene;
	private GorgeAndBridgeImpl gorgeAndBridge;
	
	public BackgroundView(){
		painter = SingletonsCreator.bridgeScenePainterFactory();
		bridgeScene = SingletonsCreator.bridgeSceneFactory();
		gorgeAndBridge = bridgeScene.getGorge();
		gorgeAndBridge.getGorgeLeftSide().addPropertyChangeListener(this);
		gorgeAndBridge.getGorgeLeftTopSide().addPropertyChangeListener(this);
		gorgeAndBridge.getGorgeRightSide().addPropertyChangeListener(this);
		gorgeAndBridge.getGorgeRightTopSide().addPropertyChangeListener(this);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		((BridgeScenePainter) painter).repaint();
	}

	public void paint(Graphics2D g) {
		drawLine(g, gorgeAndBridge.getGorgeLeftTopSide());
		drawLine(g, gorgeAndBridge.getGorgeLeftSide());
		drawLine(g, gorgeAndBridge.getGorgeRightTopSide());
		drawLine(g, gorgeAndBridge.getGorgeRightSide());
		drawImage(g, gorgeAndBridge.getBridge());
		drawOval(g, bridgeScene.getKnightArea());
		drawOval(g, bridgeScene.getGuardArea());
		
	}
	
	public void drawLine(Graphics2D g, LineImpl aLine){
		g.drawLine(aLine.getX(), aLine.getY(), aLine.getEndX(), aLine.getEndY());
	}
	
	public void drawOval(Graphics2D g, OvalImpl anOval){
		g.drawOval(anOval.getX(), anOval.getY(), anOval.getWidth(), anOval.getHeight());
	}
	
	public  void drawImage(Graphics2D g, ImageImpl anImage) {
        Image img = Toolkit.getDefaultToolkit().getImage(anImage.getImageFileName());
        g.drawImage(img, anImage.getX(), anImage.getY(), anImage.getWidth(), anImage.getHeight(), null);     
    }
	
}
