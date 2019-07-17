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

public class GalahadView implements PaintListenerImpl{
	private BridgeScenePainterImpl painter;
	private BridgeSceneImpl bridgeScene;
	
	private AvatarImpl galahad;
	private AngleShapeImpl galahadArms;
	private AngleShapeImpl galahadLegs;
	private StringShapeImpl galahadWords;
	
	public GalahadView(){
		painter = SingletonsCreator.bridgeScenePainterFactory();
		bridgeScene = SingletonsCreator.bridgeSceneFactory();
		
		galahad = bridgeScene.getGalahad();
		galahadArms = galahad.getArms();
		galahadArms.getLeftLine().addPropertyChangeListener(this);
		galahadArms.getRightLine().addPropertyChangeListener(this);
		galahadLegs = galahad.getLegs();
		galahadLegs.getLeftLine().addPropertyChangeListener(this);
		galahadLegs.getRightLine().addPropertyChangeListener(this);
		galahadWords = galahad.getStringShape();
		galahadWords.addPropertyChangeListener(this);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		((BridgeScenePainter) painter).repaint();
	}

	public void paint(Graphics2D g) {
		drawLine(g, galahad.getOtherBodyParts());
		drawLine(g, galahad.getArms().getLeftLine());
		drawLine(g, galahad.getArms().getRightLine());
		drawLine(g, galahad.getLegs().getLeftLine());
		drawLine(g, galahad.getLegs().getRightLine());
		draw(g, galahad.getHead());
		drawText(g, galahadWords);
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
