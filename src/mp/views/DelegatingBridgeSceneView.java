package mp.views;

import grail.SingletonsCreator;
import util.annotations.Tags;

@Tags({"DelegatingBridgeSceneView"})

public class DelegatingBridgeSceneView implements DelegatingBridgeSceneViewImpl{
	private BridgeScenePainterImpl painter;
	
	public DelegatingBridgeSceneView(){
		painter = SingletonsCreator.bridgeScenePainterFactory();
		painter.addPaintListener(new BackgroundView());
		painter.addPaintListener(new ArthurView());
		painter.addPaintListener(new LancelotView());
		painter.addPaintListener(new RobinView());
		painter.addPaintListener(new GalahadView());
		painter.addPaintListener(new GuardView());
	}

}
