package grail.tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class NumberToken extends Token implements NumberTokenImpl{
	private int value;
	
	public NumberToken(String initialValue){
		super(initialValue);
	}

	public int getValue() {
		int num = Integer.parseInt(input);
		value = num;
		return value;
	}
}
