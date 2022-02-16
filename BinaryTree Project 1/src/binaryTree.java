import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class binaryTree 
{
	public static treeNode root;
	public static int comparisons;
	public void init()
	{
		root = null;
	}

	public treeNode makeTreeNode(int data)
	{
		treeNode newNode = new treeNode();
		newNode.data = data;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}

	public void setLeft(treeNode node, int data)
	{
		if(node.left != null)
		{
			System.out.println();
			System.out.println("Error: node already has data");
			System.out.println();
		}
		else
		{
			node.left = makeTreeNode(data);
		}
	}

	public void setRight(treeNode node, int data)
	{
		if(node.right != null)
		{
			System.out.println();
			System.out.println("Error: node already has data");
			System.out.println();
		}
		else
		{
			node.right = makeTreeNode(data);
		}
	}

	public void BuildBinaryTree(File myFile)
	{
		
		try
		{
			Scanner myReader = new Scanner(myFile);
			String data = myReader.nextLine();
			treeNode current;
			int numData;
			
			while (myReader.hasNextLine()) 
			{
				
				comparisons++;
				numData = Integer.parseInt(data);
				if(root == null)
				{
					root = makeTreeNode(numData);

				}
				else
				{
					boolean found = false;
					current = root;
					current.data = 1;
					while(!found)
					{
						if(numData > current.data)
						{
							comparisons ++;
							if(current.right != null)
							{
								current = current.right;
							}
							else
							{
								found = true;
							}

						}
						else
						{
							comparisons ++;
							if(current.left != null)
							{
								current = current.left;
							}
							else
							{
								found = true;
							}
						}

					}
					if(found)
					{
						if(numData > current.data)
						{
							comparisons++;
							setRight(current, numData);
						}
						else
						{
							comparisons++;
							setLeft(current, numData);
						}

					}



					data = myReader.nextLine();
				}

			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();		
		}


		}
	public static void inOrder(treeNode node)
	{
		if(node.left != null)
		{
			inOrder(node.left);
		}
		
		System.out.println(node.data);
		
		if(node.right != null)
		{
			inOrder(node.right);
		}
	}

}
