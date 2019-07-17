package mp.views;

import java.awt.Graphics2D;
import java.beans.PropertyChangeListener;

import util.annotations.Tags;

@Tags({"PaintListener"})

public interface PaintListenerImpl extends PropertyChangeListener{
	void paint(Graphics2D g);
}
