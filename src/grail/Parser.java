package grail;

import grail.commands.ApproachCommand;
import grail.commands.CommandList;
import grail.commands.FailCommand;
import grail.commands.MoveCommand;
import grail.commands.PassCommand;
import grail.commands.RepeatCommand;
import grail.commands.RunnableApproachCommand;
import grail.commands.RunnableFailCommand;
import grail.commands.RunnableMoveCommand;
import grail.commands.RunnablePassCommand;
import grail.commands.RunnableRepeatCommand;
import grail.commands.RunnableSayCommand;
import grail.commands.SayCommand;
import grail.tokens.MinusToken;
import grail.tokens.NumberToken;
import grail.tokens.NumberTokenImpl;
import grail.tokens.PlusToken;
import grail.tokens.StartToken;
import grail.tokens.TokenImpl;
import grail.tokens.WordTokenImpl;
import mp.bridgeScene.AvatarImpl;
import mp.bridgeScene.BridgeSceneImpl;
import util.annotations.Tags;

@Tags({"Parser"})

public class Parser implements ParserImpl{

	@Tags({"CommandText"})
	private String commandText;
	@Tags({"CommandObject"})
	private Runnable command;
	private TokenImpl[] tokenList;
	private BridgeSceneImpl bridgeScene;
	private TableImpl avatarTable;
	private ScanStringImpl aScanner;
	private int index = 0;
	
	public Parser(){
		aScanner = SingletonsCreator.scannerFactory();
		bridgeScene = SingletonsCreator.bridgeSceneFactory();
		
		avatarTable = SingletonsCreator.avatarTableFactory();
		avatarTable.put("arthur", bridgeScene.getArthur());
		avatarTable.put("lancelot", bridgeScene.getLancelot());
		avatarTable.put("robin", bridgeScene.getRobin());
		avatarTable.put("galahad", bridgeScene.getGalahad());
		avatarTable.put("guard", bridgeScene.getGuard());
	}
	
	public Runnable getCommandObject(){
		return command;
	}
	
	public void setCommandText(String text){
		commandText = text;
		aScanner.setScannedString(commandText);
		tokenList = aScanner.getTokens();
		
		command = parseCommand();
		reset();
	}
	
	@Tags({"parseCommand"})
	public Runnable parseCommand(){
		TokenImpl currentToken = next();
		Runnable commands = null;
		if(currentToken instanceof SayCommand){
			commands = parseSayCommand();
		} else if(currentToken instanceof MoveCommand){
			commands = parseMoveCommand();
		} else if(currentToken instanceof ApproachCommand){
			commands = parseApproachCommand();
		} else if(currentToken instanceof PassCommand){
			commands = parsePassCommand();
		} else if(currentToken instanceof FailCommand){
			commands = parseFailCommand();
		} else if(currentToken instanceof StartToken){
			commands = parseCommandList();
		} else if(currentToken instanceof RepeatCommand){
			commands = parseRepeatCommand();
		}
		return commands;
	}
	
	@Tags({"parseSayCommand"})
	public Runnable parseSayCommand(){
		TokenImpl quotedString = next();
		String sayInput = quotedString.getInput();
		Runnable runSayCommand = new RunnableSayCommand(bridgeScene, sayInput);
		return runSayCommand;
	}
	
	@Tags({"parseMoveCommand"})
	public Runnable parseMoveCommand(){
		TokenImpl avatarToken = next();
		String avatarName = ((WordTokenImpl) avatarToken).getValue();
		int xNum = parseNumber();
		int yNum = parseNumber();
		
		AvatarImpl avatar = (AvatarImpl) avatarTable.get(avatarName);
		Runnable runMoveCommand = new RunnableMoveCommand(avatar, xNum, yNum);
		return runMoveCommand;
	}
	
	@Tags({"parseNumber"})
	public int parseNumber(){
		int num;
		TokenImpl currentToken = next();
		if(currentToken instanceof PlusToken || currentToken instanceof MinusToken){
			String minusOrPlus = currentToken.getInput();
			TokenImpl numToken = next();
			String numString = numToken.getInput();
			numToken.setInput(minusOrPlus + numString);
			num = ((NumberToken) numToken).getValue();
		} else{
			num = ((NumberToken) currentToken).getValue();
		}
		return num;
	}
	
	@Tags({"parseApproachCommand"})
	public Runnable parseApproachCommand(){
		TokenImpl currentToken = next();
		String avatarName = currentToken.getInput();
		AvatarImpl avatar = (AvatarImpl) avatarTable.get(avatarName);
		Runnable runApproachCommand = new RunnableApproachCommand(bridgeScene, avatar);
		return runApproachCommand;
	}
	
	@Tags({"parsePassCommand"})
	public Runnable parsePassCommand(){
		Runnable runPassCommand = new RunnablePassCommand(bridgeScene);
		return runPassCommand;
	}
	
	@Tags({"parseFailCommand"})
	public Runnable parseFailCommand(){
		Runnable runFailCommand = new RunnableFailCommand(bridgeScene);
		return runFailCommand;
	}
	
	@Tags({"parseCommandList"})
	public Runnable parseCommandList(){
		Runnable runCommandList = new CommandList();
		while(hasNext()){
			Runnable commands = parseCommand();
			((CommandList)runCommandList).addCommand(commands);
		}
		return runCommandList;
	}
	
	@Tags({"parseRepeatCommand"})
	public Runnable parseRepeatCommand(){
		int num = parseNumber();
		Runnable aCommand = parseCommand();
		Runnable runRepeatCommand = new RunnableRepeatCommand(num, aCommand);
		return runRepeatCommand;
	}
	
	public TokenImpl next(){
		TokenImpl currentToken = peek();
		index++;
		return currentToken;
	}
	
	public TokenImpl peek(){
		return tokenList[index];
	}
	
	public boolean hasNext(){
		if(index + 1 == tokenList.length){
			return false;
		}
		return true;
	}
	
	public void reset(){
		index = 0;
	}
	
}
