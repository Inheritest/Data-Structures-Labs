
public class DictionaryStuff 
{
	String word;
	int wordCode;
	String meaning;
	
	public DictionaryStuff()
	{
		
	}
	public DictionaryStuff(String word, int wordCode, String meaning)
	{
		this.word = word;
		this.wordCode = wordCode;
		this.meaning = meaning;
	}
	
	public static int wordToCode(String word)
	{
		int a = word.charAt(0) - 96;
		int b = word.charAt(1) - 96;
		int c = word.charAt(2) - 96; 
		return ((a * 676) + (b * 26) + c);
		
	}
}
