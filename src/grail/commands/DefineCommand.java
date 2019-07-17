package grail.commands;

import grail.tokens.WordToken;
import grail.tokens.WordTokenImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Define"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class DefineCommand extends WordToken implements WordTokenImpl{
	
	public DefineCommand(String initialValue){
		super(initialValue);
	}
}
