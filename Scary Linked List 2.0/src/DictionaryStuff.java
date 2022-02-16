
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
	public DictionaryStuff(String word, int wordCode)
	{
		this.word = word;
		this.wordCode = wordCode;
	}
	
	public static int wordToCode(String word)
	{
		if (word.length() >= 3)
		{
			int a = word.charAt(0) - 96;
			int b = word.charAt(1) - 96;
			int c = word.charAt(2) - 96;
			return ((a * 676) + (b * 26) + c);
		}
		else if(word.length() == 2)
		{
			int a = word.charAt(0) - 96;
			int b = word.charAt(1) - 96;
			return ((a * 676) + (b * 26));
		}
		else
		{
			int a = word.charAt(0) - 96;
			return (a * 676);
		}
	}
	
	public static String formatWord(String word)
	{
		int length = word.length();
		String newWord = "";
		char temp;
		for(int x = 0; x< length; x++)
		{
			if(word.charAt(x) > 64 && word.charAt(x) < 91)
			{
				temp = (char) (word.charAt(x)+32);
				newWord = newWord + temp;
			}
			else if(word.charAt(x) > 96 && word.charAt(x) < 123)
			{
				newWord = newWord + word.charAt(x);
			}
		}
		
		return newWord;
	}
	
	
}
