package grail;

import grail.commands.ApproachCommand;
import grail.commands.CallCommand;
import grail.commands.DefineCommand;
import grail.commands.FailCommand;
import grail.commands.MoveCommand;
import grail.commands.PassCommand;
import grail.commands.ProceedAllCommand;
import grail.commands.RedoCommand;
import grail.commands.RepeatCommand;
import grail.commands.RotateLeftArmCommand;
import grail.commands.RotateRightArmCommand;
import grail.commands.SayCommand;
import grail.commands.SleepCommand;
import grail.commands.ThreadCommand;
import grail.commands.UndoCommand;
import grail.commands.WaitCommand;
import grail.tokens.EndToken;
import grail.tokens.MinusToken;
import grail.tokens.NumberToken;
import grail.tokens.PlusToken;
import grail.tokens.QuotedStringToken;
import grail.tokens.StartToken;
import grail.tokens.Token;
import grail.tokens.TokenImpl;
import grail.tokens.WordToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "Tokens"})
@EditablePropertyNames({"ScannedString"})

public class ScanString implements ScanStringImpl{
	
	private String scannedString;
	private TokenImpl[] largeArray;
	private TokenImpl[] tokenArray = {};
	
	public ScanString(){
		scannedString = "";
		largeArray = new Token[100];
	}
	
	public String getScannedString(){
		return scannedString;
	}
	
	@Tags({"Tokens"})
	public TokenImpl[] getTokens(){
		return tokenArray;
	}
	
	public void setScannedString(String input){
		scannedString = input;
		scanString(scannedString);
		
		int totalNumTokens = findNumOfTokens();
		tokenArray = new TokenImpl[totalNumTokens];
		
		for(int i = 0; i < totalNumTokens; i++){
			TokenImpl currentToken = largeArray[i];
			tokenArray[i] = currentToken;
		}
		
	}
	
	public void scanString(String line){
		
		int i = 0;
		int currentArrayIndex = 0;
		while(i < line.length()){
			int nextChar = indexOfNot(line, ' ', i);
			int nextSpace = indexOf(line, ' ', nextChar);
			
			if(nextSpace == -1){
				System.out.println("Must put spaces after tokens! Last one included!");
				return;
			} else{
				String stringOutput = line.substring(nextChar, nextSpace);
				char firstChar = stringOutput.charAt(0);
				TokenImpl token;
				
				char doubleQuote = '"';
				int indexLastQuote = indexOf(line, doubleQuote, nextChar + 1);
				String lastQuoteString;
				char lastChar = ' ';
				if(indexLastQuote != -1){
					lastQuoteString = line.substring(indexLastQuote, indexLastQuote + 1);
					lastChar = lastQuoteString.charAt(0);
				}
				
				char plus = '+';
				char minus = '-';
				char start = '{';
				char end = '}';
				
				if(Character.isDigit(firstChar)){
					token = new NumberToken(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "move".equalsIgnoreCase(stringOutput)){
					token = new MoveCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "say".equalsIgnoreCase(stringOutput)){
					token = new SayCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "repeat".equalsIgnoreCase(stringOutput)){
					token = new RepeatCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "approach".equalsIgnoreCase(stringOutput)){
					token = new ApproachCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "passed".equalsIgnoreCase(stringOutput)){
					token = new PassCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "failed".equalsIgnoreCase(stringOutput)){
					token = new FailCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "rotateleftarm".equalsIgnoreCase(stringOutput)){
					token = new RotateLeftArmCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "rotaterightarm".equalsIgnoreCase(stringOutput)){
					token = new RotateRightArmCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "define".equalsIgnoreCase(stringOutput)){
					token = new DefineCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "call".equalsIgnoreCase(stringOutput)){
					token = new CallCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "thread".equalsIgnoreCase(stringOutput)){
					token = new ThreadCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "wait".equalsIgnoreCase(stringOutput)){
					token = new WaitCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "proceedall".equalsIgnoreCase(stringOutput)){
					token = new ProceedAllCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "sleep".equalsIgnoreCase(stringOutput)){
					token = new SleepCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "undo".equalsIgnoreCase(stringOutput)){
					token = new UndoCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar) && "redo".equalsIgnoreCase(stringOutput)){
					token = new RedoCommand(stringOutput);
					
				} else if(Character.isLetter(firstChar)){
					token = new WordToken(stringOutput);
					
				} else if(firstChar == doubleQuote && lastChar == doubleQuote){
					String quote = line.substring(nextChar + 1, indexLastQuote);
					token = new QuotedStringToken(quote);
					
					nextSpace = indexLastQuote + 1;
				} else if(firstChar == plus){
					String stringOutputPlus = stringOutput.substring(0, 1);
					token = new PlusToken(stringOutputPlus);
					
				} else if(firstChar == minus){
					String stringOutputMinus = stringOutput.substring(0, 1);
					token = new MinusToken(stringOutputMinus);
					
				} else if(firstChar == start){
					String stringOutputStart = stringOutput.substring(0, 1);
					token = new StartToken(stringOutputStart);
					
				} else if(firstChar == end){
					String stringOutputEnd = stringOutput.substring(0, 1);
					token = new EndToken(stringOutputEnd);
				
				}else{
					System.out.println("Must have two double quotes around quoted string!");
					return;
				}
				
				largeArray[currentArrayIndex] = token;
				
				currentArrayIndex++;
				i = nextSpace + 1;
			}
		}
	}
	
	public int indexOf(String string, char findChar, int fromIndex){
		char charInString;
		int findIndex = -1;
		int i = fromIndex;
		while(i < string.length()){
			charInString = string.charAt(i);
			if(charInString == findChar){
				findIndex = i;
				return findIndex;
			}
			
			i++;
		}
		
		return findIndex;
	}
	
	public int indexOfNot(String string, char ch, int fromIndex){
		int findIndex = -1;
		
		int i = fromIndex;
		while(i < string.length()){
			char currentChar = string.charAt(i);
			if(currentChar != ch){
				findIndex = i;
				return findIndex;
			}
			i++;
		}
		
		return findIndex;
	}
	
	public int findNumOfTokens(){
		int num = 0;
		for(int i = 0; i < largeArray.length; i++){
			TokenImpl currentToken = largeArray[i];
			
			if(currentToken != null){
				num++;
			}
		}
		
		return num;
	}
}

