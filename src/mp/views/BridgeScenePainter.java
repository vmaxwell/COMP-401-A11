package mp.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import util.annotations.Tags;

@Tags({"ObservableBridgeScenePainter"})

public class BridgeScenePainter extends Component implements BridgeScenePainterImpl{
	protected List<PaintListenerImpl> paintListeners = new ArrayList<PaintListenerImpl>();
	
	public BridgeScenePainter(){
		repaint();
		setFocusable(true);
	}
	
	@Tags({"addPaintListener"})
	public void addPaintListener(PaintListenerImpl listener){
		paintListeners.add(listener);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLACK);
		for(PaintListenerImpl listener : paintListeners){
			listener.paint((Graphics2D) g);
		}
	}
}
