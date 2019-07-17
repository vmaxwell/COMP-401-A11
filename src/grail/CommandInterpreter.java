package grail;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import grail.commands.MoveCommand;
import grail.commands.RunnableMoveCommand;
import grail.commands.RunnableSayCommand;
import grail.commands.SayCommand;
import grail.tokens.MinusToken;
import grail.tokens.NumberTokenImpl;
import grail.tokens.PlusToken;
import grail.tokens.TokenImpl;
import grail.tokens.WordTokenImpl;
import mp.bridgeScene.AvatarImpl;
import mp.bridgeScene.BridgeSceneImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"CommandInterpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Command"})
@EditablePropertyNames({"Command"})

public class CommandInterpreter implements CommandInterpreterImpl{
	private BridgeSceneImpl aBridgeScene;
	private ScanStringImpl aScanner;
	private String command;
	private AnimatorImpl animator;
	protected List<PropertyChangeListener> listenerContents = new ArrayList<PropertyChangeListener>();
	
//	private int index;
	
	public CommandInterpreter(BridgeSceneImpl initBridgeScene, ScanStringImpl initScanner){
		aBridgeScene = initBridgeScene;
		aScanner = initScanner;
		command = "";
		animator = new Animator();
	}
	
	public void setCommand(String commandString){
		String oldCommand = getCommand();
		command = commandString;
		ParserImpl parser = SingletonsCreator.parserFactory();
		parser.setCommandText(command);
		Runnable aCommand = parser.getCommandObject();
		if(aCommand != null){
			aCommand.run();
		}
		notifyAllListeners(new PropertyChangeEvent(this, "setCommand", oldCommand, command));
	}
	
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		listenerContents.add(arg0);
	}
	
	public void notifyAllListeners(PropertyChangeEvent event){
		for(int i = 0; i < listenerContents.size(); i++){
			listenerContents.get(i).propertyChange(event);
		}
	}
	
//	@Tags({"parseSay"})
//	public Runnable parseSay(TokenImpl[] tokens){
//		TokenImpl quotedString = tokens[index+1];
//		String sayInput = quotedString.getInput();
//		Runnable runSayCommand = new RunnableSayCommand(SingletonsCreator.bridgeSceneFactory(), sayInput);
//		return runSayCommand;
//	}
//	
//	@Tags({"parseMove"})
//	public Runnable parseMove(TokenImpl[] tokens){
//		TokenImpl avatarToken = tokens[index+1];
//		TokenImpl xNumPlusMinusToken = tokens[index+2];
//		TokenImpl yNumPlusMinusToken;
//		String avatarName = ((WordTokenImpl) avatarToken).getValue();
//		int x;
//		int y;
//		
//		if(isPlusOrMinus(xNumPlusMinusToken)){
//			TokenImpl xNumToken = tokens[index+3];
//			x = addPlusOrMinusToNum(xNumPlusMinusToken, xNumToken);
//			
//			//determining y-value if x-value has minus or plus
//			yNumPlusMinusToken = tokens[index+4];
//			if(isPlusOrMinus(yNumPlusMinusToken)){
//				TokenImpl yNumToken = tokens[index+5];
//				y = addPlusOrMinusToNum(yNumPlusMinusToken, yNumToken);
//			} else{
//				y = ((NumberTokenImpl) yNumPlusMinusToken).getValue();
//			}
//		} else{
//			x = ((NumberTokenImpl) xNumPlusMinusToken).getValue();
//			//determining y-value if x-value doesn't have minus or plus
//			yNumPlusMinusToken = tokens[index+3];
//			if(isPlusOrMinus(yNumPlusMinusToken)){
//				TokenImpl yNumToken = tokens[index+4];
//				y = addPlusOrMinusToNum(yNumPlusMinusToken, yNumToken);
//			} else{
//				y = ((NumberTokenImpl) yNumPlusMinusToken).getValue();
//			}
//		}
//		
//		AvatarImpl avatar = (AvatarImpl) avatarTable.get(avatarName);
//		Runnable runMoveCommand = new RunnableMoveCommand(avatar, x, y);
//		return runMoveCommand;
//	}
	
	@Tags({"asynchronousArthur"})
	public void asyncArthur(){
		Thread thread = new Thread(new AnimatingCommand(animator, aBridgeScene.getArthur()));
		thread.start();
	}
	
	@Tags({"asynchronousGalahad"})
	public void asyncGalahad(){
		Thread thread = new Thread(new AnimatingCommand(animator, aBridgeScene.getGalahad()));
		thread.start();
	}
	
	@Tags({"asynchronousLancelot"})
	public void asyncLancelot(){
		Thread thread = new Thread(new AnimatingCommand(animator, aBridgeScene.getLancelot()));
		thread.start();
	}
	
	@Tags({"asynchronousRobin"})
	public void asyncRobin(){
		Thread thread = new Thread(new AnimatingCommand(animator, aBridgeScene.getRobin()));
		thread.start();
	}
	
	@Tags({"asynchronousGuard"})
	public void asyncGuard(){
		Thread thread = new Thread(new AnimatingCommand(animator, aBridgeScene.getGuard(), 3));
		thread.start();
	}
	
	public String getCommand(){
		return command;
	}
//	
//	@Visible(false)
//	public TableImpl getAvatarTable(){
//		return avatarTable;
//	}
//	
//	public boolean isPlusOrMinus(TokenImpl token){
//		if(token instanceof PlusToken || token instanceof MinusToken){
//			return true;
//		}
//		
//		return false;
//	}
//	
//	public int addPlusOrMinusToNum(TokenImpl plusOrMinus, TokenImpl numToken){
//		TokenImpl token = numToken;
//		
//		String xNumString = numToken.getInput();
//		String numPlus = plusOrMinus.getInput();
//		token.setInput(numPlus + xNumString);
//		int xNum = ((NumberTokenImpl) token).getValue();
//		
//		return xNum;
//	}
	
	
}
