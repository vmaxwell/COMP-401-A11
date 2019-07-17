package grail;

import java.beans.PropertyChangeListener;

import mp.bridgeScene.BridgeScene;
import mp.bridgeScene.BridgeSceneImpl;
import mp.views.ConsoleSceneView;
import mp.views.BridgeSceneController;
import mp.views.BridgeSceneControllerImpl;
import mp.views.BridgeScenePainter;
import mp.views.BridgeScenePainterImpl;
import mp.views.DelegatingBridgeSceneView;
import mp.views.DelegatingBridgeSceneViewImpl;
import util.annotations.Tags;

@Tags({"SingletonsCreator"})


public class SingletonsCreator {
	private static ScanStringImpl scanner;
	private static BridgeSceneImpl bridgeScene;
	private static TableImpl table;
	private static CommandInterpreterImpl commandInterpreter;
	private static PropertyChangeListener consoleSceneView;
	private static BridgeScenePainterImpl bridgeScenePainter;
	private static DelegatingBridgeSceneViewImpl delegatingBridgeSceneView;
	private static BridgeSceneControllerImpl bridgeSceneController;
	private static ParserImpl parser;
	
	@Tags({"scannerFactoryMethod"})
	public static ScanStringImpl scannerFactory() {
		if(scanner == null){
			scanner = new ScanString();
		}
		
		return scanner;
	}

	@Tags({"bridgeSceneFactoryMethod"})
	public static BridgeSceneImpl bridgeSceneFactory() {
		if(bridgeScene == null){
			bridgeScene = new BridgeScene();
		}
		
		return bridgeScene;
	}

	@Tags({"avatarTableFactoryMethod"})
	public static TableImpl avatarTableFactory() {
		if(table == null){
			table = new Table();
		}
		
		return table;
	}

	@Tags({"commandInterpreterFactoryMethod"})
	public static CommandInterpreterImpl commandInterpreterFactory() {
		if(commandInterpreter == null){
			commandInterpreter = new CommandInterpreter(bridgeSceneFactory(), scannerFactory());
		}
		
		return commandInterpreter;
	}
	
	@Tags({"consoleSceneViewFactoryMethod"})
	public static PropertyChangeListener consoleSceneViewFactory() {
		if(consoleSceneView == null){
			consoleSceneView = new ConsoleSceneView();
		}
		
		return consoleSceneView;
	}
	
	@Tags({"observableBridgeScenePainterFactoryMethod"})
	public static BridgeScenePainterImpl bridgeScenePainterFactory(){
		if(bridgeScenePainter == null){
			bridgeScenePainter = new BridgeScenePainter();
		}
		
		return bridgeScenePainter;
	}
	
	@Tags({"delegatingBridgeSceneViewFactoryMethod"})
	public static DelegatingBridgeSceneViewImpl delegatingBridgeSceneViewFactory(){
		if(delegatingBridgeSceneView == null){
			delegatingBridgeSceneView = new DelegatingBridgeSceneView();
		}
		
		return delegatingBridgeSceneView;
	}
	
	@Tags({"bridgeSceneControllerFactoryMethod"})
	public static BridgeSceneControllerImpl bridgeSceneControllerFactory(){
		if(bridgeSceneController == null){
			bridgeSceneController = new BridgeSceneController(bridgeScenePainterFactory());
		}
		
		return bridgeSceneController;
	}
	
	@Tags({"parserFactoryMethod"})
	public static ParserImpl parserFactory(){
		if(parser == null){
			parser = new Parser();
		}
		
		return parser;
	}

}
