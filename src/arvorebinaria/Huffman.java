package arvorebinaria;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Huffman {
	private Map<Character, Integer> letterMap = new TreeMap<>();

	public void Encode(String text) {
		createLetterMap(text);
		List<Entry<Character, Integer>> letterEntryOrdered = getOrderedEntryList(letterMap);
		
		System.out.println("sadasdas");

	}

	public Map<Character, Integer> createLetterMap(String frase) {
		for (char item : frase.toCharArray()) {
			Integer s = letterMap.get(item);
			if (s != null) {
				letterMap.put(item, ++s);
			} else {
				letterMap.put(item, 1);
			}
		}

		letterMap.values();
		return letterMap;
	}
	
	public List<Entry<Character, Integer>> getOrderedEntryList(Map<Character, Integer> map){
		return map.entrySet().stream()
				.sorted((k1, k2) -> Integer.compare(k1.getValue(), k2.getValue())).collect(Collectors.toList());
	}

	public void printMap() {
		for (Map.Entry<Character, Integer> a : letterMap.entrySet()) {
			System.out.println(a.getKey() + ": " + a.getValue());
		}
	}

	public static void main(String[] args) {
		new Huffman().Encode("ABBBCDEFGA");
	}

}
