package grail.commands;

import java.util.ArrayList;
import java.util.List;

import util.annotations.Tags;

@Tags({"CommandList"})

public class CommandList implements Runnable{
	
	private List<Runnable> commandList = new ArrayList<Runnable>();
	
	public CommandList(){
		
	}
	
	@Tags({"add"})
	public void addCommand(Runnable command){
		commandList.add(command);
	}

	public void run() {
		for(Runnable command : commandList){
			command.run();
		}
	}
	
}
