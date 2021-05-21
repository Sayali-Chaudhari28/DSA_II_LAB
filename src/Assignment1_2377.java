/*******************************************************************************************************
 											Assignment 1
 Title: Create a binary tree and perform inorder, preorder and postorder traversals.

 Implemented: 1. Recursive inorder traversal
 			  2. Recursive postorder traversal
 			  3. Non-recursive postorder  traversal
 .......................................................................................................
 
 Name	: Sayali Narendra Chaudhari
 roll no: 2377
 c no.	: C22020222303
 Div 	: A
 Batch 	: A3
 Github link: https://github.com/Sayalinc28/Binary_Tree_Assignmnet_1.git
********************************************************************************************************/
import java.util.Scanner;

class Node{
	int data;
	Node left, right;
	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class binary_tree{
	Scanner input= new Scanner(System.in);
	private Node root;
	public binary_tree() {
		root=null;
	}
	//---------------------------------create binary tree---------------------------------
	Node create_binary_tree() {
		String choose;
		int data1;
		Node ptr;
		Node root=null;
		int dir;
		do{
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print("Enter the data to insert in the tree: ");
			data1 = input.nextInt();
			Node newNode = new Node(data1);
			//-----------------------Insert root node------------------------
			if(root == null){
				root = newNode;
				System.out.println("Root Node inserted");
				System.out.println("----------------------------------------------");
			}
			else
			{
				ptr=root;
				System.out.println("Choose the direction to connect node: \n 1. Left \n 2. Right");
				dir = input.nextInt();
				switch(dir){
				//---------------------Insert to left-----------------
				case 1: if(ptr.left==null){											
							System.out.println("Current node is: "+ptr.data);
							ptr.left=newNode;
							System.out.println("left Node inserted");
						}
						else{
							//Traverse left to reach leaf node
							while(ptr.left !=null) {								
								ptr = ptr.left;
							}
							System.out.println("Current node is: "+ptr.data);
							//check both left and right child are null
							if(ptr.left== null && ptr.right==null) {				
								
								System.out.println("Choose the direction to connect node: \n 1. Left \n 2. Right");
								dir = input.nextInt();
								switch(dir) {
									//insert to left of left
									case 1: ptr.left = newNode;						
											System.out.println("Left child inserted to left of left");
									break;
									//insert to left of right
									case 2: if(ptr.right==null) {						
											ptr.right = newNode;
											System.out.println("right child inserted to left of right");
										}
										else 
											System.out.println("Already node exits! ");
									break;
								}
							}
						}
				break;
				//---------------------Insert to right-----------------		
				case 2: if(ptr.right == null) {									//Insert to right
							System.out.println("Current node is: "+ptr.data);
							ptr.right=newNode;
							System.out.println("Right Node inserted!!");
						}	
						else {
							//Traverse right to reach leaf node
							while(ptr.right!=null) {							
								ptr = ptr.right;
							}
							//check if both child are null
							if(ptr.right == null && ptr.left==null) {			
								System.out.println("Choose the direction to connect node: \n 1. Left \n 2. Right");
								dir = input.nextInt();
								System.out.println("----------------------------------------------");
								switch(dir) {
								//Insert to right of left
								case 1: ptr.left = newNode;		
										System.out.println("left node inserted to the left of right" );
									break;
								//Insert to right of right
								case 2: if(ptr.right == null) {
									ptr.right = newNode;
									System.out.println("Right node inserted to the right of right");
								}
								else
									System.out.println("Right node already exist!");
									break;
								}
							}
						}
				break;
				
				default:System.out.println("Enter Valid Direction");
				}
			}
			
			System.out.println("Do you want to insert new node(Y/N)");
			choose = input.next();
		}while(choose.equalsIgnoreCase("y"));
		return root;
	}
	
	//----------------------------in-order recursive traversal-------------------
	void inorder_recursive(Node tree) {
		if(tree!=null){
			inorder_recursive(tree.left);
			System.out.print(tree.data+", ");
			inorder_recursive(tree.right);
		}
	}
	//-----------------------------post-order recursive traversal------------------
	void postorder_recursive(Node tree) {
		if(tree!=null){
			inorder_recursive(tree.left);
			inorder_recursive(tree.right);
			System.out.print(tree.data+", ");
		}
	}
	//------------------------Non-recursive in-order traversal----------------------
	public void non_recursive_inorder_Traversal(Node tree){
		Stack s=new Stack();
		Node ptr=tree;
		while(ptr!=null){
			s.push(ptr);
			ptr=ptr.left;
		}
		while(!s.isStackEmpty()){
			if(!s.isStackEmpty()){
				ptr=s.pop();
				System.out.print(ptr.data+",");
				ptr=ptr.right;
			}
			while(ptr!=null){
				s.push(ptr);
				ptr=ptr.left;
			}
		}
	}
}

//Stack 1
class Stack{
	Node arr[] = new Node[100];
	int top;
	public Stack(){
		top=-1;
	}
	public boolean isStackEmpty(){
		if(top==-1){
			return true;
		}
		return false;
	}
	public boolean isStackFull(){
		if(top==99){
			return true;
		}
		return false;
	}
	public void push(Node value){
		if(!isStackFull()){
			arr[++top]=value;
			}
		}
	public Node pop(){
		if(!isStackEmpty()){
			return arr[top--];
		}
		return null;
	}

}
//stack 2
class StackF{ 
	char arr[] = new char[100];
	int top;
	public StackF(){
		top=-1;
	}
	public boolean isStackFEmpty(){
		if(top==-1){
			return true;
		}
		return false;
	}
	public boolean isStackFFull(){
		if(top==99){
			return true;
		}
		return false;
	}
	public void push(char value){
		if(!isStackFFull()){
			arr[++top]=value;
		}
	}
	public char pop(){ 
		if(!isStackFEmpty()){
			return arr[top--];
		}
		return'~';
	}
}
//-----------------------------------------MAIN-----------------------------
public class Assignment1_2377 {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	Node root;
	binary_tree bt = new binary_tree();
	int choice;
	root = bt.create_binary_tree();					//binary tree creation call
	do {
		System.out.println("\n\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("\t\t\tMenu");
		System.out.print("\n1. Recursive INORDER Traversal "
				+ "\n2. Recursive POSTORDER Traversal "
				+ "\n3. Non-Recursive POSTORDER Traversal"
				+ "\n4. Exit"
				+ "\nChoose your action: ");
		choice = sc.nextInt();
		System.out.print("_________________________________________________\n\n");
		switch(choice) {
		//recursive inorder
		case 1: System.out.println("Recursive inorder teaversal: ");		
				bt.inorder_recursive(root);
			break;
		//recursive postorder
		case 2: System.out.println("Recursive postorder traversal: ");
				bt.postorder_recursive(root);
			break;
		//non-recursive inorder
		case 3: System.out.println("Non-recursive inorder traveral: ");
				bt.non_recursive_inorder_Traversal(root);
			break;
		//exit
		case 4: System.exit(0);
			break;
		}
	}while(choice != 5);
}
}

/***********************************************OUTPUT*****************************************************

 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~						TREE STRUCTURE
Enter the data to insert in the tree: 12										   12
Root Node inserted																   /\
----------------------------------------------									 66  77	
Do you want to insert new node(Y/N)												 /   /
y																				43  55
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~							 \
Enter the data to insert in the tree: 66										 87
Choose the direction to connect node: 
 1. Left 
 2. Right
1
Current node is: 12
left Node inserted
Do you want to insert new node(Y/N)
y
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Enter the data to insert in the tree: 77
Choose the direction to connect node: 
 1. Left 
 2. Right
2
Current node is: 12
Right Node inserted!!
Do you want to insert new node(Y/N)
y
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Enter the data to insert in the tree: 43
Choose the direction to connect node: 
 1. Left 
 2. Right
1
Current node is: 66
Choose the direction to connect node: 
 1. Left 
 2. Right
1
Left child inserted to left of left
Do you want to insert new node(Y/N)
y
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Enter the data to insert in the tree: 55
Choose the direction to connect node: 
 1. Left 
 2. Right
2
Choose the direction to connect node: 
 1. Left 
 2. Right
1
----------------------------------------------
left node inserted to the left of right
Do you want to insert new node(Y/N)
y
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Enter the data to insert in the tree: 87
Choose the direction to connect node: 
 1. Left 
 2. Right
1
Current node is: 43
Choose the direction to connect node: 
 1. Left 
 2. Right
2
right child inserted to left of right
Do you want to insert new node(Y/N)
n


^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
						Menu

1. Recursive INORDER Traversal 
2. Recursive POSTORDER Traversal 
3. Non-Recursive POSTORDER Traversal
4. Exit
Choose your action: 1
_________________________________________________

Recursive inorder teaversal: 
43, 87, 66, 12, 55, 77, 

^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
						Menu

1. Recursive INORDER Traversal 
2. Recursive POSTORDER Traversal 
3. Non-Recursive POSTORDER Traversal
4. Exit
Choose your action: 2
_________________________________________________

Recursive postorder traversal: 
43, 87, 66, 55, 77, 12, 

^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
						Menu

1. Recursive INORDER Traversal 
2. Recursive POSTORDER Traversal 
3. Non-Recursive POSTORDER Traversal
4. Exit
Choose your action: 3
_________________________________________________

Non-recursive inorder traveral: 
43,87,66,12,55,77,

^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
						Menu

1. Recursive INORDER Traversal 
2. Recursive POSTORDER Traversal 
3. Non-Recursive POSTORDER Traversal
4. Exit
Choose your action: 4					

**********************************************************************************************************/
