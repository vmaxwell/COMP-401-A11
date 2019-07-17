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

public class ArthurView implements PaintListenerImpl{
	private BridgeScenePainterImpl painter;
	private BridgeSceneImpl bridgeScene;
	
	private AvatarImpl arthur;
	private AngleShapeImpl arthurArms;
	private LineImpl arthurLeftArm;
	private LineImpl arthurRightArm;
	private AngleShapeImpl arthurLegs;
	private LineImpl arthurLeftLeg;
	private LineImpl arthurRightLeg;
	private StringShapeImpl arthurWords;
	
	public ArthurView(){
		painter = SingletonsCreator.bridgeScenePainterFactory();
		bridgeScene = SingletonsCreator.bridgeSceneFactory();
		
		arthur = bridgeScene.getArthur();
		arthurArms = arthur.getArms();
		arthurLeftArm = arthurArms.getLeftLine();
		arthurLeftArm.addPropertyChangeListener(this);
		arthurRightArm = arthurArms.getRightLine();
		arthurRightArm.addPropertyChangeListener(this);
		arthurLegs = arthur.getLegs();
		arthurLeftLeg = arthurLegs.getLeftLine();
		arthurLeftLeg.addPropertyChangeListener(this);
		arthurRightLeg = arthurLegs.getRightLine();
		arthurRightLeg.addPropertyChangeListener(this);
		arthurWords = arthur.getStringShape();
		arthurWords.addPropertyChangeListener(this);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		((BridgeScenePainter) painter).repaint();
	}

	public void paint(Graphics2D g) {
		drawLine(g, arthur.getOtherBodyParts());
		drawLine(g, arthur.getArms().getLeftLine());
		drawLine(g, arthur.getArms().getRightLine());
		drawLine(g, arthur.getLegs().getLeftLine());
		drawLine(g, arthur.getLegs().getRightLine());
		draw(g, arthur.getHead());
		drawText(g, arthurWords);
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
