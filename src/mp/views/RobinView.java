package mp.views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;

import grail.SingletonsCreator;
import mp.bridgeScene.AvatarImpl;
import mp.bridgeScene.BridgeSceneImpl;
import mp.shapes.AngleShapeImpl;
import mp.shapes.ImageImpl;
import mp.shapes.LineImpl;
import mp.shapes.StringShapeImpl;
import util.annotations.Tags;

@Tags({"PaintListener"})

public class RobinView implements PaintListenerImpl{
	private BridgeScenePainterImpl painter;
	private BridgeSceneImpl bridgeScene;
	
	private AvatarImpl robin;
	private AngleShapeImpl robinArms;
	private AngleShapeImpl robinLegs;
	private StringShapeImpl robinWords;
	
	public RobinView(){
		painter = SingletonsCreator.bridgeScenePainterFactory();
		bridgeScene = SingletonsCreator.bridgeSceneFactory();
		
		robin = bridgeScene.getRobin();
		robinArms = robin.getArms();
		robinArms.getLeftLine().addPropertyChangeListener(this);
		robinArms.getRightLine().addPropertyChangeListener(this);
		robinLegs = robin.getLegs();
		robinLegs.getLeftLine().addPropertyChangeListener(this);
		robinLegs.getRightLine().addPropertyChangeListener(this);
		robinWords = robin.getStringShape();
		robinWords.addPropertyChangeListener(this);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		((BridgeScenePainter) painter).repaint();
	}

	public void paint(Graphics2D g) {
		drawLine(g, robin.getOtherBodyParts());
		drawLine(g, robin.getArms().getLeftLine());
		drawLine(g, robin.getArms().getRightLine());
		drawLine(g, robin.getLegs().getLeftLine());
		drawLine(g, robin.getLegs().getRightLine());
		draw(g, robin.getHead());
		drawText(g, robinWords);
	}
	
	public void drawText(Graphics g, StringShapeImpl aText) {
        String words = aText.getText();
        g.drawString(words, aText.getX(), aText.getY());
    }
    
	public  void draw(Graphics2D g, ImageImpl anImage) {
        Image img = Toolkit.getDefaultToolkit().getImage(anImage.getImageFileName());
        g.drawImage(img, anImage.getX(), anImage.getY(), null);     
    }
    
    public void drawLine(Graphics2D g, LineImpl aLine){
		g.drawLine(aLine.getX(), aLine.getY(), aLine.getEndX(), aLine.getEndY());
	}
}
