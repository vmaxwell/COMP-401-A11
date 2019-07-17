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

public class GuardView implements PaintListenerImpl{
	private BridgeScenePainterImpl painter;
	private BridgeSceneImpl bridgeScene;
	
	private AvatarImpl guard;
	private AngleShapeImpl guardArms;
	private AngleShapeImpl guardLegs;
	private StringShapeImpl guardWords;
	
	public GuardView(){
		painter = SingletonsCreator.bridgeScenePainterFactory();
		bridgeScene = SingletonsCreator.bridgeSceneFactory();
		
		guard = bridgeScene.getGuard();
		guardArms = guard.getArms();
		guardArms.getLeftLine().addPropertyChangeListener(this);
		guardArms.getRightLine().addPropertyChangeListener(this);
		guardLegs = guard.getLegs();
		guardLegs.getLeftLine().addPropertyChangeListener(this);
		guardLegs.getRightLine().addPropertyChangeListener(this);
		guardWords = guard.getStringShape();
		guardWords.addPropertyChangeListener(this);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		((BridgeScenePainter) painter).repaint();
	}

	public void paint(Graphics2D g) {
		drawLine(g, guard.getOtherBodyParts());
		drawLine(g, guard.getArms().getLeftLine());
		drawLine(g, guard.getArms().getRightLine());
		drawLine(g, guard.getLegs().getLeftLine());
		drawLine(g, guard.getLegs().getRightLine());
		draw(g, guard.getHead());
		drawText(g, guardWords);
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
