/**
* Course: Intro To Computer Science
* Homework: 3
* Task: 3
* Name: Guy Itzhaki
* E-mail: itzhaki1234@gmail.com
*/

public class StringOps 
{
	
	public static void main(String[] args) 
	{
		test_concat();
		test_trim();
		test_charRunCount();
		test_tokenize();
		test_removeChar();
	}
	
    private static void test_concat () 
    {
    	String[] strings = new String[3];
	    strings[0] = "wiki";
	    strings[1] = "pe";
	    strings[2] = "dia";
	    System.out.println(concat(strings)); // Should print: wikipedia
	}
    
	private static void test_trim () 
	{
        String s = "aaahappy birthdayaaaaaaa";
        System.out.println(trim(s,'a'));  // should print "happy birthday"
    }
	
	private static void test_charRunCount () 
	{
		String s = "GCCAATGGGGCCGGTTGGGGGGGGG";
		System.out.println(charRunCount(s,'G')); // should print 4
	}
	
	private static void test_tokenize () 
	{
        String s = "   x  + Math.sqrt(x)    - rate  ";
        // creates an array of tokens, using the space character ' ' as a separator
        String[] tokens = tokenize(s,' ');
        for (int i = 0; i < tokens.length; i++)
        {
        	System.out.println(tokens[i]);
	    }
        // Should print:
        // x
        // +
        // Math.sqrt(x)
        // -
        // rate
    }
	
	// Tests the removeChar function
    private static void test_removeChar () 
    {
	    String s = "   x  + Math.sqrt(x)    - rate  ";
	    System.out.println(removeChar(s,' ')); // Should print: x+Math.sqrt(x)-rate
	}
    
    /**
	 * Returns a string which is the concatenation of the given array of strings
	 */
	public static String concat (String[] arr) 
	{
		String comb="";
		for (int i=0; i<arr.length; i++)
			comb=comb+arr[i];
	    return comb;
	}
	
	/**
	 * Trims the given character from the beginning and end of the given string.
	 * For example, if the given string is "aaahappy birthdayaaaaaaa", and the given
	 * character is 'a', returns the string "happy birthday".
	 */
	public static String trim (String str, char c) 
	{
		String rightleft=""; 
		String trimmed="";
		int i=0;
		while (str.charAt(i)==c)
			i++;
		for (int j=str.length()-1; j>=i; j--) // Making an opposite String to delete the end
			rightleft=rightleft+str.charAt(j); //Copies the given string backwards "aaaaaaayadhtrub yppah"
		int m=0;
		while (rightleft.charAt(m)==c)
			m++;
		for (int n=rightleft.length()-1; n>=m; n--) // Making an opposite String to delete the end
			trimmed=trimmed+rightleft.charAt(n);
		return trimmed;
	}
	
	/**
	 * Counts how many "runs" of the given character appear in the given string.
	 * A "run" is a consecutive block of one or more occurrences of the same character.
	 * For example, if the string is "AATGGGGCCGGTTGGGGGGGGGAAGC" and the character
	 * is "G", returns 4.
	 */
	public static int charRunCount (String str, char c)
	{
		int countcharapp=0;
		for (int i=0; i<str.length(); i++)
		{
			if (str.charAt(i)==c)
			{
				countcharapp++;
				while (i<str.length() && str.charAt(i)==c)
					i++;
			}
		}
		return countcharapp;
	}

	/**
	 * Separates a given string into tokens, which are the "words" that are
	 * separated by one or more occurrences of the given separator character.
	 * Returns the tokens as an array of String values.
	 */
	public static String[] tokenize (String str, char separator) 
	{
		// Removes all the occurrences of the separator at the beginning and end of str
		String source=trim(str, separator);
		// In the following statement, replace the 0 with the correct number of tokens, and complete the missing code.
		int numcell=(charRunCount(source, separator))+1;
		String[] tokens=new String[numcell];
		int j=0;
		int count=0;
		String neword="";
		for (int i=0; i<source.length(); i++)
		{
			j=i;
			while (j<source.length() && source.charAt(j)!=separator)
			{
				neword=neword+source.charAt(j);
				j++;
			}
			tokens[count]=neword;
			if (neword!="") //skips if the pointer on seperator cell
				count++;
			neword="";
			i=j;
		}
		return tokens;
	}
	
	/**
	 * Removes all occurrences of the given character from the given string
	 */
	public static String removeChar(String s, char c) 
	{
		// Replace the following statement with your code
		String news="";
		for (int i=0; i<s.length(); i++)
			if (s.charAt(i)!=c)
				news=news+s.charAt(i);
	    return news;
	}
}