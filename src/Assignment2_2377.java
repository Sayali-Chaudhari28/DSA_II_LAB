import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class tree{
	int data;
	tree left, right;
	public tree(int data) {
		this.data = data;
		left = right = null;
	}
}
class Binary_Search_Tree{
	Scanner sc = new Scanner(System.in);
	private tree root;
	String choice;
	public Binary_Search_Tree() {
		root = null;
	}
	tree create_bst() {
		int d;
		do {
			System.out.print("Enter data to be inserted in the tree: ");
			d = sc.nextInt();
			tree newtree = new tree(d);
			tree ptr = root;
			if(ptr == null) {
				root = newtree;
				System.out.println("Root node inserted");
			}
			else {
				ptr = root;
				while(ptr!=null) {
					if(ptr.data > d) {
						if(ptr.left == null) {
							ptr.left = newtree;
							System.out.println("Left child inserted "+newtree.data);
							break;
						}
						else {
							ptr = ptr.left;
						}
					}
					if(ptr.data < d) {
						if(ptr.right == null) {
							ptr.right = newtree;
							System.out.println("Right child inserted "+newtree.data);
							break;
						}
						else {
							ptr = ptr.right;
						}
					}
					
				}
			}
			System.out.print("Do you want to continue? (y/n): ");
			choice = sc.next();
		}while(!choice.equalsIgnoreCase("n"));
		return root;
	}
	//-------------------FIND MINIMUM NODE IN TREE------------------------
	void minimum() {
		tree ptr = root;
		if(root == null)
			System.out.println("Tree is Empty!");
		else {
			while(ptr.left!=null) {
				ptr = ptr.left;
			}
			System.out.println("Minimum is : "+ptr.data);
		}
	}
	//-------------------FIND MAXIMUM NODE IN TREE------------------------
	void maximum() {
		tree ptr = root;
		if(root == null)
			System.out.println("Tree is Empty!");
		else {
			while(ptr.right!=null) {
				ptr = ptr.right;
			}
			System.out.println("Maximum is : "+ptr.data);
		}
	}
	//------------------------Display Tree level wise----------------------
	void display_level() {
		Queue<tree> queue = new LinkedList<>();
		tree ptr = root;
		if(root==null)
			System.out.println("Tree is empty");
		else {
			while(ptr != null) {
				System.out.print(ptr.data+" ");
				if(ptr.left != null)
					queue.add(ptr.left);
				if(ptr.right != null)
					queue.add(ptr.right);
				if (queue.isEmpty())
	                ptr = null; 
	            else
	                ptr = queue.remove();
			}
		}
		
	}
	void inorder_recursive(tree n) {
		if(n!=null){
			inorder_recursive(n.left);
			System.out.print(n.data+", ");
			inorder_recursive(n.right);
		}
	}
	
}
public class Assignment2_2377 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Binary_Search_Tree bst = new Binary_Search_Tree();
		int choice;
		do {
			System.out.print("1. create binary search tree "
					+ "\n2. Find minimum node "
					+ "\n3. Find Maximum node "
					+ "\n4. Display tree Levelwise"
					+ "\n5. Display tree in descinding order"
					+ "\n6. Exit"
					+ "\nEnter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: bst.create_bst();
				break;
			case 2: bst.minimum();
				break;
			case 3: bst.maximum();
				break;
			case 4:bst.display_level();
				break;
			case 5: 
				break;
			case 6: System.exit(0);
				break;
			}
		}while(choice != 5);
	}
	
}
