package Graph;
import java.util.*;

class Node{
	int data;
	Node next;

	Node(int data){
		this.data=data ;
		next=null;
	}
}

class graph{
	int n; //number of vertices
	int e; //number of edges
	int[][] adjMat; //adjacency matrix of the graph
	Node[] head; //array of heads of linked list used for adjacency

	graph(){
		head = null;
		n = 0;
		e = 0;
	}

	void createUsingAdjMat(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of Houses: ");  //Accept number of vertices
		n = sc.nextInt();
		System.out.print("Enter number of Lanes: ");   //Accept number of Lanes
		e = sc.nextInt();
		adjMat = new int[n][n];           //Creating matrix of n x n
		System.out.print("Press 1 for Directed graph and 2 for Undirected");
		int dir = sc.nextInt();
		switch(dir){
		case 1:{   //Directed
			for (int i=0;i<e;i++) {         //For every lane
				System.out.print("Enter Houses at both the ends of the lane\n"
						+ "1st House number: ");
				int u = sc.nextInt();                    //Accept (u,v)
				System.out.print("2nd House number: ");
				int v = sc.nextInt();
				adjMat[u-1][v-1]=1;                     //Changing value to 1
			}
			break;
		}
		case 2:{   //Undirected
			for (int i=0;i<e;i++) {         //For every lane
				System.out.print("Enter Houses at both the ends of the lane\n"
						+ "1st House number: ");
				int u = sc.nextInt();                     //Accept (u,v)
				System.out.print("2nd House number: ");
				int v = sc.nextInt();
				adjMat[u-1][v-1]=1;                 //Changing both values to 1
				adjMat[v-1][u-1]=1;
			}
			break;
		}
		default:System.out.print("Enter Valid Option");
		}
	}

	void displayAdjMat(){
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				System.out.print(adjMat[i][j]+" ");
			}
			System.out.println(" ");
		}
	}

	void insert(int u,int v) {
		Node new_node= new Node(v);
		head = new Node[n];

		if(head[u]==null){
			head[u]=new_node;
		}
		else{
			Node curr=head[u];
			while(curr.next!=null){
				curr=curr.next;
			}
			curr.next=new_node;
		}
	}

	void createUsingAdjList(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of Houses: ");  //Accept number of vertices
		n = sc.nextInt();
		System.out.print("Enter number of Lanes: ");  //Accept number of Lanes
		e = sc.nextInt();

		System.out.print("Press 1 for Directed graph and 2 for Undirected");
		int dir = sc.nextInt();
		switch(dir){
		case 1:{   //Directed
			for (int i=0;i<e;i++) {         //For every lane
				System.out.print("Enter Houses at both the ends of the lane\n"
						+ "1st House number: ");
				int u = sc.nextInt();                              //Accept (u,v)
				System.out.print("2nd House number: ");
				int v = sc.nextInt();
				insert(u,v);
			}
			break;
		}
		case 2:{    //Undirected
			for (int i=0;i<e;i++) {         //For every lane
				System.out.print("Enter Houses at both the ends of the lane\n"
						+ "1st House number: ");
				int u = sc.nextInt();                              //Accept (u,v)
				System.out.print("2nd House number: ");
				int v = sc.nextInt();
				insert(u,v);
				insert(v,u);
			}
			break;
		}
		default:
		}
	}

	void displayAdjList(){
		for(int i=1;i<=n;i++){
			Node curr=head[i];
			System.out.print(i+" ");
			while(curr!=null){
				System.out.print(" -> "+curr.data);
				curr=curr.next;
			}
			System.out.println();
		}
	}

	void bfs(){			//Breadth First Search	-	Queue	-	List
	}

	void dfs(){         //Depth First Search	-	Stack	-	Matrix

	}

	public class Main{
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			graph g = new graph();
			int cnt;
			do{
				System.out.print("1. Adjacent Matrix\n2. Adjacency List"
						+ "\nSELECT OPERATIONS: ");
				int select = sc.nextInt();
				switch(select){
				case 1:{
					g.createUsingAdjMat();
					g.displayAdjMat();
					g.dfs();
					break;
				}
				case 2:{
					g.createUsingAdjList();
					g.displayAdjList();
					g.bfs();
					break;
				}
				default:{
					System.out.println("Enter Valid Option");
				}
				}
				System.out.print("Press 1 to continue and any number to exit: ");
				cnt = sc.nextInt();
				if(cnt!=1){
					System.out.println("Thank you");
				}
			}while(cnt==1);
		}
	}
}
