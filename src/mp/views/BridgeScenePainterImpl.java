package mp.views;

import java.awt.Graphics;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"ObservableBridgeScenePainter"})

public interface BridgeScenePainterImpl extends PropertyListenerRegisterer{
	void addPaintListener(PaintListenerImpl listener);
	void paint(Graphics g);
}
