package mp.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import grail.SingletonsCreator;
import mp.bridgeScene.AvatarImpl;
import mp.bridgeScene.BridgeSceneImpl;
import mp.shapes.AngleShapeImpl;
import mp.shapes.LineImpl;
import mp.shapes.StringShapeImpl;
import util.annotations.Tags;

@Tags({"ConsoleSceneView"})

public class ConsoleSceneView implements PropertyChangeListener{
	private BridgeSceneImpl theBridgeScene;
	
	private AvatarImpl arthur;
	private AngleShapeImpl arthurArms;
	private LineImpl arthurLeftArm;
	private LineImpl arthurRightArm;
	private AngleShapeImpl arthurLegs;
	private LineImpl arthurLeftLeg;
	private LineImpl arthurRightLeg;
	private StringShapeImpl arthurWords;
	
	private AvatarImpl lancelot;
	private AngleShapeImpl lancelotArms;
	private LineImpl lancelotLeftArm;
	private LineImpl lancelotRightArm;
	private AngleShapeImpl lancelotLegs;
	private LineImpl lancelotLeftLeg;
	private LineImpl lancelotRightLeg;
	private StringShapeImpl lancelotWords;
	
	private AvatarImpl robin;
	private AngleShapeImpl robinArms;
	private LineImpl robinLeftArm;
	private LineImpl robinRightArm;
	private AngleShapeImpl robinLegs;
	private LineImpl robinLeftLeg;
	private LineImpl robinRightLeg;
	private StringShapeImpl robinWords;
	
	private AvatarImpl galahad;
	private AngleShapeImpl galahadArms;
	private LineImpl galahadLeftArm;
	private LineImpl galahadRightArm;
	private AngleShapeImpl galahadLegs;
	private LineImpl galahadLeftLeg;
	private LineImpl galahadRightLeg;
	private StringShapeImpl galahadWords;
	
	private AvatarImpl guard;
	private AngleShapeImpl guardArms;
	private LineImpl guardLeftArm;
	private LineImpl guardRightArm;
	private AngleShapeImpl guardLegs;
	private LineImpl guardLeftLeg;
	private LineImpl guardRightLeg;
	private StringShapeImpl guardWords;
	
	public ConsoleSceneView(){
		theBridgeScene = SingletonsCreator.bridgeSceneFactory();
		arthur = theBridgeScene.getArthur();
		lancelot = theBridgeScene.getLancelot();
		robin = theBridgeScene.getRobin();
		galahad = theBridgeScene.getGalahad();
		guard = theBridgeScene.getGuard();
		
		theBridgeScene.addPropertyChangeListener(this);
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
		
		lancelotArms = lancelot.getArms();
		lancelotLeftArm = lancelotArms.getLeftLine();
		lancelotLeftArm.addPropertyChangeListener(this);
		lancelotRightArm = lancelotArms.getRightLine();
		lancelotRightArm.addPropertyChangeListener(this);
		lancelotLegs = lancelot.getLegs();
		lancelotLeftLeg = lancelotLegs.getLeftLine();
		lancelotLeftLeg.addPropertyChangeListener(this);
		lancelotRightLeg = lancelotLegs.getRightLine();
		lancelotRightLeg.addPropertyChangeListener(this);
		lancelotWords = lancelot.getStringShape();
		lancelotWords.addPropertyChangeListener(this);
		
		robinArms = robin.getArms();
		robinLeftArm = robinArms.getLeftLine();
		robinLeftArm.addPropertyChangeListener(this);
		robinRightArm = robinArms.getRightLine();
		robinRightArm.addPropertyChangeListener(this);
		robinLegs = robin.getLegs();
		robinLeftLeg = robinLegs.getLeftLine();
		robinLeftLeg.addPropertyChangeListener(this);
		robinRightLeg = robinLegs.getRightLine();
		robinRightLeg.addPropertyChangeListener(this);
		robinWords = robin.getStringShape();
		robinWords.addPropertyChangeListener(this);
		
		galahadArms = galahad.getArms();
		galahadLeftArm = galahadArms.getLeftLine();
		galahadLeftArm.addPropertyChangeListener(this);
		galahadRightArm = galahadArms.getRightLine();
		galahadRightArm.addPropertyChangeListener(this);
		galahadLegs = galahad.getLegs();
		galahadLeftLeg = galahadLegs.getLeftLine();
		galahadLeftLeg.addPropertyChangeListener(this);
		galahadRightLeg = galahadLegs.getRightLine();
		galahadRightLeg.addPropertyChangeListener(this);
		galahadWords = galahad.getStringShape();
		galahadWords.addPropertyChangeListener(this);
		
		guardArms = guard.getArms();
		guardLeftArm = guardArms.getLeftLine();
		guardLeftArm.addPropertyChangeListener(this);
		guardRightArm = guardArms.getRightLine();
		guardRightArm.addPropertyChangeListener(this);
		guardLegs = guard.getLegs();
		guardLeftLeg = guardLegs.getLeftLine();
		guardLeftLeg.addPropertyChangeListener(this);
		guardRightLeg = guardLegs.getRightLine();
		guardRightLeg.addPropertyChangeListener(this);
		guardWords = guard.getStringShape();
		guardWords.addPropertyChangeListener(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
	}

}
