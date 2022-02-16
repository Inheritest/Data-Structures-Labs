
public class LinkedList 
{
	static Node start;
	static Node[] index = new Node[26];
	
	public void init()
	{
		LinkedList list = new LinkedList();
		start = list.makeNode(null);
	}
	
	public Node makeNode(DictionaryStuff data)
	{
		Node newNode = new Node();
		DictionaryStuff guineaPig = new DictionaryStuff();
		guineaPig.word = data.word;
		guineaPig.wordCode = data.wordCode;
		
		newNode.data = guineaPig;
		newNode.next = null;
		
		if(start == null)
		{
			start = newNode;
		}
		
		return newNode;
	}
	public Node makeNode(DictionaryStuff data, Node next)
	{
		Node newNode = new Node();
		DictionaryStuff guineaPig = new DictionaryStuff();
		guineaPig.word = data.word;
		guineaPig.wordCode = data.wordCode;
		
		newNode.data = guineaPig;
		newNode.next = next;
		
		return newNode;
	}
	
	public void showList()
	{
		Node current = start;
		while(current.next != null)
		{
			System.out.println(current.data.word);
			current = current.next;
		}
		System.out.println(current.data.word);
	}
	
	public void createIndex()
	{
		Node current = start;
		int woo = 0;
		while(woo != 26)
		{
			current = start;
			while(current.next != null)
			{
				if(current.data.word.charAt(0) - 97 == woo)
				{
					index[woo] = current;
					woo++;
				}
				current = current.next;
			}
			if(current.data.word.charAt(0) - 97 == woo)
			{
				index[woo] = current;
			}
			
			woo ++;
		}
	}
	
	
	public void showListAtLetter(char letter)
	{
		if(index[0] == null)
		{
			createIndex();
		}
		int value = 0;
		if(letter > 64 && letter < 91)
		{
			value = letter - 65;
		}
		else
		{
			value = letter - 97;
		}
	    
		Node current = index[value];
		
		if(current != null && current.next != null)
		{
			while(current.next.data.word.charAt(0) -97 == value)
			{
				System.out.println(current.data.word);
				current = current.next;
			
			}
			System.out.println(current.data.word);
		}
		else if(current != null)
		{
			System.out.println(current.data.word);
		}
		else
		{
			System.out.println("There's no word that starts with that letter in this dictionary.");
		}
		
	}
	
	public Node findTail()
	{
		Node current = start;
		while (current.next != null)
		{
			current = current.next;
		}
		return current;
	}
	
	public void insertAfter(DictionaryStuff data, DictionaryStuff after)
	{
		Node current = start;
		while (current.data.wordCode != after.wordCode)
		{
			current = current.next;
		}
		current.next = makeNode(data, current.next);
		
	}
	
	public void insertAtFront(DictionaryStuff data)
	{
		
		Node newNode = makeNode(data, start);
		start = newNode;
		
	}
	
	public Node insertAtBack(DictionaryStuff data)
	{
		LinkedList list = new LinkedList();
		Node tail = list.findTail();
		tail.next = makeNode(data);
		return tail;
	}
	
	public void delete(DictionaryStuff data)
	{
		Node current = start;
		while (!data.word.equals(current.next.data.word))
		{
			current = current.next;
		}
		current.next = current.next.next;
	}
	
	public boolean isDuplicate(DictionaryStuff data)
	{
		Node current = start;
		while (current.next != null)
		{
			if(current.data.word.equals(data.word))
			{
				return true;
			}
			current = current.next;
		}
		if(current.data.word.equals(data.word))
		{
			return true;
		}
		return false;
	}
	
	public void organizeInput(DictionaryStuff data)
	{
		LinkedList List = new LinkedList();
		if(List.isDuplicate(data)) //Check for duplicates
		{
			//Do nothing
		}
		else if(data.wordCode < List.start.data.wordCode) //if it is the first alphabetically
		{
			//make it the new front
			List.insertAtFront(data);
		}
		else if(List.start.next == null) //if there is only a start
		{
			//make a new node and make start.next = it
			List.start.next = List.makeNode(data);
		}
		else if(data.wordCode < List.findTail().data.wordCode) //if it is less than the end of the list)
		{
			//find the node it is greater than and make it that node's next
			Node leah = new Node();
			leah.data = List.start.data;
			leah.next = List.start.next;
			boolean first = false;
			
			while(leah.next != null)
			{
				if(leah.next.data.wordCode > data.wordCode && !first)
				{
					List.insertAfter(data, leah.data);
					first = true;
				}
				leah = leah.next;
			}
			
		}
		else
		{
			//and at the end of the list
			List.insertAtBack(data);
			
		}
	}
	
	public int CountWhole()
	{
		Node current = start;
		int count = 0;
		while(current.next != null)
		{
			count ++;
			current = current.next;
		}
		count ++;
		return count;
	}
	
	public int CountPart(char letter)
	{
		int count = 0;
		if(index[0] == null)
		{
			createIndex();
		}
		int value = 0;
		if(letter > 64 && letter < 91)
		{
			value = letter - 65;
		}
		else
		{
			value = letter - 97;
		}
	    
		Node current = index[value];
		
		if(current != null && current.next != null)
		{
			while(current.next.data.word.charAt(0) -97 == value)
			{
				count ++;
				current = current.next;
			
			}
			count ++;
		}
		else if(current != null)
		{
			count ++;
		}
		
		return count;
	}
}
