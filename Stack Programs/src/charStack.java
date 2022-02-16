class charStack 
{
	int top;
	char[] stack = new char[20];
	
	public void init()
	{
		top = -1;
	}
	public void push (char item)
	{
		top++;
		stack[top] = item;
	}
	
	public char pop()
	{
		char x;
		x = stack[top];
		top--;
		return x;
	}
	
	public boolean isEmpty()
	{
		boolean empty;
		
		empty = false;
		if(top == -1)
		{
			empty = true;
		}
		return empty;
	}
	
	public int getTop()
	{
		return top;
	}
	
	public void showStack()
	{
		int x = top;
		while (x >= 0)
		{
			System.out.print(stack[x] + "");
			x--;
		}
	}
	
	public String toString()
	{
		String str = "";
		for(int x = 0; x < 20; x ++)
		{
			if(stack[x] > 32 && stack[x] < 127)
				str = (str + stack[x]);
		}
		return str;
	}
}
