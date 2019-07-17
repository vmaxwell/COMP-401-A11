package main;

import java.awt.Component;

import javax.swing.JFrame;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.CommandInterpreterImpl;
import grail.SingletonsCreator;
import mp.bridgeScene.AvatarImpl;
import mp.bridgeScene.BridgeSceneImpl;
import mp.shapes.StringShapeImpl;
import mp.views.BridgeScenePainterImpl;
import util.misc.ThreadSupport;

public class Assignment11 {
	static int seconds = 1000;
	static int seconds2 = 1300;
	static double scaleNum = 0.5;
	static int frameWidth = 850;
	static int frameHeight = 800;
	static int typingAreaHeight = 100;
	static String blank = "";
	
	static int arthurMoveX = 100;
	static int arthurMoveY = -100;
	
	public static void main(String[] args) {

		BridgeSceneImpl bridgeScene = SingletonsCreator.bridgeSceneFactory();
		bridgeScene.scaleAllAvatars(scaleNum);
		
		BridgeScenePainterImpl painter = SingletonsCreator.bridgeScenePainterFactory();
		SingletonsCreator.bridgeSceneControllerFactory();
		SingletonsCreator.delegatingBridgeSceneViewFactory();
		
		JFrame frame = new JFrame("Bridge Scene View");
		frame.add((Component) painter);
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		
		CommandInterpreterImpl commandIntr = SingletonsCreator.commandInterpreterFactory();
		
//		bridgeScene.scaleAllAvatars(scaleNum);
		SingletonsCreator.consoleSceneViewFactory();
		OEFrame anOEframe = ObjectEditor.edit(commandIntr);
		anOEframe.setSize(500, 500);
//		
//		ThreadSupport.sleep(seconds);
//		
		AvatarImpl arthur = bridgeScene.getArthur();
		ThreadSupport.sleep(seconds);
		commandIntr.setCommand("approach arthur ");
		ThreadSupport.sleep(seconds);
		commandIntr.setCommand("say \"Who goes there\" ");
		ThreadSupport.sleep(seconds);
		AvatarImpl guard = bridgeScene.getGuard();
		StringShapeImpl guardText = guard.getStringShape();
		guardText.setText(blank);
		ThreadSupport.sleep(seconds2);
		commandIntr.setCommand("say \"It is I, Sir Arthur\" ");
		ThreadSupport.sleep(seconds);
		commandIntr.setCommand("passed ");
		ThreadSupport.sleep(seconds);
		AvatarImpl lancelot = bridgeScene.getLancelot();
		commandIntr.setCommand("approach lancelot ");
		ThreadSupport.sleep(seconds);
		commandIntr.setCommand("say \"Who goes there now\" ");
		ThreadSupport.sleep(seconds);
		guardText.setText(blank);
		ThreadSupport.sleep(seconds2);
		commandIntr.setCommand("say \"It is I, Sir Lancelot\" ");
		ThreadSupport.sleep(seconds);
		commandIntr.setCommand("failed ");
		ThreadSupport.sleep(seconds);
		commandIntr.setCommand("{ move robin - 30 0 move robin + 30 0 } ");
		ThreadSupport.sleep(seconds);
		commandIntr.setCommand("repeat 2 move robin - 10 + 10 ");
		ThreadSupport.sleep(seconds);
		
		commandIntr.asyncArthur();
		commandIntr.asyncGalahad();
		commandIntr.asyncGalahad();
		
	}
}
