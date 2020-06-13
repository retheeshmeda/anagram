package com.meda.anagrams;

import java.io.FileNotFoundException;

public class ListAnagrams {

	public static void main(String[] args) throws FileNotFoundException {

		Anagram anagram = new AnagramImpl();

		String anagramGroupList = anagram.findAnagrams("input.txt");
		
		System.out.println(anagramGroupList);

	}

}
