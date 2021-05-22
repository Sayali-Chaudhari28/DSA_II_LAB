/*******************************************************************************************************
 											Assignment 2
 Title: Write a program to create a BST and perform following operations 
		1. Find minimum or  maximum node in a tree
		2. Display tree level wise
		3. Display tree in descending order 
		4. Count no. of leaf nodes recursive
		5. (Extra operations: height, parent)
 .......................................................................................................
 
 Name	: Sayali Narendra Chaudhari
 roll no: 2377
 c no.	: C22020222303
 Div 	: A
 Batch 	: A3
 Github link: https://github.com/Sayalinc28/DSA_II_LAB/blob/master/src/Assignment2_2377.java
********************************************************************************************************/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//create node of tree
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
	tree root;
	String choice;
	public Binary_Search_Tree() {
		root = null;
	}
	//------------------------binary search tree creation--------------------
	tree create_bst() {
		int d;
		do {
			System.out.print("Enter data to be inserted in the tree: ");
			d = sc.nextInt();
			tree newtree = new tree(d);
			tree ptr = root;
			//insert root
			if(ptr == null) {
				root = newtree;
				System.out.println("Root node inserted");
			}
			else {
				ptr = root;
				while(ptr!=null) {
					if(ptr.data > d) {
						//insert left child
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
						//insert right child
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
			System.out.println("------------------------------------------------");
			System.out.print("Do you want to continue? (y/n): ");
			choice = sc.next();
		}while(!choice.equalsIgnoreCase("n"));
		return root;
	}
	//-------------------FIND MINIMUM NODE IN TREE------------------------
	void minimum() {
		tree ptr = root;
		//check tree exist or not
		if(root == null)
			System.out.println("Tree is Empty!");
		else {
			//traverse through left to find maximum node
			while(ptr.left!=null) {
				ptr = ptr.left;
			}
			System.out.println("Minimum is : "+ptr.data);
		}
	}
	//-------------------FIND MAXIMUM NODE IN TREE------------------------
	void maximum() {
		tree ptr = root;
		//check tree exist or not
		if(root == null)
			System.out.println("Tree is Empty!");
		else {
			//traverse through left to find maximum node
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
		//Check tree exist or not
		if(root==null)
			System.out.println("Tree is empty");
		else {
			//Traverse till last child
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
	//-------------------Display tree in descending order--------------
	void descending(tree r) {
		if(r!=null){
			descending(r.right);
			System.out.print(r.data+" ");
			descending(r.left);
		}
	}
	//------------------count number of nodes recursively--------------
	int cnt=0;
	 int count_leaf_nodes(tree localRoot){          
		 if(localRoot!=null){
	            count_leaf_nodes(localRoot.left);       
	            if(localRoot.left==null && localRoot.right==null){
	                cnt++;                              
	            }
	            count_leaf_nodes(localRoot.right);      
	        }
		 return cnt;
	    }
	//------------------------find height of tree----------------------
	int height(tree temproot) {
		int lh, rh;
        if(temproot.left==null){
            lh=0;
        }
        else{
            lh=1+height(temproot.left);
        }
      
        if(temproot.right==null){
            rh=0;
        }
        else{
            rh=1+height(temproot.right);
        }
        
        if(lh>rh)
            return lh;
        else
            return rh;
	}
	//----------------------Parent node------------------------------
	void parent_node() {
		int value;
        tree parent=null;
        tree temp=root;
        Scanner scan =new Scanner(System.in);
        System.out.println("\nEnter child node whose parent is to be found:");//Accept a key whose parent is to be found
        value=scan.nextInt();
        if(value==root.data){       										//if user enters root itself
            System.out.println("\nNo parent as it is itself a parent of all elements");
        }
        else{
            while(temp.data!=value && temp!=null){      					//Traverse till leaf node
                if(value>temp.data){
                    parent=temp;
                    temp=temp.right;       									 //Traverse ptr to right child
                }
                else{
                    parent=temp;            								//when value is less than data in temp
                    temp=temp.left;         								//Traverse ptr to left child
                }
            }
            if(temp.data==value){       									//given node is found
                System.out.println("Parent of node"+ value +": "+ parent.data);      //display parent node
            }
            else{
                System.out.println("Parent not found");           			//When temp==null
            }
        }
	}
}
public class Assignment2_2377 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Binary_Search_Tree bst = new Binary_Search_Tree();
		int choice;
		
		do {
			System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><>");
			System.out.println("\tBINARY SEARCH TREE OPERATIONS\n");
			System.out.print("1. create binary search tree "
					+ "\n2. Find minimum node "
					+ "\n3. Find Maximum node "
					+ "\n4. Display tree Levelwise"
					+ "\n5. Display tree in descending order"
					+ "\n6. Count number of leaf nodes "
					+ "\n7. Find height of the tree "
					+ "\n8. Parent node"
					+ "\n9. Exit"
					+ "\n<><><><><><><><><><><><><><><><><><><><><><><><>"
					+ "\nEnter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
			
			case 1: bst.create_bst();						//call creation of bst
				break;
				
			case 2: bst.minimum();							//call minimum
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
				
			case 3: bst.maximum();							//call maximum
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
				
			case 4: bst.display_level();					//call display_level
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
				
			case 5:if(bst.root == null)						//call descending 
						System.out.println("Tree is Empty");
					else {
						System.out.println("Binary search tree in descending order is\n");
						bst.descending(bst.root);
					}
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
				
			case 6: 	//call count leaf node
		            if (bst.root == null)
		                System.out.print("Tree is Empty");
		            else{
		                int cnt = bst.count_leaf_nodes(bst.root);
		                System.out.print("\nThe number of leaves are: "+cnt);
		            }
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
				
			case 7: int c = bst.height(bst.root); 			//call to calculate height of tree
					System.out.println("Height of the binary search tree is: "+ c);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
				
			case 8: bst.parent_node();						//call parent_node
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
				
			case 9: System.exit(0);
				break;
			}
		}while(choice != 5);
	}
	
}
/***********************************************OUTPUT*****************************************************
 			Structure of Binary tree							TIME COMPLEXITIES
 						8									1. Create Binary Search tree: O(n)
 					   / \									2. Minimum Node				: O(log n)
 					  /   \									3. Maximum Node				: O(log n)
 					 3    10								4. Level wise display nodes	: O(n)
 					/\     \								5. Display in descending	: O(n)
 				   /  \     \								6. Number of leaf nodes		: O(n)
 				  1    6    14								7. Height of tree			: O(n)
 				  	  /\    /								8. Parent of given node		: O(n)
 				 	 /  \  /
 					 4  7 13
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS											

1. create binary search tree 												
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 1
Enter data to be inserted in the tree: 8
Root node inserted
------------------------------------------------
Do you want to continue? (y/n): y
Enter data to be inserted in the tree: 3
Left child inserted 3
------------------------------------------------
Do you want to continue? (y/n): y
Enter data to be inserted in the tree: 1
Left child inserted 1
------------------------------------------------
Do you want to continue? (y/n): y
Enter data to be inserted in the tree: 6
Right child inserted 6
------------------------------------------------
Do you want to continue? (y/n): y
Enter data to be inserted in the tree: 4
Left child inserted 4
------------------------------------------------
Do you want to continue? (y/n): y
Enter data to be inserted in the tree: 7
Right child inserted 7
------------------------------------------------
Do you want to continue? (y/n): y
Enter data to be inserted in the tree: 10
Right child inserted 10
------------------------------------------------
Do you want to continue? (y/n): y
Enter data to be inserted in the tree: 14
Right child inserted 14
------------------------------------------------
Do you want to continue? (y/n): y
Enter data to be inserted in the tree: 13
Left child inserted 13
------------------------------------------------
Do you want to continue? (y/n): n
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 2
Minimum is : 1
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 3
Maximum is : 14
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 4
8 3 10 1 6 14 4 7 13 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 5
14 13 10 8 7 6 4 3 1 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 6

The number of leaves are: 4
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 7
Height of the binary search tree is: 3
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 8
Enter child node whose parent is to be found: 10
Parent of node 10: 8
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 9
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 2
Tree is Empty!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 3
Tree is Empty!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 4
Tree is empty

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<><><><><><><><><><><><><><><><><><><><><><><><>
	BINARY SEARCH TREE OPERATIONS

1. create binary search tree 
2. Find minimum node 
3. Find Maximum node 
4. Display tree Levelwise
5. Display tree in descending order
6. Count number of leaf nodes 
7. Find height of the tree 
8. Parent node
9. Exit
<><><><><><><><><><><><><><><><><><><><><><><><>
Enter your choice: 5
Tree is Empty

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
**********************************************************************************************************/
