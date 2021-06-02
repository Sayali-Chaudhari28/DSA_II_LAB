/*******************************************************************************************************
 											Assignment 6
Title: Implement a hash table for storing bank account information. Handle the collision using
		linear probing without replacement. Perform operations on it.

.......................................................................................................
Name	: Sayali Narendra Chaudhari
roll no : 2377
c no.	: C22020222303
Div 	: A
Batch 	: A3
Github link: https://github.com/Sayalinc28/DSA_II_LAB/blob/master/src/Assignment6_2377.java
*********************************************************************************************************/
import java.util.Scanner;

class Customer{
	long acc_no;
	long id;
	String name;
	double balance;
	public Customer(long acc_no, String nm, Double bal) {
		this.acc_no = acc_no;
		id = acc_no;
		name = nm;
		balance = bal;
	}
}
//-------------------------------------------------------------------------------
class Table {
	Scanner sc = new Scanner(System.in);
	long acc, id_;
	String name_;
	double balance_;
	int size=7,flag_[], currentsize=0;;
	
	
	Customer hash_table[] = new Customer[size];
	//Calculate hash key
	int hash(long key) {
		return (int) (key%size);
	}
	
	//check hash table is full or not
	boolean isFull() {
		return currentsize == size;
	}
	//check hash table is empty or not
	boolean isEmpty() {
		return currentsize == 0;
	}
	
	//Insert into table
	void insert() {
		long key;
		if(isFull())
			System.out.println("Hash table is full!");
		else {
			//accept values
			System.out.println("\t\tDO YOUR REGISTERATION HERE\n");
			System.out.print("Enter id: ");
			acc = sc.nextLong();
			id_ = acc;
			System.out.print("Enter name: ");
			name_ = sc.next();
			System.out.print("Enter Balance: ");
			balance_ = sc.nextDouble();
			key = hash(id_);
			Customer cus = new Customer(acc, name_, balance_);	//calculate hash value
			
			for(int i=0; i < size; i++) {
				if(hash_table[i] == null) {
					hash_table[i] = cus;
					hash_table[i].id = key;
					currentsize++;
					i=hash(i);
					break;
				}
				
			}
		}
	}
	
	//Display details from table
	void display() {
		int count=0;
		if(isEmpty())
			System.out.println("Record is Empty");
//		else if(hash_table.length==count+1)
//			System.out.println("Hash Table is Full");
		else if(hash_table!=null){
			System.out.println("\t\t\tDETAILS OF CUSTOMERS\n");
			System.out.printf("\t\t %-4s |  %-9s  |  %-6s%n", "ID", "NAME", "BALANCE");
			System.out.println("\t\t.......................................");
			for(int i=0; i<size;i++) {
				if(hash_table[i]!= null) {
					System.out.printf("\t\t %4d |  %-9s  |  %4f", hash_table[i].acc_no, hash_table[i].name, hash_table[i].balance);
					count++;
				}
				else {
					continue;
				}
				System.out.println();
			}
			System.out.println("\t\t........................................");
		}
	}
	//Search the record in the table
	void search() {
		int flag=0, hashval;
		long key; 
		if(isEmpty()) {
			System.out.println("Record is Empty!");
		}
		else {
			System.out.print("Enter the Id to search your account details: ");
			key = sc.nextInt();
			hashval = hash(key);
			for(int i=0; i<size; i++) {
				if(hash_table[i].id == hashval && flag == 0 ) {
					flag=1;
					System.out.println("Record Found! \n\t\t\tDETAILS ARE...");
					System.out.printf("\t\t%-4s |  %-9s  |  %-6s%n", "ID", "NAME", "BALANCE");
					System.out.println("\t\t.......................................");
					System.out.printf("\t\t%4d |  %-9s  |  %4f", hash_table[i].acc_no, hash_table[i].name, hash_table[i].balance);
					break;
				}
			}
			if(flag == 0){
				System.out.println("Record not found! Please neter valid credentials");
			}
		}		
	}
	//Delete the record from the hash table
	void delete() {
		int key,flag=0, hashval;
		System.out.print("Enter the account number to be deleted: ");
		key = sc.nextInt();
		hashval = hash(key);
			for(int i=0; i<size; i++) {
				if(hash_table[i] != null && hash_table[i].id == hashval && flag == 0) {
					hash_table[i] = null;
					currentsize--;
					System.out.println("Dear "+key+" your account has been Deleted Successfully!");
					flag = 1;
					break;
				}
			}
			if(flag==0) {
				System.out.println("Data not found!");
			}
	}
}

public class Assignment6_2377 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Table tb = new Table();
		int choice;
		do {
			System.out.println("\n_________________________________________________________\n");
			System.out.println("\t\t\tWELCOME TO BANK");
			System.out.print("\n1. Insert \n2. Display \n3. Search \n4. Delete \n5. Exit \nEnter the option: ");
			choice = sc.nextInt();
			System.out.println("\n_________________________________________________________\n");
			switch(choice) {
			case 1: tb.insert();				//call insert
				
				break;
			case 2: tb.display();				//call display
				break;	
			case 3: tb.search();				//call search
				break;
			case 4: tb.delete();				//call delete
				break;
			case 5: System.out.println("Exited....");
				System.exit(0);				//exit
				break;
			}
		}while(choice!=5);
	}
}
/*******************************************************************************************************
 
_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 2

_________________________________________________________

Record is Empty

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 3

_________________________________________________________

Record is Empty!

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 4

_________________________________________________________

Enter the account number to be deleted: 34
Data not found!

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 1

_________________________________________________________

		DO YOUR REGISTERATION HERE

Enter id: 23
Enter name: Jay
Enter Balance: 873667

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 1

_________________________________________________________

		DO YOUR REGISTERATION HERE

Enter id: 44
Enter name: Sayali
Enter Balance: 8822

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 1

_________________________________________________________

		DO YOUR REGISTERATION HERE

Enter id: 53
Enter name: Veer
Enter Balance: 56732

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 2

_________________________________________________________

			DETAILS OF CUSTOMERS

		 ID   |  NAME       |  BALANCE
		.......................................
		   23 |  Jay        |  873667.000000
		   44 |  Sayali     |  8822.000000
		   53 |  Veer       |  56732.000000
		........................................

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 3

_________________________________________________________

Enter the Id to search your account details: 44
Record Found! 
				DETAILS ARE...
		ID   |  NAME       |  BALANCE
		.......................................
  		23 |  Jay        |  873667.000000
_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 4

_________________________________________________________

Enter the account number to be deleted: 23
CDear 23 your account has been Deleted Successfully!

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 4

_________________________________________________________

Enter the account number to be deleted: 44
Dear 44 your account has been Deleted Successfully!

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 2

_________________________________________________________

			DETAILS OF CUSTOMERS

		 ID   |  NAME       |  BALANCE
		.......................................
		   53 |  Veer       |  56732.000000
		........................................

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 1

_________________________________________________________

		DO YOUR REGISTERATION HERE

Enter id: 4
Enter name: Lina
Enter Balance: 473674

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 2

_________________________________________________________

			DETAILS OF CUSTOMERS

		 ID   |  NAME       |  BALANCE
		.......................................
		    4 |  Lina       |  473674.000000
		   53 |  Veer       |  56732.000000
		........................................

_________________________________________________________

			WELCOME TO BANK

1. Insert 
2. Display 
3. Search 
4. Delete 
5. Exit 
Enter the option: 5

_________________________________________________________

Exited....



		TIME COMPLEXITIES
-------------------------------------
insert		:	O(n)
display		:	O(n)
search		:	O(n)
delete		:	O(n)

 *******************************************************************************************************/
 

