package grail.tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class WordToken extends Token implements WordTokenImpl{
	protected String value;
	
	public WordToken(String initialValue){
		super(initialValue);
	}

	public String getValue() {
		value = "";
		
		for(int i = 0; i < input.length(); i++){
			char currentChar = input.charAt(i);
			String letter = input.substring(i, i+1);
			if(Character.isUpperCase(currentChar)){
				String lowercaseLetter = letter.toLowerCase();
				value = value + lowercaseLetter;
			} else{
				value = value + letter;
			}
		}
		
		return value;
	}

}
