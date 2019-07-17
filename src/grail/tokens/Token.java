package grail.tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Token"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input"})
@EditablePropertyNames({"Input"})

public abstract class Token implements TokenImpl{
	protected String input;
	
	public Token(String initialValue){
		input = initialValue;
	}
	
	public void setInput(String string) {
		input = string;
	}

	public String getInput() {
		return input;
	}

}
