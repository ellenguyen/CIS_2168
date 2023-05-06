// Exercise 17.2

// Maximum buckets we can have is 78 but we need to substract 2 (value of 1 and 2) to get 76 buckets
// 

import java.util.*;
import java.util.Map.Entry;

public class ThreeLetterWords {
	private ArrayList<String> words = new ArrayList<>();		// all three-letter words
	private Map<Character, Integer> cMap = new HashMap<>();		// letter-number map
	private Map<String, Integer> wordMap = new HashMap<>();		// word-number map
	
	// Constructor: Build the word-number dictionary. Each word is
	// associated with the sum of its letter values
	public ThreeLetterWords() {
		makeWords();		// already implemented
		buildLetterMap();	// implement below
		buildWordMap();		// implement below
	}
	
	// Build an ArrayList of all three-letter words
	private void makeWords() {
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVXYZ".toCharArray();
		StringBuilder sb = new StringBuilder("");
		for (char a : chars) {
			for (char b : chars) {
				for (char c : chars) {
					sb.append(a).append(b).append(c);
					words.add(sb.toString());
					sb.setLength(0);
				}
			}
		}
	}
	
	// Build the letter-number map (A=1, B=2,.., Z=25)
	private void buildLetterMap() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < alphabet.length(); i++) {
			cMap.put(alphabet.charAt(i), i + 1);
		}
	}
	
	// Build the word-number (sum of letter values) map
	private void buildWordMap() {
		for (String word : words) {		// iterating through each word in the array
			// calculate the sum of letter values of each word
			// since it's three-letter word so no need to write a for loop
			int sum = cMap.get(word.charAt(0)) + cMap.get(word.charAt(1)) + cMap.get(word.charAt(2));
			wordMap.put(word, sum);		// map each word to its sum
			sum = 0;	// reset to 0
		}
	}
	
	// Test the three-letter word data type (add your tests as needed)
	public static void main(String[] args) {
		ThreeLetterWords tlw = new ThreeLetterWords();
		Map<String, Integer> map = tlw.wordMap;
		Map<String, Integer> result = new TreeMap<>();
		
		for (Entry<String, Integer> entry : map.entrySet())
			if (entry.getValue().equals(39)) 
				result.put(entry.getKey(), entry.getValue());
		
		for (Entry<String, Integer> entry : result.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
	}
}