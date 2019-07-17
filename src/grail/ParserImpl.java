package grail;

import grail.tokens.TokenImpl;
import util.annotations.Tags;

@Tags({"Parser"})

public interface ParserImpl {
	Runnable getCommandObject();
	void setCommandText(String text);
	@Tags({"parseCommand"})
	Runnable parseCommand();
	@Tags({"parseSayCommand"})
	Runnable parseSayCommand();
	@Tags({"parseMoveCommand"})
	Runnable parseMoveCommand();
	@Tags({"parseApproachCommand"})
	Runnable parseApproachCommand();
	@Tags({"parsePassCommand"})
	Runnable parsePassCommand();
	@Tags({"parseFailCommand"})
	Runnable parseFailCommand();
	@Tags({"parseCommandList"})
	public Runnable parseCommandList();
	@Tags({"parseRepeatCommand"})
	Runnable parseRepeatCommand();
	TokenImpl next();
	TokenImpl peek();
	boolean hasNext();
	void reset();
}
