import java.io.*;
import java.util.*;

public class fluffyPenguins
{

	public static void main (String args[])
	{

		LinkedList fluffyPenguins = new LinkedList();
		File myObj = new File("puppyFluffies");
		Scanner myReader;  




		try
		{
			myReader = new Scanner(myObj);

			DictionaryStuff quack = new DictionaryStuff();
			String data = myReader.next();
			quack.word = DictionaryStuff.formatWord(data);
			quack.wordCode = DictionaryStuff.wordToCode(DictionaryStuff.formatWord(data));
			fluffyPenguins.makeNode(quack);
			
			while (myReader.hasNextLine()) 
			{
				data = myReader.next();
				quack.word = DictionaryStuff.formatWord(data);
				quack.wordCode = DictionaryStuff.wordToCode(DictionaryStuff.formatWord(data));
				fluffyPenguins.organizeInput(quack);
			}
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}

		Operator.controller(fluffyPenguins);


	}

}

