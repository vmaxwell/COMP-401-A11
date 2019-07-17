package grail.commands;

import grail.tokens.WordToken;
import grail.tokens.WordTokenImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotateRightArm"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class RotateRightArmCommand extends WordToken implements WordTokenImpl{
	
	public RotateRightArmCommand(String initialValue){
		super(initialValue);
	}
}
