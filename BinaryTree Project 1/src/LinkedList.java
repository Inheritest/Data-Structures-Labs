import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedList 
{
	static Node start = new Node();
	static int length = 0;
	static int comparisons;
	public void init()
	{
		LinkedList list = new LinkedList();
		start = list.makeNode(0, null);
	}
	
	public Node makeNode(int data)
	{
		Node newNode = new Node();
		
		newNode.inum = data;
		newNode.next = null;
		length++;
		return newNode;
	}
	public Node makeNode(int data, Node next)
	{
		Node newNode = new Node();
		
		newNode.inum = data;
		newNode.next = next;
		length++;
		return newNode;
	}
	
	public void buildList(File myFile)
	{
		LinkedList list = new LinkedList();
		Node node = new Node();
		list.init();
		node = start;
		int data;
		
		try
		{
			Scanner myReader = new Scanner(myFile);
			while(myReader.hasNextLine())
			{
				data = Integer.parseInt(myReader.nextLine());
				node.next = makeNode(data);
				node = node.next;
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	public void showList()
	{
		Node current = start;
		while(current.next != null)
		{
			System.out.println(current.inum);
			current = current.next;
		}
		System.out.println(current.inum);
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
	
	public void insertAfter(int data, int after)
	{
		Node current = start;
		while (current.inum != after)
		{
			current = current.next;
		}
		current.next = makeNode(data, current.next);
		
	}
	
	public void insertAtFront(int data)
	{
		Node newNode = makeNode(data, start);
		start = newNode;
	}
	
	public void insertAtBack(int data)
	{
		LinkedList list = new LinkedList();
		Node tail = list.findTail();
		tail.next = makeNode(data);
	}
	
	public void delete(int data)
	{
		Node current = start;
		while (current.next.inum != data)
		{
			current = current.next;
		}
		current.next = current.next.next;
		length --;
	}
	
	public void bumpUp(Node node)
	{
		int temp = node.inum;
		node.inum = node.next.inum;
		node.next.inum = temp;		
	}
	
	public void bubbleSort()
	{
		int temp = length;
		Node current = start;
		
		while(temp >= 0)
		{
			current = start;
			for(int x = 0; x < temp - 1; x++)
			{
				if(current.inum > current.next.inum)
				{
					bumpUp(current);
				}
				comparisons ++;
				current = current.next;
			}
			temp--;
		}
		
	}
	
}
