import java.io.*;
import java.util.Scanner;
public class Operator 
{
	public static void main(String[] args) 
	{
		String temp = " ";
		
		    try {
		      File myObj = new File("bluff.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        
		        if(data.charAt(0) == 'q')
		        {
		        	System.out.println(verification(data));	
		        }
		        if(data.charAt(0) == 'g')
		        {
		        	System.out.println(postfix(data));
		        }
		        if(data.charAt(0) == 'j')
		        {
		        	System.out.println(converter(data));
		        }
		        if(data.charAt(0) == 'h')
		        {
		        	if(verification(data) == true)
		        	{
		        		temp = converter(data);
		        		System.out.println(temp);
		        		System.out.println(postfix(temp));
		        	}
		        	else
		        	{
		        		System.out.println("This is not a valid equation.");
		        	}
		        }
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
		
	}
	
	public static boolean verification(String input)
	{
		int open = 0;
		int close = 0;
		for(int x = 0; x < input.length(); x++)
		{
			if(input.charAt(x) == '(' || input.charAt(x) == '{' || input.charAt(x) == '[')
			{
				open++;
			}
			if(input.charAt(x) == ')' || input.charAt(x) == '}' || input.charAt(x) == ']')
			{
				close++;
			}
		}
		
		if(open == close)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static int postfix(String input)
	{
		intStack stack = new intStack();
		stack.init();
		int temp1;
		int temp2;
		int temp3;
		for(int x = 0; x < input.length(); x++)
		{
			if(input.charAt(x) == ' ' || input.charAt(x) == 'g' || input.charAt(x) == 'h')
			{
				
			}
			else if(input.charAt(x) == '+')
			{
				temp1 = stack.pop();
				temp2 = stack.pop();
				temp3 = (temp1 + temp2);
				stack.push(temp3);
			} 
			else if(input.charAt(x) == '-')
			{
				temp1 = stack.pop();
				temp2 = stack.pop();
				stack.push(temp1 - temp2);
			}
			else if(input.charAt(x) == '/')
			{
				temp1 = stack.pop();
				temp2 = stack.pop();
				stack.push(temp2 / temp1);
			}
			else if(input.charAt(x) == '*')
			{
				temp1 = stack.pop();
				temp2 = stack.pop();
				stack.push(temp1 * temp2);
			}
			else
			{
				stack.push(Character.getNumericValue(input.charAt(x)));
			}
		}
		return stack.pop();
	}
	
	public static String converter(String input)
	{
		int open = 0;
		int close = 0;
		char temp = 'a';
		charStack stack = new charStack();
		stack.init();
		for(int x = 0; x < input.length(); x++)
		{
			if(input.charAt(x) == ' ' || input.charAt(x) == 'j' || input.charAt(x) == 'h')
			{
				
			}
			else if(input.charAt(x) == '(' || input.charAt(x) == '{' || input.charAt(x) == '[')
			{
				open++;
			}
			else if(input.charAt(x) == ')' || input.charAt(x) == '}' || input.charAt(x) == ']')
			{
				close++;
				stack.push(temp);
			}
			
			else if(input.charAt(x) != '+' && input.charAt(x) != '-' && input.charAt(x) != '*' && input.charAt(x) != '/')
			{
					stack.push(input.charAt(x));
			}
			
			else if(input.charAt(x) == '+' || input.charAt(x) == '-' ||input.charAt(x) == '*' ||input.charAt(x) == '/')
			{
				temp = input.charAt(x);
			}
		}
		for(int x = input.length() - 1; x > 0; x--)
		{
			if(input.charAt(x) == ' ')
			{
				
			}
			else if(input.charAt(x) == '(' || input.charAt(x) == '{' || input.charAt(x) == '[')
			{
				open++;
			}
			else if(input.charAt(x) == ')' || input.charAt(x) == '}' || input.charAt(x) == ']')
			{
				close++;
			}
			else if(open == close)
			{
				if(input.charAt(x) == '+' || input.charAt(x) == '-' ||input.charAt(x) == '*' ||input.charAt(x) == '/')
				{
					stack.push(input.charAt(x));
				}
			}
		}
		return stack.toString();
	}

}
