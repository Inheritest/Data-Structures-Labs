
public class HashTable 
{
	String [] hashTable;
	public int collisions  = 0;
	public void createHashTable(int size)
	{
		hashTable = new String [size];
	}
	
	public int getHashValue(String word)
	{
		if(hashTable.length == 200)
		{
			return (int) (((word.charAt(0) - 'a') * Math.pow(26, 2)) + ((word.charAt(1) - 'a') * 26) + ((word.charAt(2) - 'a'))) / 100;
		}
		
		else if(hashTable.length == 400)
		{
			return (int) (((word.charAt(0) - 'a') * Math.pow(26, 2)) + ((word.charAt(1) - 'a') * 26) + ((word.charAt(2) - 'a'))) / 50;
		}
		else if(hashTable.length == 700)
		{
			return (int) (((word.charAt(0) - 'a') * Math.pow(26, 2)) + ((word.charAt(1) - 'a') * 26) + ((word.charAt(2) - 'a'))) / 30;
		}
		return 0;
	}
	
	public void insertHash(String word)
	{
		int hashValue = getHashValue(word);
		boolean indexFound = false;
		
		while(!indexFound)
		{
			if(hashTable[hashValue] != null)
			{
				hashValue++;
				collisions++;
			}
			if(hashValue > hashTable.length)
			{
				System.out.println("Off the edge error");
				indexFound = true;
			}
			else
			{
				hashTable[hashValue] = word;
				indexFound = true;
			}
		}
	}
	
	public void printHash()
	{
		for(int x = 0; x < hashTable.length; x++)
		{
			if(hashTable[x] != null)
			{
				System.out.println(hashTable[x]);
			}
		}
	}

}
