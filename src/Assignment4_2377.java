import java.util.Scanner;
class Graph{
	Scanner sc = new Scanner(System.in);
	int vertices, edges;
	int no_of_hs, no_of_ln;
	int [][] adjancey_matrix;
	int head[];
	Graph(){
		vertices = 0;
		edges = 0;
		head = null;
	}
	
	void createGraph() {
		System.out.print("Enter number of houses: ");
		vertices = sc.nextInt();
		System.out.print("Enter number of lanes: ");
		edges = sc.nextInt();
		for(int lane = 0; lane < edges; lane++) {
			System.out.print("\nEnter source vertex: ");
			int src_vrtx = sc.nextInt();
			System.out.print("\nEnter destination vertex: ");
			int dest_vrtx = sc.nextInt();
			adjancey_matrix[src_vrtx][dest_vrtx] = 1; 
		}
	}
	
	void displayGraph() {
		
	}
	void createUsingAdjMat() {

	}
}
public class Assignment4_2377 {

}
