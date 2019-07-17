package grail;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Table"})
@StructurePattern(StructurePatternNames.MAP_PATTERN)

public interface TableImpl {
	public void put(String key, Object value);
	public Object get(String key);
}
