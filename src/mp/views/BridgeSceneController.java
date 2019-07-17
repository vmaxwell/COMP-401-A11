package mp.views;

import java.awt.Component;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import grail.SingletonsCreator;
import mp.bridgeScene.AvatarImpl;
import mp.bridgeScene.BridgeSceneImpl;
import util.annotations.Tags;

@Tags({"BridgeSceneController"})

public class BridgeSceneController extends BridgeScenePainter implements BridgeSceneControllerImpl{
	private Point lastClickPt;
	private BridgeSceneImpl bridgeScene;
	private BridgeScenePainterImpl painter;
	
	private AvatarImpl arthur;
	private AvatarImpl galahad;
	private AvatarImpl lancelot;
	private AvatarImpl robin;
	
	private int arthurInitX = 50;
	private int arthurInitY = 325;
	private int lancelotInitX = 200;
	private int lancelotInitY = 325;
 	private int robinInitX = 50;
	private int robinInitY = 450;
	private int galahadInitX = 200;
	private int galahadInitY = 450;
	
	public BridgeSceneController(BridgeScenePainterImpl aPainter){
		bridgeScene = SingletonsCreator.bridgeSceneFactory();
		arthur = bridgeScene.getArthur();
		galahad = bridgeScene.getGalahad();
		lancelot = bridgeScene.getLancelot();
		robin = bridgeScene.getRobin();
		painter = aPainter;
		((Component) painter).addMouseListener(this);
		((Component) painter).addKeyListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		lastClickPt = e.getPoint();
		System.out.println("Mouse Clicked");
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void keyTyped(KeyEvent e) {
		char letterTyped = e.getKeyChar();
		
		if(letterTyped == 'a'){
			arthur.moveAvatarToPosition((int) lastClickPt.getX(), (int) lastClickPt.getY());
		} else if(letterTyped == 'g'){
			galahad.moveAvatarToPosition((int) lastClickPt.getX(), (int) lastClickPt.getY());
		} else if(letterTyped == 'l'){
			lancelot.moveAvatarToPosition((int) lastClickPt.getX(), (int) lastClickPt.getY());
		} else if(letterTyped == 'r'){
			robin.moveAvatarToPosition((int) lastClickPt.getX(), (int) lastClickPt.getY());
		} else if(letterTyped == 'o'){
			arthur.moveAvatarToPosition(arthurInitX, arthurInitY);
			galahad.moveAvatarToPosition(galahadInitX, galahadInitY);
			lancelot.moveAvatarToPosition(lancelotInitX, lancelotInitY);
			robin.moveAvatarToPosition(robinInitX, robinInitY);
		}
		
		System.out.println("Key pressed: " + e.getKeyChar());
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("Key pressed" + e.getKeyChar());
	}
	public void keyReleased(KeyEvent e) {}
	
}
