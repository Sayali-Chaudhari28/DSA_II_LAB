/*******************************************************************************************************
 											Assignment 5
Title: Write a modular program to implement primitive operations on Min/Max Heap

.......................................................................................................
Name	: Sayali Narendra Chaudhari
roll no : 2377
c no.	: C22020222303
Div 	: A
Batch 	: A3
Github link: 
*********************************************************************************************************/
import java.util.*;
class heap
{
	int h[]= new int[20];
	int totalno;
	Scanner console = new Scanner(System.in);
	void createmax()  // Create heap
	{
	    System.out.print("Enter the total number of elements: ");
	    totalno = console.nextInt();
	    h[0]=totalno;
	    System.out.print("Enter elements: ");
	    for(int i=1;i<=totalno;i++){
	        int d = console.nextInt();
	        h[i]=d;
	        upadjmax(i);
	    }
	}

	void upadjmax(int i) {
		while(i>1) {
			int parent=(int)Math.floor(i/2);
			if(h[i]>h[parent]) {
				int temp=h[parent];
				h[parent]=h[i];
				h[i]=temp;
				i=parent;
			}
			else {
				return;
			}
		}
	}
	void downadjmax() //downadjustment
	{
	    //Build heap using bottom up approach :
	    System.out.println("Enter the total number of elements: ");
	    totalno = console.nextInt();
	    h[0]=totalno;
	    System.out.print("Enter elements: ");
	    for(int i=1;i<=totalno;i++){
	        int d = console.nextInt();//Read all elements in array
	        h[i] = d;
	        
	    } 
	    for(int j =totalno/2;j>=1;j--){//Repeat for i = n/2 downto 1
	        Reheapify(1,totalno);         //call Downadjustment for every element at (j)
	    }
	    
	}
	void Reheapify(int i,int totalno){
	    int l = 2*i;              //Set l to left child of i
	    int r = (2*i)+ 1;           //Set r to right child of i
	    int largest = i;
	                                   //Compare element at largest/smallest and element at i
	    if(l<=totalno && h[l]>h[largest]){
	        largest = l;
	    }
	    if(r<=totalno && h[r]>h[largest]){
	        largest = r;
	    }
	    if(largest!=i){           //If element at i is less than /greater than element at largest/smallest
	        int temp = h[i];
	        h[i]= h[largest];             //Exchange elements
	        h[largest]=temp;
	        Reheapify(largest,totalno);
	    }
	}
	
	void displaymax()
	{
	    System.out.println("Displaying heap:\n");
	    for(int i = 1;i<=totalno;i++){
	        System.out.println(h[i] + " ");
	    }
	}
	void delmaxroot(){
	     int temp = h[totalno];
	     h[totalno] = h[1];//Store last element of heap at first element of heap
	     h[1] = temp;
	     totalno--;             //decrement size of heap
	     Reheapify(1,totalno);
	     System.out.println("Heap after deletion of root is:\n");
	     for(int i=1;i<=totalno;i++){
			System.out.print(h[i] + " ");
		 }
        
	}
	void heapsort()  //heapsort
	{
	   
	   for(int i=1;i<totalno;i++){
	        int temp = h[totalno-i];
	        h[totalno-i] = h[1];
	        h[1] = temp;
			Reheapify(totalno-i,1);
		}
		System.out.println("Sorted heap is: \n");
		for(int i=1;i<=totalno;i++){
			System.out.print(h[i] + " ");
		 }
	    
    }
}    
 
public class Assignment5_2377 {

	public static void main(String[] args) 
	{
		heap hp=new heap();
		Scanner s=new Scanner(System.in);
		int opt,opt1,ans;
		do
		{
			System.out.println("\t\tHEAP OPERATIONS");
			System.out.print("\n1. Create using Up adjustment  \n2. Display max heap by upadjustment   "
					+ "\n3. Insert using down adjustment   \n4. Display using Down adjustment "
					+ "\n5. Heap sort \n6. Delete \nEnter your option :");
			opt1=s.nextInt();
			System.out.println("_____________________________________\n");
			switch(opt1) {
				case 1: hp.createmax();
				System.out.println("\n_____________________________________\n");
					break;
				case 2: hp.displaymax();
				System.out.println("\n_____________________________________\n");
					break;
				case 3:hp.downadjmax();
				System.out.println("\n_____________________________________\n");
					break;
				case 4:hp.displaymax(); 
				System.out.println("\n_____________________________________\n");
					break;
				case 5: hp.heapsort();  
				System.out.println("\n_____________________________________\n");
					break;
				case 6: hp.delmaxroot();
				System.out.println("\n_____________________________________\n");
					break;
				case 7: System.out.println("Exited");
					break;
				default: System.out.println("Invalid choice.");
			}	
			System.out.print("Do you want to continue?(1/0): ");
			ans=s.nextInt();
		}while(ans==1);
	}

}

/*********************************************OUTPUT******************************************************
		HEAP OPERATIONS

1. Create using Up adjustment  
2. Display max heap by upadjustment   
3. Insert using down adjustment   
4. Display using Down adjustment 
5. Heap sort 
6. Delete 
Enter your option :1
_____________________________________

Enter the total number of elements: 5
Enter elements: 84
36
27
19
65

_____________________________________

Do you want to continue?(1/0): 1
		HEAP OPERATIONS

1. Create using Up adjustment  
2. Display max heap by upadjustment   
3. Insert using down adjustment   
4. Display using Down adjustment 
5. Heap sort 
6. Delete 
Enter your option :2
_____________________________________

Displaying heap:

84 
65 
27 
19 
36 

_____________________________________

Do you want to continue?(1/0): 1
		HEAP OPERATIONS

1. Create using Up adjustment  
2. Display max heap by upadjustment   
3. Insert using down adjustment   
4. Display using Down adjustment 
5. Heap sort 
6. Delete 
Enter your option :3
_____________________________________

Enter the total number of elements: 
3
Enter elements: 1
2
3

_____________________________________

Do you want to continue?(1/0): 1
		HEAP OPERATIONS

1. Create using Up adjustment  
2. Display max heap by upadjustment   
3. Insert using down adjustment   
4. Display using Down adjustment 
5. Heap sort 
6. Delete 
Enter your option :4
_____________________________________

Displaying heap:

3 
2 
1 

_____________________________________

Do you want to continue?(1/0): 1
		HEAP OPERATIONS

1. Create using Up adjustment  
2. Display max heap by upadjustment   
3. Insert using down adjustment   
4. Display using Down adjustment 
5. Heap sort 
6. Delete 
Enter your option :2
_____________________________________

Displaying heap:

3 
2 
1 

_____________________________________

Do you want to continue?(1/0): 1
		HEAP OPERATIONS

1. Create using Up adjustment  
2. Display max heap by upadjustment   
3. Insert using down adjustment   
4. Display using Down adjustment 
5. Heap sort 
6. Delete 
Enter your option :5
_____________________________________

Sorted heap is: 

2 3 1 
_____________________________________

Do you want to continue?(1/0): 1
		HEAP OPERATIONS

1. Create using Up adjustment  
2. Display max heap by upadjustment   
3. Insert using down adjustment   
4. Display using Down adjustment 
5. Heap sort 
6. Delete 
Enter your option :6
_____________________________________

Heap after deletion of root is:

3 1 
_____________________________________

Do you want to continue?(1/0): 0


		TIME COMPLEXITY
createmax()=O(logn)
downadjmax() = O(nlogn)
heapsort() = O(nlogn)
Reheapify() = O(nlogn)
displaymax=O(n)
delmaxroot() = O(logn)
*********************************************************************************************************/