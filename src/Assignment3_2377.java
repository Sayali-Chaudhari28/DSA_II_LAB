/*******************************************************************************************************
 											Assignment 3
Title: Create a reasonably balanced tree to maintain names and telephone numbers of all the customers of 
a shopkeeper and perform operations on it.Test your program for at least 10 names.
.......................................................................................................
Name	: Sayali Narendra Chaudhari
roll no: 2377
c no.	: C22020222303
Div 	: A
Batch 	: A3
Github Link: https://github.com/Sayalinc28/DSA_II_LAB/blob/master/src/Assignment3_2377.java
********************************************************************************************************/
import java.util.Scanner;
class node
{		                         //class node
	String name, telephone;
	node left,right;
	int height;
	//constructor
	node(){
		left=null;
		right=null;
		height=0;
	}
}
class Avl{
	node root;
	Avl(){			//constructor
		root=null;
	}
	//create function
	void create() {
		String res;
		do {
			Scanner s = new Scanner(System.in);
			node temp = new node();
			System.out.print("Enter the name: ");		//create new node
			temp.name=s.next();
			System.out.print("Enter the telephone number: ");
			temp.telephone=s.next();
			root=insert(root,temp);
			System.out.print("Do you want to add record(y/n): ");
			res = s.next(); 
			System.out.println("---------------------------------------------");
		}while(!res.equalsIgnoreCase("n"));
	}
	node insert(node root1,node temp1) {			//insert function
		int bal=0;
		if(root1==null) {							//if root1 is null
			return temp1;							//return temp1
		}
		else{
			if(root1.name.compareTo(temp1.name)>0){				//if temp1 data is less than root1 data
				root1.left = insert(root1.left,temp1);			//go to left side
				bal = bal_fact(root1);
				if(bal == 2 || bal == -2) {									//if balance factor is 2 or -2
					//if left data is greater than temp1 data
					if(root1.left.name.compareTo(temp1.name) > 0) { 
						System.out.println("LL performed");
						root1 = LL(root);										//LL rotation
					}
					else{
						System.out.println("LR performed");
					   root1 = LR(root);										//LR rotation
					}
				}
			}
			else{
				root1.right = insert(root1.right,temp1);																	
				bal = bal_fact(root1);						//calculate balance factor
				if(bal == -2 || bal == 2){
					if(root1.right.name.compareTo(temp1.name) < 0){
						System.out.println("RR performed");
						root1 = RR(root1);										//RR rotation
					 }
					else{
						System.out.println("RL performed");
						root1 = RL(root1);										//RL rotation
					}
				}
			}
		}
		root1.height=height_fun(root1);																		
		return(root1);																						
	}
	//Calculate balance factor
   int bal_fact(node lroot){
	   
	   return height_fun(lroot.left)-height_fun(lroot.right);
	   /*int bf,lh,rh;
		if(root==null){
			return 0;
		}
		if(root.left==null){
			lh=0;
		}
		else{
			lh = 1+bal_fact(root.left);																		
		}
		if(root.right==null){
			rh=0;
		}
		else{
			rh = 1+bal_fact(root.right);																	
		}
		bf = lh - rh;
		return bf;*/
	}
   //calculate height
   int height_fun(node root)																				
   {
	   int lh=0,rh=0;
	   if(root==null){
			return 0;
		}
		if(root.left==null){
			lh=0;
		}
		else{
			lh = 1+height_fun(root.left);																		
		}
		if(root.right==null){
			rh=0;
		}
		else{
			rh = 1+height_fun(root.right);																	
		}
		if(lh >rh)																							
		{
			return lh;																					    
		}
		else{
	       return rh;																				         
		}
   }
   
   //Left to left
   node LL(node root){
	   node temp = root.left;								//store left child in temp
	   root.left = temp.right;								//make right of root as right of temp
	   temp.right=root;										//make right of temp as root
	   temp.height = height_fun(temp);						//calculate heights of temp and root
	   root.height = height_fun(root);
	   return temp;
   }
   //right to right
   node RR(node root){
	   node temp=root.right;								//store right child in temp
	   root.right=temp.left;								//make right of root as left of temp
	   temp.left=root;										//make left of temp as root
	   temp.height=height_fun(temp);
	   root.height=height_fun(root);						//calculate heights of temp and root
	   return temp; 
   }
   //left to right
   node LR(node root){
	   System.out.println("in lr");  
	   root.left=RR(root.left);								//call RR
		root=LL(root);										//call LL
		return root;	
   }
   node RL(node root){
	   root.right=LL(root.right);							//call
		root=RR(root);										//call RR
		return root;
   }
   //inorder traversal
   void inorder(node n){
			if(root==null){
				System.out.println("tree is empty");
			}
			else{
				if(n!=null){
					inorder(n.left);
					System.out.print(n.name+"\t"+ n.telephone + "\n");
					inorder(n.right);
				}
			}
   }
}
public class Assignment3_2377{

	public static void main(String[] args) {
		Avl A1 = new Avl();
		int ch;
		Scanner s = new Scanner(System.in);
		do
		{      
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t\tMENU\n1.accept\n2.display\n0.exit");
		System.out.print("\nEnter choice: ");
		ch = s.nextInt();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		switch(ch)
		{
		case 1:A1.create();																					
		   		break;
		case 2: System.out.println("\tTelephone Book");
				System.out.println("__________________________________________");
				System.out.println("Name\t\tcontact number");
		
			A1.inorder(A1.root);	
		        break;
		case 3:break;
		}
		}while(ch!=0);
		
	}

}

/*******************************************OUTPUT********************************************************

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		MENU
1.accept
2.display
0.exit

Enter choice: 1
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Enter the name: Jay
Enter the telephone number: 8837746733
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Sayali
Enter the telephone number: 6653553637
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Vaishali
Enter the telephone number: 9934748347
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Narendra
Enter the telephone number: 6637728293
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Sonal
Enter the telephone number: 8837748374
RR performed
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Prashant
Enter the telephone number: 9918838283
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Arnav
Enter the telephone number: 8827738273
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Pramila
Enter the telephone number: 5536628233
RR performed
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Rama
Enter the telephone number: 9928838484
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Vidya
Enter the telephone number: 6627193834
Do you want to add record(y/n): y
---------------------------------------------
Enter the name: Sadhana
Enter the telephone number: 8837737383
LR performed
in lr
Do you want to add record(y/n): n
---------------------------------------------

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		MENU
1.accept
2.display
0.exit

Enter choice: 2
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	Telephone Book
__________________________________________
Name		contact number
Arnav		8827738273
Jay			8837746733
Narendra	6637728293
Pramila		5536628233
Prashant	9918838283
Rama		9928838484
Sadhana		8837737383
Sayali		6653553637
Sonal		8837748374
Vaishali	9934748347
Vidya		6627193834

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Enter choice: 
		MENU
1.accept
2.display
0.exit

Enter choice: 0
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



TIME COMPLEXITY:
 * insert function 	        =     O(log n)
   balance factor function 	=     O(n)
   height function	        =     O(n)
   LL rotation function 	=     O(1)			
   LR rotation function 	=     O(1)
   RR rotation function 	=     O(1)
   RL rotation function 	=     O(1)
   inorder function 		=     O(n)
**********************************************************************************************************/