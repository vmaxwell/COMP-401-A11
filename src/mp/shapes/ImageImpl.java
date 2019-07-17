package mp.shapes;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height", "ImageFileName"})
@EditablePropertyNames({"X", "Y", "Width", "Height", "ImageFileName"})

public interface ImageImpl extends BoundedShapeImpl{
	String getImageFileName();
	void setImageFileName(String newFileName);
}
