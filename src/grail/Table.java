package grail;

import java.util.ArrayList;
import java.util.List;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Table"})
@StructurePattern(StructurePatternNames.MAP_PATTERN)

public class Table implements TableImpl{
	private List<String> keyCollection;
	private List<Object> valueCollection;
	
	public Table(){
		keyCollection = new ArrayList<String>();
		valueCollection = new ArrayList<Object>();
	}

	public void put(String key, Object value) {
		if(key != null && value != null){
			if(keyCollection.contains(key)){
				int keyIndex = keyCollection.indexOf(key);
				valueCollection.set(keyIndex, value);
			} else{
				keyCollection.add(key);
				valueCollection.add(value);
			}
		}
	}

	public Object get(String key) {
		if(keyCollection.contains(key)){
			int keyIndex = keyCollection.indexOf(key);
			Object valueAtKeyIndex = valueCollection.get(keyIndex);
		
			if(valueAtKeyIndex != null){
				return valueAtKeyIndex;
			} 
		}
		
		return null;
	}
	
	
}
