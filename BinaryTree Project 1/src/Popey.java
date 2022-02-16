import java.io.File;

public class Popey 
{
	public static void main (String args[])
	{
		
		File file = new File("numbers.txt");
		binaryTree Tree = new binaryTree();
		Tree.BuildBinaryTree(file);
		binaryTree.inOrder(Tree.root);
		System.out.println("Number of comparisons for Binary Tree: " + Tree.comparisons);
		LinkedList list = new LinkedList();
		list.buildList(file);
		list.bubbleSort();
		list.showList();
		System.out.println("Number of comparisons for Bubble Sorted list: " + list.comparisons);
		
		
		
	}
}

