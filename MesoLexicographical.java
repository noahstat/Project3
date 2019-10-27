import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoLexicographical extends MesoSortedAbstract
{
	private HashMap<String, Integer> map;
	
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		this.map = asciiVal;
		TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(asciiVal);
		
		for (String stIds : sorted.keySet())
		{
			//System.out.println(stIds + " " + asciiVal.get(stIds));
			//Printing the unsorted map
		    System.out.println(stIds);		    
		}	
	}

	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(map);
		
		for (String stIds : sorted.keySet())
		{
			//System.out.println(stIds + " " + asciiVal.get(stIds));
			//Printing the unsorted map
		    System.out.println(stIds);		    
		}	
		
		return sorted;
	}

}