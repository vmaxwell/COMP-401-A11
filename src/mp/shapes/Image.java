package mp.shapes;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height", "ImageFileName"})
@EditablePropertyNames({"X", "Y", "Width", "Height", "ImageFileName"})


public class Image extends BoundedShape implements ImageImpl{
	private String imageFileName;
	
	public Image(String initFileName, int initX, int initY, int initWidth, int initHeight){
		imageFileName = initFileName;
		x = initX;
		y = initY;
		width = initWidth;
		height = initHeight;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String newFileName) {
		imageFileName = newFileName;
	}
}
