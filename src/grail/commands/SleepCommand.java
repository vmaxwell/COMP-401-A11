package grail.commands;

import grail.tokens.WordToken;
import grail.tokens.WordTokenImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Sleep"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class SleepCommand extends WordToken implements WordTokenImpl{
	
	public SleepCommand(String initialValue){
		super(initialValue);
	}
}
