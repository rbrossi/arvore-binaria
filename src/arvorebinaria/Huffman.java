package arvorebinaria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Huffman {
	private Map<Character, Integer> letterMap = new TreeMap<>();

	public String Encode(String text) {
		createLetterMap(text);
		List<ArvoreBinaria<HuffmanNodeInfo>> list = createTreeList(letterMap);
		list = SortTreeList(list);

		while (list.size() > 1) {
			ArvoreBinaria<HuffmanNodeInfo> n1 = list.get(0);
			ArvoreBinaria<HuffmanNodeInfo> n2 = list.get(1);

			int frequency1 = n1.getRaiz().getInfo().getFrequency();
			int frequency2 = n2.getRaiz().getInfo().getFrequency();
			int newFreequency = frequency1 + frequency2;

			ArvoreBinaria<HuffmanNodeInfo> newNode = new ArvoreBinaria<HuffmanNodeInfo>(
					new NoArvoreBinaria<HuffmanNodeInfo>(new HuffmanNodeInfo(newFreequency)));
			newNode.getRaiz().setEsquerda(n1.getRaiz());
			newNode.getRaiz().setDireita(n2.getRaiz());

			list.remove(n1);
			list.remove(n2);
			list.add(newNode);
			list = SortTreeList(list);
		}

		ArvoreBinaria<HuffmanNodeInfo> tree = list.get(0);
		Map<Character, String> huffmanEncodeMap = new HashMap<>();

		huffmanEncodeMap = tree.getCharCodeMap();

		StringBuilder result = new StringBuilder();
		for (char c : text.toCharArray()) {
			result.append(huffmanEncodeMap.get(c));
		}
		
		System.out.println(result.toString());
		return result.toString();
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

		return letterMap;
	}

	public List<ArvoreBinaria<HuffmanNodeInfo>> SortTreeList(List<ArvoreBinaria<HuffmanNodeInfo>> treeSet) {
		return treeSet.stream().sorted((k1, k2) -> Integer.compare(k1.getRaiz().getInfo().getFrequency(),
				k2.getRaiz().getInfo().getFrequency())).collect(Collectors.toList());
	}

	public List<ArvoreBinaria<HuffmanNodeInfo>> createTreeList(Map<Character, Integer> map) {
		return map.entrySet().stream()
				.map(e -> new ArvoreBinaria<HuffmanNodeInfo>(
						new NoArvoreBinaria<HuffmanNodeInfo>(new HuffmanNodeInfo(e.getValue(), e.getKey()))))
				.collect(Collectors.toList());
	}

	static class Util {
		public void printMap(Map<Character, Integer> letterMap) {
			for (Map.Entry<Character, Integer> a : letterMap.entrySet()) {
				System.out.println(a.getKey() + ": " + a.getValue());
			}
		}

		private static void printTreeSet(List<ArvoreBinaria<HuffmanNodeInfo>> set) {
			System.out.println("--------------");
			set.stream().forEach(e -> {
				e.toString();
				// System.out.println(e.getRaiz().getInfo().getCharacter() +
				// ":"+e.getRaiz().getInfo().getFrequency());
			});
		}

		private static void printHuffmanCodeMap(Map<Character, String> map) {
			map.entrySet().stream().forEach(e -> {
				System.out.println(e.getKey()+":"+e.getValue());
			});
		}
	}
}
