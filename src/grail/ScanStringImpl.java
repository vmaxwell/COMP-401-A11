package grail;

import grail.tokens.TokenImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "Tokens"})
@EditablePropertyNames({"ScannedString"})

public interface ScanStringImpl {
	String getScannedString();
	void setScannedString(String input);
	void scanString(String line);
	@Tags({"Tokens"})
	TokenImpl[] getTokens();
	int indexOf(String string, char findChar, int fromIndex);
	int indexOfNot(String string, char findChar, int fromIndex);
}
