
public class LinkedList 
{
	static Node start;
	
	public void init()
	{
		LinkedList list = new LinkedList();
		start = list.makeNode(null);
	}
	
	public Node makeNode(DictionaryStuff data)
	{
		Node newNode = new Node();
		
		newNode.data = data;
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
		
		newNode.data = data;
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
	
	public Node findTail()
	{
		Node current = start;
		while (current.next != null)
		{
			current = current.next;
		}
		return current;
	}
	
	public void insertAfter(DictionaryStuff data, int after)
	{
		Node current = start;
		while (current.data.wordCode != after)
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
	
	public void insertAtBack(DictionaryStuff data)
	{
		LinkedList list = new LinkedList();
		Node tail = list.findTail();
		tail.next = makeNode(data);
	}
	
	public void delete(DictionaryStuff data)
	{
		Node current = start;
		while (current.next.data != data)
		{
			current = current.next;
		}
		current.next = current.next.next;
	}
}
