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
	tree root;
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
	//-------------------Display tree in descending order--------------
	void descending(tree r) {
		if(r!=null){
			descending(r.right);
			System.out.print(r.data+" ");
			descending(r.left);
		}
	}
	//------------------count number of nodes recursively--------------
	int leaf(tree temproot){
        if (temproot.left ==null && temproot.right==null){
            return 1;
        }
        return  ( leaf(temproot.left) + leaf(temproot.right) ); 
        
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
        if(value==root.data){       //if user enters root itself
            System.out.println("\nNo parent as it is itself a parent of all elements");
        }
        else{
            while(temp.data!=value && temp!=null){      //Traverse till leaf node
                if(value>temp.data){
                    parent=temp;
                    temp=temp.right;        //Traverse ptr to right child
                }
                else{
                    parent=temp;            //when value is less than data in temp
                    temp=temp.left;         //Traverse ptr to left child
                }
            }
            if(temp.data==value){       //given node is found
                System.out.println("Parent of node"+ value +": "+ parent.data);      //display parent node
            }
            else{
                System.out.println("Data not found");           //When temp==null
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
			System.out.print("1. create binary search tree "
					+ "\n2. Find minimum node "
					+ "\n3. Find Maximum node "
					+ "\n4. Display tree Levelwise"
					+ "\n5. Display tree in descinding order"
					+ "\n6. Count number of leaf nodes "
					+ "\n7. Find height of the tree "
					+ "\n8. Parent node"
					+ "\n9. Exit"
					+ "\nEnter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: bst.create_bst();
				break;
			case 2: bst.minimum();
				break;
			case 3: bst.maximum();
				break;
			case 4: bst.display_level();
				break;
			case 5:if(bst.root == null)
						System.out.println("Tree is Empty");
					else
						bst.descending(bst.root);
				break;
			case 6: System.out.println("Number of leaf nodes in the tree are: "+ bst.leaf(bst.root));
				break;
			case 7: int c = bst.height(bst.root); 
				System.out.println("Height of the binary search tree is: "+ c);
				break;
			case 8: bst.parent_node();
				break;
			case 9: System.exit(0);
				break;
			}
		}while(choice != 5);
	}
	
}
