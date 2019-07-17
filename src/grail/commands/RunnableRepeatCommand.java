package grail.commands;

import util.annotations.Tags;

@Tags({"RepeatCommand"})

public class RunnableRepeatCommand implements Runnable{

	private int repeatNum;
	private Runnable command;
	
	public RunnableRepeatCommand(int num, Runnable aCommand){
		repeatNum = num;
		command = aCommand;
	}
	
	public void run() {
		for(int i = 0; i < repeatNum; i++){
			command.run();
		}
	}

}
