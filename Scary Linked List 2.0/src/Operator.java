import java.io.*;
import java.util.*;

public class Operator 
{
	public static void controller(LinkedList list)
	{
		Scanner input = new Scanner(System.in);
		boolean running = true;
		int response;
		
		while(running)
		{
			System.out.println("What would you like to do? ");
			System.out.println("1. Show all words");
			System.out.println("2. Count words");
			System.out.println("3. Add a word");
			System.out.println("4. Delete a word");
			System.out.println("5. Show all words that start with a specific letter");
			System.out.println("6. End Program");
			System.out.print("Your response: ");
			response = input.nextInt();
			
			
			
			if(response == 1)
			{
				//Show all words
				list.showList();
			}
			
			else if(response == 2)
			{
				//Count words
				System.out.println("Would you like to count the whole list or just part of the list?");
				System.out.println("1. Whole list.");
				System.out.println("2. Part of the list");
				System.out.print("Your response: ");
				response = input.nextInt();
				
				if(response == 1)
				{
					//Count the whole list
					System.out.println("The whole list has " + list.CountWhole() + " many words in it");
				}
				else if(response == 2)
				{
					//Count part of the list
					System.out.println("Please type the first letter of the section of the list that you would like to count");
					System.out.print("Your response: ");
					String word = input.next();
					char letter = word.charAt(0);
					System.out.println("That part of the list has " + list.CountPart(letter) + " many words in it");
				}
			}
			
			else if(response == 3)
			{
				//Add a word
				System.out.println("What word would you like to add?");
				System.out.print("Your response: ");
				DictionaryStuff data = new DictionaryStuff();
				data.word = DictionaryStuff.formatWord(input.next());
				data.wordCode = DictionaryStuff.wordToCode(data.word);
				System.out.println("What does this word mean?");
				System.out.print("Your response: ");
				data.meaning = input.nextLine();
				list.organizeInput(data);
				System.out.println("Your word has been added");
			}
			
			else if(response == 4)
			{
				//Delete a word
				System.out.println("What word would you like to delete?");
				System.out.print("Your response: ");
				DictionaryStuff data = new DictionaryStuff();
				data.word = DictionaryStuff.formatWord(input.next());
				data.wordCode = DictionaryStuff.wordToCode(data.word);
				list.delete(data);
				System.out.println("That word has been removed from the list");
				
				
			}
			
			else if(response == 5)
			{
				//Show all words that start with a specific letter
				char letter;
				System.out.println("What letter would you like to see?");
				System.out.print("Your response: ");
				letter = input.next().charAt(0);
				list.showListAtLetter(letter);
			}
			
			else if(response == 6)
			{
				//End program
				running = false;
			}
		}
		
	}

}
