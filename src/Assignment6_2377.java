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
class Table {
	Scanner sc = new Scanner(System.in);
	long acc, id_;
	String name_;
	double balance_;
	int size=3,flag_[], currentsize=0;;
	
	
	//int hash address;
	Customer hash_table[] = new Customer[size];
	//Calculate hash key
	int hash(long key) {
		return (int) (key%size);
	}
	
	//set flags

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
			System.out.println("Enter details of customer");
			System.out.print("Enter id: ");
			acc = sc.nextLong();
			id_ = acc;
			System.out.print("Enter name: ");
			name_ = sc.next();
			System.out.print("Enter Balance: ");
			balance_ = sc.nextDouble();
			//System.out.print("Enter the key to insert details: ");
			//key = sc.nextInt();
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
		else if(hash_table.length==count+1)
			System.out.println("Hash Table is Full");
		else if(hash_table!=null){
			System.out.println("Details of Customer");
			System.out.printf("%-4s |  %-9s  |  %-6s%n", "ID", "NAME", "BALANCE");
			System.out.println(".......................................");
			for(int i=0; i<size;i++) {
				if(hash_table[i]!= null) {
					System.out.printf("%4d |  %-9s  |  %4f", hash_table[i].acc_no, hash_table[i].name, hash_table[i].balance);
					count++;
				}
				else {
					continue;
				}
				System.out.println();
			}
			System.out.println("........................................");
		}
	}
	//Search the record in the table
	void search() {
		int flag=0, hashval;
		long key; 
		for(int i=0; i<size; i++) {
			if(isEmpty()) {
				System.out.println("Record is Empty!");
				break;
			}
			System.out.print("Enter the Id to find record: ");
			key = sc.nextInt();
			hashval = hash(key);
			if(hash_table[i].id == hashval && flag == 0 ) {
				flag=1;
				System.out.println("Record Found! The record is...");
				System.out.printf("%-4s |  %-9s  |  %-6s%n", "ID", "NAME", "BALANCE");
				System.out.println(".......................................");
				System.out.printf("%4d |  %-9s  |  %4f", hash_table[i].acc_no, hash_table[i].name, hash_table[i].balance);
				break;
			}
			if(flag == 0){
				System.out.println("Record not found!");
				break;
			}
		}
	}
	//Delete the record from the hash table
	void delete() {
		int key,flag=0, hashval;
		boolean true_ = false;
			for(int i=0; i<size; i++) { //do
				System.out.print("Enter the key to be deleted: ");
				key = sc.nextInt();
				hashval = hash(key);
				if(hash_table[i] != null && hash_table[i].id == hashval && flag == 0) {
					hash_table[hashval] = null;
					hash_table[i] = null;
					currentsize--;
					System.out.println("Customer's Record Deleted!");
					flag = 1;
				}
				else {
					i = (i+1)%size;
				}
			}//while(!true_);
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
		//menu:
		do {
			System.out.println("\n1. Insert \n2. Display \n3. Search \n4. Delete \n5. Exit \nEnter the option: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: tb.insert();
				break;
			case 2: tb.display();
				break;
			case 3: tb.search();
				break;
			case 4: tb.delete();
					//continue menu;
				break;
			case 5:System.exit(0);
				break;
			}
		}while(choice!=4);
	}
}


