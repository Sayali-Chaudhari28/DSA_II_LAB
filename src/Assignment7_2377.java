/*******************************************************************************************************
 											Assignment 7
Title: Use a sequential file to maintain student information. Develop java code to add, and display 
student information from the file.( you can add search and delete operations).
.......................................................................................................
Name	: Sayali Narendra Chaudhari
roll no : 2377
c no.	: C22020222303
Div 	: A
Batch 	: A3
GitHub Link: 
*******************************************************************************************************/
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int roll_no;
	double marks;
	String name;
	public Student(int roll_no, String name ,double marks) {
		this.roll_no = roll_no;
		this.name = name;
		this.marks = marks;
	}
	public String toString() {
		String s = "Student{ "+ " id= "+roll_no+" name= "+name+ " marks  "+marks+"}";
		return s;
	}
}
class File1{
	int roll_no_, ch;
	double marks_;
	String name_;
	Scanner sc = new Scanner(System.in);
	Vector<Student> st = new Vector<>();
	ObjectOutputStream outStream  = null;
	static Student n;
	void writeinFile() {
		do {	
			System.out.print("Enter Name: ");
			name_ = sc.next();
			System.out.print("Enter roll number: ");
			roll_no_ = sc.nextInt();
			System.out.print("Enter Marks: ");
			marks_ = sc.nextInt();
			
			n = new Student(roll_no_, name_, marks_);
			st.add(n);
			System.out.print("Do you want to insert record (yes-1/No-0): ");
			ch = sc.nextInt();
			System.out.println("\n------------------------------------------------\n");
		}while(ch!=0);
			try {
				FileOutputStream f = new FileOutputStream("abc.txt");
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(st);
				f.close();
				System.out.println("DATA WRITTEN TO FILE SUCCESSFULLY!");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	void readFile() {
		try {
			FileInputStream f = new FileInputStream("abc.txt");
			ObjectInputStream is = new ObjectInputStream(f);
			Vector<Student> deserialize_stud = (Vector<Student>)is.readObject();
			Iterator<Student> itr = deserialize_stud.iterator();
			System.out.printf(" %-4s  |  %-8s  |  %-4s%n ", "Roll no", "Name", "Marks");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			while(itr.hasNext()) {
				n = itr.next();
				System.out.printf("  %4d   |  %-8s  |  %-4s%n ",n.roll_no, n.name, n.marks);
			}
			System.out.println("-------------------------------------------");
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
	 void searchRecord() {
		 int flag = 0, rollno;
		 System.out.print("\nEnter the roll number: ");
		 rollno = sc.nextInt();
		 try {
			 FileInputStream f = new FileInputStream("abc.txt");
			 ObjectInputStream ois = new ObjectInputStream(f);
			 Vector<Student> vs = (Vector)ois.readObject();
			 Iterator itr = vs.iterator();
			 
			 while(itr.hasNext()){
				 n = (Student)itr.next();
				 if(n.roll_no == rollno) {
					 flag = 1;
					System.out.printf(" %-4s  |  %-8s  |  %-4s%n ", "Roll no", "Name", "Marks");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.printf("   %4d   |  %-8s  |  %-4s%n ",n.roll_no, n.name, n.marks);
				}
			 }
			 if(flag == 0) {
				 System.out.println("RECORD NOT FOUND!");
			 }
		 }
		 catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 void deleteRecord() {
		 int rollno;
		 System.out.print("\nEnter Roll number to be deleted: ");
		 rollno = sc.nextInt();
		 try {
			 FileInputStream f = new FileInputStream("abc.txt");
			 ObjectInputStream ois = new ObjectInputStream(f);
			 FileOutputStream f1 = new FileOutputStream("xyz.txt");
			 ObjectOutputStream oos = new ObjectOutputStream(f1);
			 Vector<Student> st1 = (Vector)ois.readObject();
			 Iterator<Student> itr = st1.iterator();
			 Vector<Student> st2 = new Vector<Student>();
			 while(itr.hasNext()) {
				 n = itr.next();
				 if(n.roll_no != rollno) {
					 st2.add(n);
				 }
				 else {
					 continue;
				 }
			 }
			 oos.writeObject(st2);
			 System.out.println("Record Deleted!");
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		}
	 }
}
public class Assignment7_2377 {

	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);
		File1 record = new File1();
		do {
			System.out.print("\n\t\tSTUDENT RECORD \n\n1. Insert record of student \n2. Display Student's record \n3. Search record of student \n4. Delete record of student \n5. Exit \nSelect choice: ");
			choice = sc.nextInt();
			System.out.println("\n------------------------------------------------\n");
			switch(choice) {
			case 1: record.writeinFile();
					System.out.println("\n------------------------------------------------\n");
				break;
			case 2: record.readFile();
					System.out.println("\n------------------------------------------------\n");
				break;
			case 3: record.searchRecord();
					System.out.println("\n------------------------------------------------\n");
				break;
			case 4: record.deleteRecord();
					System.out.println("\n------------------------------------------------\n");
					record.readFile();
				break;
			case 5: System.out.println("\n------------------------------------------------\n"); 
					System.exit(0);
				break;
			}
		}while(choice!=5);
	}

}

/*******************************************OUTPUT******************************************************

STUDENT RECORD 

1. Insert record of student 
2. Display Student's record 
3. Search record of student 
4. Delete record of student 
5. Exit 
Select choice: 1

------------------------------------------------

Enter Name: Sayali
Enter roll number: 77
Enter Marks: 88
Do you want to insert record (yes-1/No-0): 1

------------------------------------------------

Enter Name: Vidya
Enter roll number: 23
Enter Marks: 87
Do you want to insert record (yes-1/No-0): 1

------------------------------------------------

Enter Name: Sejal
Enter roll number: 34
Enter Marks: 82
Do you want to insert record (yes-1/No-0): 0

------------------------------------------------

DATA WRITTEN TO FILE SUCCESSFULLY!

------------------------------------------------


STUDENT RECORD 

1. Insert record of student 
2. Display Student's record 
3. Search record of student 
4. Delete record of student 
5. Exit 
Select choice: 2

------------------------------------------------

Roll no  |  Name      |  Marks
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    77   |  Sayali    |  88.0
    23   |  Vidya     |  87.0
    34   |  Sejal     |  82.0
-------------------------------------------

------------------------------------------------


STUDENT RECORD 

1. Insert record of student 
2. Display Student's record 
3. Search record of student 
4. Delete record of student 
5. Exit 
Select choice: 3

------------------------------------------------


Enter the roll number: 77
Roll no  |  Name      |  Marks
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    77   |  Sayali    |  29.0

------------------------------------------------


STUDENT RECORD 

1. Insert record of student 
2. Display Student's record 
3. Search record of student 
4. Delete record of student 
5. Exit 
Select choice: 4

------------------------------------------------


Enter Roll number to be deleted: 77

Record Deleted!

------------------------------------------------

Roll no  |  Name      |  Marks
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    23   |  Vidya     |  87.0
    34   |  Sejal     |  82.0
-------------------------------------------

STUDENT RECORD 

1. Insert record of student 
2. Display Student's record 
3. Search record of student 
4. Delete record of student 
5. Exit 
Select choice: 5

------------------------------------------------


-------------------TIME COMPLEXITY----------------
1. writeRecord()	:	O(n)
2. ReadRecord()		:   O(n)
3. searchRecord()	:	O(n)
4. deleteRecord() 	: O(n)




*************************************************************************************************/
