package com.meda.anagrams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* AnagramImpl.java
* The AnagramImpl Class implements an Interface called Anagram
* where defined the two methods signature
* This class is used to find anagram groups from the given 
* file using a method findAnagrams
* @author  Retheesh Medamal
*  
*/

public class AnagramImpl implements Anagram {

	String anagramGroupList = null;
	
	/**
	   * This method is used to find the anagram from
	   * the given file.
	   * Use sorted word as a key for map 
	   * If map contains key, add the list
	   * If not, create a new anagram list and add list with key
	   * @filePath This is the "input.txt" file location
	   * @return collection of String anagram words after sorting.
	   */

	public String findAnagrams(String filePath) {

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			Map<String, List<String>> anagramMap = new LinkedHashMap<String, List<String>>();
			String anagramWord;

			/*
			 * Read File Line By Line
			 */

			while ((anagramWord = bufferedReader.readLine()) != null) {
				/*
				 * Sort characters of word
				 */
				String sortedAnagramWord = anagramWordSorting(anagramWord);

				/*
				 * Use sorted word as a key for map 
				 * If map contains key, add the list 
				 * If not, create a new anagram list and add list with key
				 */
				if (!anagramMap.containsKey(sortedAnagramWord)) {
					anagramMap.put(sortedAnagramWord, new ArrayList<String>());

				}
				anagramMap.get(sortedAnagramWord).add(anagramWord);
			}
			
			anagramGroupList = anagramMap.values().stream()
							.filter(list -> list.size() > 1)
							.map(list -> list.stream().sorted().collect(Collectors.joining(" ")))
							.sorted((String o1, String o2) -> o1.length() < o2.length() ? -1 : 1).collect(Collectors.joining("\n"));

		//	anagramGroupList = new ArrayList<List<String>>(anagramMap.values());

		} catch (FileNotFoundException fe) {

			System.out.println("File Not Found :");

		} catch (IOException ie) {

			System.out.println("Error While Reading The File: ");

		}

		return anagramGroupList;

	}

	/*
	 * Sort alphabetically characters of given anagramWord
	 */

	/**
	   * This method is used to Sort alphabetically characters 
	   * of given anagramWord.
	   * @param anagramWord This is a String type form the input.txt file
	   * @return String with sorted characters.
	   */
	public String anagramWordSorting(String anagramWord) {
		char[] sortedChars = anagramWord.toCharArray();
		Arrays.sort(sortedChars);
		return new String(sortedChars);
	}
}