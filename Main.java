package count_repeat_array_elems; 

import java.util.*;

public class Main {
	public static void main(String[] args) {
		final String[] arr = {"a1", "a2", "a3", "a1", "a3", "a10", "a1", "a55", "a55", "a55", "a23", "a23", "b1", "b1", "b1", "b1", "a11", "a12"};
		
		Map<String,Integer> map = new HashMap<>();
		
		//Groupping elements
		Integer val;
		Integer valNew = 0;
		for(String el : arr) {
			val = map.get(el);
			if (val == null) valNew = 1;
			else valNew = val + 1;
			map.put(el, valNew);
			//System.out.println(el);
		}
		
		System.out.println("Groupping elements:");
		for (Map.Entry<String,Integer> item : map.entrySet()) {
			System.out.printf(" Key: %s Value: %s \n", item.getKey(), item.getValue());
		}

		//Filter unique elements
		Map<String,Integer> mapUniq = new LinkedHashMap<>();
		map.entrySet().stream()
			//.filter(el->el.getValue()>1)
			.filter(el->el.getValue()==1)
			//.sorted(new KeyComparator<String,Integer>())
			.sorted(Map.Entry.comparingByKey())
			//.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.forEach(el->mapUniq.put(el.getKey(), el.getValue()));
	
		System.out.println("Unique elements:");
		for (Map.Entry<String,Integer> item : mapUniq.entrySet()) {
			System.out.printf(" Key: %s Value: %s \n", item.getKey(), item.getValue());
		}	
		
	}
}
class KeyComparator<K, V extends Comparable<V>> implements Comparator<Map.Entry<K, V>> {
	public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
		Integer v1 = (Integer) a.getValue();
		Integer v2 = (Integer) b.getValue();
		
		String k1 = (String) a.getKey();
		String k2 = (String) b.getKey();

		if (v1 != v2) {
			return v2 - v1;
		}
		
		return k1.toUpperCase().compareTo(k2.toUpperCase());
		
		//return a.getValue().compareTo(b.getValue());
	}
}