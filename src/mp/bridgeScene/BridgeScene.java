package mp.bridgeScene;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import mp.shapes.Image;
import mp.shapes.Oval;
import mp.shapes.OvalImpl;
import mp.shapes.StringShapeImpl;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Lancelot", "Robin", "Galahad", "Guard", "Gorge", "KnightArea", "GuardArea", "Occupied", "KnightTurn"})

public class BridgeScene implements BridgeSceneImpl{
	private String arthurFileName = "arthur.jpg";
	private int arthurInitX = 50;
	private int arthurInitY = 325;
	private String lancelotFileName = "lancelot.jpg";
	private int lancelotInitX = 200;
	private int lancelotInitY = 325;
	private String robinFileName = "robin.jpg";
	private int robinInitX = 50;
	private int robinInitY = 450;
	private String galahadFileName = "galahad.jpg";
	private int galahadInitX = 200;
	private int galahadInitY = 450;
	private String guardFileName = "guard.jpg";
	private int guardInitX = 235;
	private int guardInitY = 100;
	
	private AvatarImpl arthur;
	private AvatarImpl lancelot;
	private AvatarImpl robin;
	private AvatarImpl galahad;
	private AvatarImpl guard;
	private GorgeAndBridgeImpl gorge;
	private OvalImpl knightArea;
	private OvalImpl guardArea;
	private int knightAreaInitX = 50;
	private int knightAreaInitY = 150;
	private int guardAreaInitX = 200;
	private int guardAreaInitY = 150;
	private int areaWidthAndHeight = 100;
	private boolean occupied;
	
	private boolean knightTurn;
	private AvatarImpl interactingKnight;
	
	private int approachX = 85;
	private int approachY = 100;
	private int passedX = 700;
	private int passedY = 100;
	private int failedX = 450;
	private int failedY = 450;
	
	private List<PropertyChangeListener> listenerContents = new ArrayList<PropertyChangeListener>();
	
	public BridgeScene(){
		Icon arthurIcon = new ImageIcon(arthurFileName);
		arthur = new Avatar(new Image(arthurFileName, arthurInitX, arthurInitY, arthurIcon.getIconWidth(), arthurIcon.getIconHeight()));
		Icon lancelotIcon = new ImageIcon(lancelotFileName);
		lancelot = new Avatar(new Image(lancelotFileName, lancelotInitX, lancelotInitY, lancelotIcon.getIconWidth(), lancelotIcon.getIconHeight()));
		Icon robinIcon = new ImageIcon(robinFileName);
		robin = new Avatar(new Image(robinFileName, robinInitX, robinInitY, robinIcon.getIconWidth(), robinIcon.getIconHeight()));
		Icon galahadIcon = new ImageIcon(galahadFileName);
		galahad = new Avatar(new Image(galahadFileName, galahadInitX, galahadInitY, galahadIcon.getIconWidth(), galahadIcon.getIconHeight()));
		Icon guardIcon = new ImageIcon(guardFileName);
		guard = new Avatar(new Image(guardFileName, guardInitX, guardInitY, guardIcon.getIconWidth(), guardIcon.getIconHeight()));
		gorge = new GorgeAndBridge();
		knightArea = new Oval(knightAreaInitX, knightAreaInitY, areaWidthAndHeight, areaWidthAndHeight);
		guardArea = new Oval(guardAreaInitX, guardAreaInitY, areaWidthAndHeight, areaWidthAndHeight);
		occupied = false;
		knightTurn = false;
		interactingKnight = null;
	}
	
	public boolean preApproach(){
		return !occupied;
	}
	
	@Tags({"Approach"})
	public void approach(AvatarImpl avatar){
		assert preApproach();
		avatar.moveAvatarToPosition(approachX, approachY);
		occupied = true;
		interactingKnight = avatar;
		notifyAllListeners(new PropertyChangeEvent(this, "this", "approach", true));
	}
	
	public boolean preSay(){
		return occupied;
	}
	
	@Tags({"Say"})
	public void say(String string){
		assert preSay();
		if(!knightTurn){
			StringShapeImpl guardString = guard.getStringShape();
			guardString.setText(string);
			knightTurn = true;
			notifyAllListeners(new PropertyChangeEvent(this, "this", "passed", true));
		} else {
			StringShapeImpl knightString = interactingKnight.getStringShape();
			knightString.setText(string);
			knightTurn = false;
		}
	}
	
	public boolean prePassed(){
		return !knightTurn;
	}
	
	@Tags({"Passed"})
	public void passed(){
		assert prePassed();
		interactingKnight.moveAvatar(passedX, passedY);
		occupied = false;
		notifyAllListeners(new PropertyChangeEvent(this, "this", "say", false));
		notifyAllListeners(new PropertyChangeEvent(this, "this", "failed", false));
	}
	
	public boolean preFailed(){
		return occupied;
	}
	
	@Tags({"Failed"})
	public void failed(){
		assert preFailed();
		if(!knightTurn){
			interactingKnight.moveAvatar(failedX, failedY);
			occupied = false;
			notifyAllListeners(new PropertyChangeEvent(this, "this", "failed", false));
			notifyAllListeners(new PropertyChangeEvent(this, "this", "say", false));
		} else {
			guard.moveAvatar(failedX,  failedY);
		}
	}
	
	@Tags({"Occupied"})
	public boolean getOccupied(){
		return occupied;
	}
	
	@Tags({"KnightTurn"})
	public boolean getKnightTurn(){
		return knightTurn;
	}
	
	@Visible(false)
	public AvatarImpl getInteractingKnight(){
		return interactingKnight;
	}

	public AvatarImpl getArthur() {
		return arthur;
	}

	public AvatarImpl getLancelot() {
		return lancelot;
	}

	public AvatarImpl getRobin() {
		return robin;
	}

	public AvatarImpl getGalahad() {
		return galahad;
	}

	public AvatarImpl getGuard() {
		return guard;
	}

	public GorgeAndBridgeImpl getGorge() {
		return gorge;
	}

	public OvalImpl getKnightArea() {
		return knightArea;
	}

	public OvalImpl getGuardArea() {
		return guardArea;
	}
	
	public void scaleAllAvatars(double scaleUnit){
		arthur.scaleAvatar(scaleUnit);
		lancelot.scaleAvatar(scaleUnit);
		robin.scaleAvatar(scaleUnit);
		galahad.scaleAvatar(scaleUnit);
		guard.scaleAvatar(scaleUnit);
	}

	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		listenerContents.add(arg0);
	}
	
	public void notifyAllListeners(PropertyChangeEvent event){
		for(int i = 0; i < listenerContents.size(); i++){
			listenerContents.get(i).propertyChange(event);
		}
	}
	
}
