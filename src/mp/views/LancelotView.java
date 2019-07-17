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

public class LancelotView implements PaintListenerImpl{
	private BridgeScenePainterImpl painter;
	private BridgeSceneImpl bridgeScene;
	
	private AvatarImpl lancelot;
	private AngleShapeImpl lancelotArms;
	private AngleShapeImpl lancelotLegs;
	private StringShapeImpl lancelotWords;
	
	public LancelotView(){
		painter = SingletonsCreator.bridgeScenePainterFactory();
		bridgeScene = SingletonsCreator.bridgeSceneFactory();
		
		lancelot = bridgeScene.getLancelot();
		lancelotArms = lancelot.getArms();
		lancelotArms.getLeftLine().addPropertyChangeListener(this);
		lancelotArms.getRightLine().addPropertyChangeListener(this);
		lancelotLegs = lancelot.getLegs();
		lancelotLegs.getLeftLine().addPropertyChangeListener(this);
		lancelotLegs.getRightLine().addPropertyChangeListener(this);
		lancelotWords = lancelot.getStringShape();
		lancelotWords.addPropertyChangeListener(this);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		((BridgeScenePainter) painter).repaint();
	}

	public void paint(Graphics2D g) {
		drawLine(g, lancelot.getOtherBodyParts());
		drawLine(g, lancelot.getArms().getLeftLine());
		drawLine(g, lancelot.getArms().getRightLine());
		drawLine(g, lancelot.getLegs().getLeftLine());
		drawLine(g, lancelot.getLegs().getRightLine());
		draw(g, lancelot.getHead());
		drawText(g, lancelotWords);
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
