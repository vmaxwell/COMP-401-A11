package mp.shapes;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"X", "Y", "Text"})
@EditablePropertyNames({"X", "Y", "Text"})

public class StringShape extends Locatable implements StringShapeImpl{
	private String text;
	
	public StringShape(String initText, int initX, int initY){
		text = initText;
		x = initX;
		y = initY;
	}

	public String getText() {
		return text;
	}

	public void setText(String newText) {
		String oldText = getText();
		text = newText;
		notifyAllListeners(new PropertyChangeEvent(this, "Text", oldText, text));
	}
}
