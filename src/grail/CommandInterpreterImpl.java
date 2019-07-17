package grail;

import grail.tokens.TokenImpl;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"CommandInterpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Command"})
@EditablePropertyNames({"Command"})

public interface CommandInterpreterImpl {
	String getCommand();
	void setCommand(String commandString);
//	@Visible(false)
//	TableImpl getAvatarTable();
//	boolean isPlusOrMinus(TokenImpl token);
//	int addPlusOrMinusToNum(TokenImpl plusOrMinus, TokenImpl numToken);
//	@Tags({"parseSay"})
//	Runnable parseSay(TokenImpl[] tokens);
//	@Tags({"parseMove"})
//	Runnable parseMove(TokenImpl[] tokens);
	@Tags({"asynchronousArthur"})
	void asyncArthur();
	@Tags({"asynchronousGalahad"})
	void asyncGalahad();
	@Tags({"asynchronousLancelot"})
	void asyncLancelot();
	@Tags({"asynchronousRobin"})
	void asyncRobin();
	@Tags({"asynchronousGuard"})
	void asyncGuard();
}
