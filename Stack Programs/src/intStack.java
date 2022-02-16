class intStack 
{
	int top;
	int[] stack = new int[20];
	
	public void init()
	{
		top = -1;
	}
	public void push (int item)
	{
		top++;
		stack[top] = item;
	}
	
	public int pop()
	{
		int x;
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
			System.out.print(stack[x] + " ");
			x--;
		}
	}
	

}
