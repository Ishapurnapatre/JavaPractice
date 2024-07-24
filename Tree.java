package Tree;
import java.util.*;

class Node{
	int data;
	Node left,right;

	public Node(int data){
		this.left = null;
		this.right = null;
		this.data = data;
	}
}

class BinaryTree{
	Node root,ptr;

	public BinaryTree(){
		this.root = null;
	}

	void create() {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		do{
			System.out.print("Enter node value: ");
			int data = sc.nextInt();
			Node new_node = new Node(data);
			if(root == null) {
				root = new_node;
				System.out.println("Root = "+root.data);
			}
			else {
				ptr = root;
				while(ptr != null) {
					sc.nextLine();
					System.out.println("Where do you want to place the new data\n"
							+ "Press (l) for left side and (r) for right: ");
					char side = sc.next().charAt(0);
					if (side == 'l') {
						if(ptr.left==null) {
							ptr.left = new_node;
							System.out.println("New data: "+new_node.data);
							break;
						}
						else {
							ptr = ptr.left;
						}
					}
					else if (side == 'r') {
						if(ptr.right==null) {
							ptr.right = new_node;
							System.out.println("New data: "+new_node.data);
							break;
						}
						else {
							ptr = ptr.right;
						}
					}
					else {
						System.out.println("Enter valid input!");
					}
				}
			}
			System.out.print("\nPress 1 to add another value and 0 to exit: ");
			cnt = sc.nextInt();
			if(cnt == 0) {
				break;
			}
		}while(cnt == 1);
	}

	void Inorder(Node root){   // L N R
		if(root  != null) {
			Inorder(root.left);
			System.out.print(root.data+" ");
			Inorder(root.right);
		}
	}

	void Inorder() {
		Inorder(root);
	}

	void Preorder(Node root){     // N L R
		if(root != null) {
			System.out.print(root.data+" ");
			Preorder(root.left);
			Preorder(root.right);
		}
	}

	void Preorder() {
		Preorder(root);
	}

	void Postorder(Node root){     // L R N
		if(root != null) {
			Postorder(root.left);
			Postorder(root.right);
			System.out.print(root.data+" ");
		}
	}

	void Postorder() {
		Postorder(root);
	}

	void NonRecursiveIn(){
		if(root==null){
			System.out.println("The tree is empty");
		}
		Stack s = new Stack();
		ptr=root;

		do {
			while(ptr!=null) {
				s.push(ptr);
				ptr=ptr.left;
			}
			if(!s.isEmpty()) {
				ptr=(Node)s.pop();
				System.out.print(ptr.data+" ");
				ptr=ptr.right;
			}
		}while(!s.isEmpty()||ptr!=null);
	}

	void NonRecursivePre(){
		if(root==null){
			System.out.println("The tree is empty");
		}
		Stack s = new Stack();
		ptr=root;

		do {
			while(ptr!=null) {
				System.out.print(ptr.data+" ");
				s.push(ptr);
				ptr=ptr.left;
			}
			if(!s.isEmpty()) {
				ptr=(Node)s.pop();
				ptr=ptr.right;
			}
		}while(!s.isEmpty()||ptr!=null);
	}

	void NonRecursivePost(){		
		if(root==null){
			System.out.println("The tree is empty");
		}
		Stack s1=new Stack();
		Stack s2=new Stack();
		ptr=root;
		s1.push(root);

		while(!s1.isEmpty()){
			ptr = (Node)s1.pop();
			s2.push(ptr.data);
			if(ptr.left!=null) {
				s1.push(ptr.left);
			}
			if(ptr.right!=null) {
				s1.push(ptr.right);
			}
		}
		while(!s2.isEmpty()) {
			System.out.print(s2.pop()+" ");
		}
	}
}

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BinaryTree bt = new BinaryTree();
		System.out.println("----- Welcome -----");
		System.out.println("\nCreate a Binary Tree");
		bt.create();
		System.out.println("--- Binary Tree created succesfully! ---");
		int cnt = 1;
		do{
			System.out.print("\nTraversal Operations: \n1. Inorder\n2. Preorder\n3. Postorder"
					+ "\nSELECT OPERATION: ");
			int select = sc.nextInt();
			switch(select) {
			case 1:{
				System.out.println("\n1. Recursive\n2. Non Recursive");
				int choose = sc.nextInt();
				switch(choose) {
				case 1:bt.Inorder();
				break;
				case 2:bt.NonRecursiveIn();
				break;
				default:System.out.println("Invalid option");
				}
				break;
			}
			case 2:{
				System.out.println("\n1. Recursive\n2. Non Recursive");
				int choose = sc.nextInt();
				switch(choose) {
				case 1:bt.Preorder();
				break;
				case 2:bt.NonRecursivePre();
				break;
				default:System.out.println("Invalid option");
				}
				break;
			}
			case 3:{
				System.out.println("\n1. Recursive\n2. Non Recursive");
				int choose = sc.nextInt();
				switch(choose) {
				case 1:bt.Postorder();
				break;
				case 2:bt.NonRecursivePost();
				break;
				default:System.out.println("Invalid option");
				}
				break;
			}
			default:System.out.println("Invalid option");
			}
			System.out.print("\n\nPress 1 to CONTINUE and any number to EXIT");
			cnt = sc.nextInt();
			if(cnt != 1) {
				System.out.print("----- Thank You -----");
			}
		}while(cnt == 1);
	}
}
