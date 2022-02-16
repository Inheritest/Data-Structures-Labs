
public class Formatter 
{
	public int lineWidth;
	
	public void setLineWidth(int lineWidth)
	{
		this.lineWidth = lineWidth;
	}
	
	public String center(String word)
	{
		int spaceLen = (lineWidth - word.length())/2;
		String newString = "";
		for(int x = 0; x < spaceLen; x++)
		{
			newString = newString + " ";
		}
		newString = newString + word;
		for(int x = 0; x < spaceLen; x++)
		{
			newString = newString + " ";
		}
		if(word.length() % 2 == 1 && lineWidth % 2 != 1)
		{
			newString = newString + " ";
		}
		return(newString);
	}

}