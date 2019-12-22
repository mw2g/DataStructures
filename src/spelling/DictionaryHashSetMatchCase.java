/**
 * 
 */
package spelling;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;


/**
 * A class that implements the Dictionary interface with a HashSet
 */
public class DictionaryHashSetMatchCase implements Dictionary 
{

    private HashSet<String> words;
	
	public DictionaryHashSetMatchCase()
	{
	    words = new HashSet<String>();
	}
	
    /** Add this word to the dictionary.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
	@Override
	public boolean addWord(String word) 
	{
		char[] chars = word.toCharArray();
		int upp = 0;
		for (int i = 0; i < chars.length; i++) {
			if (Character.isUpperCase(chars[i])) {
				upp++;
			} 
		}
		
		if (upp == word.length() || upp == 0 || (Character.isUpperCase(word.charAt(0)) && upp == 1)) {
			
			return words.add(word);
			
		} else if (upp == word.length() - 1) {
			
			return words.add(word.toUpperCase());
			
		} else if (Character.isUpperCase(word.charAt(0)) && upp == 2) {
			for (int i = 1; i < chars.length; i++) {
				chars[i] = Character.toLowerCase(chars[i]);
			}
			return words.add(chars.toString());
			
		} else 
			
			return words.add(word.toLowerCase());
		
	}

	/** Return the number of words in the dictionary */
    @Override
	public int size()
	{
    	 return words.size();
	}
	
	/** Is this a word according to this dictionary? */
    @Override
	public boolean isWord(String s) {
    	return words.contains(s);
	}
	
   
}
