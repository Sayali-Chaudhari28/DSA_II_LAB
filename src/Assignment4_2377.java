/*******************************************************************************************************
 											Assignment 4
Title: A news paper delivery boy every day drops news paper in a society having many lanes and houses. 
Represent this as a graph using adjacency matrix or adjacency list. Perform Depth First traversal and 
Breadth First traversal.
.......................................................................................................
Name	: Sayali Narendra Chaudhari
roll no : 2377
c no.	: C22020222303
Div 	: A
Batch 	: A3
Github link: https://github.com/Sayalinc28/DSA_II_LAB/blob/master/src/Assignment4_2377.java
********************************************************************************************************/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
class node_
{
	int house;
	int dist;
	node_ next;
	
	node_(){
		house=0;
		next=null;
	}
	
	node_(int house,int dist){
		this.house=house;
		this.dist=dist;
	}
	
    node_(int house)
    {
          this.house=house;
    }
	void display(){
		System.out.println("House Number: "+house);
		System.out.println("Distance: "+dist);
	}
}
class Graph{
	Scanner sc = new Scanner(System.in);
	int vertices, edges;
	int no_of_hs, no_of_ln;
	int [][] adjancey_matrix;
	node_ head[];
	Graph(){
		vertices = 0;
		edges = 0;
		head = null;
	}
	//create adjancy matrix
	void createGraph() {
		System.out.print("Enter number of houses: ");
		vertices = sc.nextInt();
		System.out.print("Enter number of lanes: ");
		edges = sc.nextInt();
		adjancey_matrix = new int[vertices][edges];
		for(int lane = 0; lane < edges; lane++) {
			System.out.println("-----------------------------------------");
			System.out.print("Enter house number: ");
			int src_vrtx = sc.nextInt();
			System.out.print("Enter Lane number: ");
			int dest_vrtx = sc.nextInt();
			adjancey_matrix[src_vrtx][dest_vrtx] = 1;
		}
	}
	//Display adjancy graph
	void displayGraph() {
		System.out.println("\n_________________________________________\n");
		System.out.println("Adjancey Matix is \n");
		System.out.print("  |");
		for(int i=0;i<edges; i++)
			System.out.print(" "+(i+1)+"");
		System.out.print("\n~~~~~~~~~~~~~~~~~~~~\n");
		for(int i=0; i<vertices; i++) {
			System.out.print((i+1)+" | ");
			for(int j=0; j<edges; j++) {
				System.out.print(adjancey_matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	//Display bfs
	void display_adjency_mat()
    {
		System.out.println("\nGraph is\n");
        for(int i=0;i<vertices;i++)
        {
        	System.out.print("\n");
            for(int j=0;j<vertices;j++){
                System.out.print(adjancey_matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
	
	//bfs
	void bfs()
    {
		System.out.println("-----------------------------------------");
		System.out.println("BFS is...");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the starting vertex: ");
        int start = sc.nextInt();
        boolean[] visited = new boolean[vertices]; 
        visited[start - 1] = true;
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(start); 
        while(!q.isEmpty())
        {
            int a=q.poll();
            System.out.print(a+" ");
            for(int i=0;i<vertices;i++)
            {
                if(adjancey_matrix[a-1][i]==1 && visited[i]==false)
                {
                    q.add(i+1);
                    visited[i]=true;
                }
            }
        }
        display_adjency_mat();
    }
	
	//create adjancy List
	void adjlist(){
		System.out.println("-----------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter the number of vertices: ");
		vertices=sc.nextInt();
		System.out.print("\nEnter the number of edges: ");
		edges=sc.nextInt();
		head=new node_[vertices];
		for(int i=0;i<vertices;i++)
		{
			head[i]=new node_();
			head[i]=null;
		}
		
		for(int i=0;i<edges;i++){
			System.out.println("-----------------------------------------");
			System.out.print("Enter the source house no.: ");
			int source=sc.nextInt();
			System.out.print("Enter the destination house no.: ");
			int dest=sc.nextInt();
			System.out.print("Enter the distance: ");
			int dist = sc.nextInt();
			insert(source,dest,dist);
			insert(dest,source,dist);
		}
	}
	
	void insert(int source,int dest,int dist)
	{
		node_ temp=new node_(dest,dist);
		if(head[source]==null){
			head[source]=temp;
		}
		
		else{ 
			node_ ptr=head[source];
			while(ptr.next!=null){
                ptr=ptr.next;
				
			}
        ptr.next=temp;
		}
	}
	void dispadjlist()
    {
		System.out.println("-----------------------------------------");
        for(int i=0;i<vertices;i++){
            System.out.println("From house no. "+(i+1)+": ");
            if(head[i]==null){
                System.out.println("\nEmpty"); 
            }
            else{
                node_ ptr=head[i];
                while(ptr!=null){
                    ptr.display();
                    ptr=ptr.next;
                }
            }
            System.out.println();
        }
    }
	void dfs()
    {
		System.out.println("-----------------------------------------");
		System.out.println("The DFS is...");
		Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the starting vertex: ");
        int start=sc.nextInt();
        //node temp=new node(start);
        boolean[] visited = new boolean[vertices]; 
        visited[start] = true;
        Stack<Integer> s=new Stack<Integer>();
        s.push(start);
        while(!s.empty())
        {
            int a=s.pop();
            System.out.print(a+" ");
            if(head[a].next!=null)
            {
                node_ ptr=head[a];
               while(ptr!=null )
               {
                   
                   if(visited[(ptr.house)]==false)
                   {
                       s.push(ptr.house);
                        int v=ptr.house;
                        visited[v]=true;
                   }
                   ptr=ptr.next;
               }
                
            }
        }
    }
}

public class Assignment4_2377 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int choice;
		Graph g = new Graph();
		do {
			System.out.print("\n\t\tGraph Operations");
			System.out.print("\n1. Create graph using adjancey matirix \n2. Display graph adjancey matrix"
					+ "\n3. bfs \n4. dfs(using adjancey lsit \n5. Exit \nChoose Operation: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: g.createGraph();
				break;
			case 2: g.displayGraph();
				break;
			case 3: g.bfs();
				break;
			case 4:g.adjlist();
				   g.dispadjlist();
				   g.dfs();
	         	break;
			case 5: System.exit(0);
				break;
			}
		}while(choice != 4);
	}
}
/************************************************************************************************************************************
 
		Graph Operations
1. Create graph using adjancey matirix 
2. Display graph adjancey matrix
3. bfs 
4. dfs(using adjancey lsit 
5. Exit 
Choose Operation: 1
Enter number of houses: 4
Enter number of lanes: 4
-----------------------------------------
Enter house number: 0
Enter Lane number: 1
-----------------------------------------
Enter house number: 1
Enter Lane number: 2
-----------------------------------------
Enter house number: 2
Enter Lane number: 3
-----------------------------------------
Enter house number: 3
Enter Lane number: 0

		Graph Operations
1. Create graph using adjancey matirix 
2. Display graph adjancey matrix
3. bfs 
4. dfs(using adjancey lsit 
5. Exit 
Choose Operation: 2

_________________________________________

Adjancey Matix is 

  | 1 2 3 4
~~~~~~~~~~~~~~~~~~~~
1 | 0 1 0 0 
2 | 0 0 1 0 
3 | 0 0 0 1 
4 | 1 0 0 0 

		Graph Operations
1. Create graph using adjancey matirix 
2. Display graph adjancey matrix
3. bfs 
4. dfs(using adjancey lsit 
5. Exit 
Choose Operation: 3
-----------------------------------------
BFS is...
Enter the starting vertex: 1
1 2 3 4 

Graph is

0	1	0	0	
0	0	1	0	
0	0	0	1	
1	0	0	0	

		Graph Operations
1. Create graph using adjancey matirix 
2. Display graph adjancey matrix
3. bfs 
4. dfs(using adjancey lsit 
5. Exit 
Choose Operation: 4
-----------------------------------------

Enter the number of vertices: 4
Enter the number of edges: 4
-----------------------------------------
Enter the source house no.: 0
Enter the destination house no.: 1
Enter the distance: 1
-----------------------------------------
Enter the source house no.: 0
Enter the destination house no.: 1
Enter the distance: 1
-----------------------------------------
Enter the source house no.: 0
Enter the destination house no.: 2
Enter the distance: 1
-----------------------------------------
Enter the source house no.: 2
Enter the destination house no.: 3
Enter the distance: 1
-----------------------------------------
From house no. 1: 
House Number: 1
Distance: 1
House Number: 1
Distance: 1
House Number: 2
Distance: 1

From house no. 2: 
House Number: 0
Distance: 1
House Number: 0
Distance: 1

From house no. 3: 
House Number: 0
Distance: 1
House Number: 3
Distance: 1

From house no. 4: 
House Number: 2
Distance: 1

-----------------------------------------
The DFS is...
Enter the starting vertex: 1
1 0 2 3 




			TIME COMPLEXITIES
create adjancey matrix		: 	O(n)
display adjancey matrix		:	O(n^2)
BFS							:	O(|V|^2)
DFS							:	O(V^2)

*************************************************************************************************************************************/