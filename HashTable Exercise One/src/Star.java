import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Star 
{
	public static void main(String args[])
	{
		File myObj = new File("sampleData");
		Scanner myReader;  
		
		HashTable red = new HashTable();
		HashTable yellow = new HashTable();
		HashTable blue = new HashTable();
		red.createHashTable(200);
		yellow.createHashTable(400);
		blue.createHashTable(700);

		try
		{
			myReader = new Scanner(myObj);


			String data = myReader.nextLine();
			red.insertHash(data);

			while (myReader.hasNextLine())
			{
				data = myReader.nextLine();
				red.insertHash(data);
				yellow.insertHash(data);
				blue.insertHash(data);

			}

		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------200 sized hash map------");
		red.printHash();
		System.out.println("There were : " + red.collisions + " collisions");
		
		System.out.println("------400 sized hash map------");
		red.printHash();
		System.out.println("There were : " + yellow.collisions + " collisions");
		
		System.out.println("------700 sized hash map------");
		red.printHash();
		System.out.println("There were : " + blue.collisions + " collisions");

	}

}
