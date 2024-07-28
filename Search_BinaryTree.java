package Tree;

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }
}

class BinaryTree {
    Node root, ptr;

    public BinaryTree() {
        this.root = null;
    }

    void create() {
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        do {
            System.out.print("Enter node value: ");
            int data = sc.nextInt();
            Node new_node = new Node(data);
            if (root == null) {
                root = new_node;
                System.out.println("Root = " + root.data);
            } else {
                ptr = root;
                while (ptr != null) {
                    sc.nextLine();
                    System.out.println("Where do you want to place the new data\n"
                            + "Press (l) for left side and (r) for right: ");
                    char side = sc.next().charAt(0);
                    if (side == 'l') {
                        if (ptr.left == null) {
                            ptr.left = new_node;
                            System.out.println("New data: " + new_node.data);
                            break;
                        } else {
                            ptr = ptr.left;
                        }
                    } else if (side == 'r') {
                        if (ptr.right == null) {
                            ptr.right = new_node;
                            System.out.println("New data: " + new_node.data);
                            break;
                        } else {
                            ptr = ptr.right;
                        }
                    } else {
                        System.out.println("Enter valid input!");
                    }
                }
            }
            System.out.print("\nPress 1 to add another value and 0 to exit: ");
            cnt = sc.nextInt();
            if (cnt == 0) {
                break;
            }
        } while (cnt == 1);
    }

    void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    void bfsTraversal() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.create();

        System.out.println("\nInorder Traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorderTraversal(tree.root);

        System.out.println("\nBFS Traversal:");
        tree.bfsTraversal();
    }
}
