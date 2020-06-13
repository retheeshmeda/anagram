package com.meda.anagrams;

import java.io.FileNotFoundException;

public class ListAnagrams {

	/**
	 * This is the main method which makes use of findAnagrams method.
	 * @param args Unused.
	 * @return Nothing.
	 * @exception FileNotFoundException On input file error.
	 * @author  Retheesh Medamal
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		Anagram anagram = new AnagramImpl();

		String anagramGroupList = anagram.findAnagrams("input.txt");
		
		System.out.println(anagramGroupList);

	}

}
