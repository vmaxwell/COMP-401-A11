package grail.tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"End"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input"})
@EditablePropertyNames({"Input"})

public class EndToken extends Token implements TokenImpl{

	public EndToken(String initialValue){
		super(initialValue);
	}
}
