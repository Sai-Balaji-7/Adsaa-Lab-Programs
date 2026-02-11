import java.util.Scanner;

// Node class represents each node of the AVL tree
class Node {
    int data;      
    int h;         
    Node lc;       
    Node rc;       

    // Constructor to initialize node with value
    public Node(int value) {
        this.data = value;
        this.h = 0;        // New node height is 0
        this.lc = null;
        this.rc = null;
    }
}

// Class to construct and manage AVL Tree
class ConstructAvltree {
    Node root;  // Root of AVL Tree

    public ConstructAvltree() {
        root = null;
    }

    // Public insert method
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Returns height of a node
    // If node is null, height is -1
    public int getH(Node node) {
        return node == null ? -1 : node.h;
    }

    // Returns maximum of two integers
    public int max(int a, int b) {
        return a > b ? a : b;
    }

    // Recursive method to insert a value in AVL tree
    public Node insertRec(Node node, int value) {

        // Step 1: Perform normal BST insertion
        if (node == null) {
            return new Node(value);
        }

        // Insert into left subtree
        if (value < node.data) {
            node.lc = insertRec(node.lc, value);

            // Check balance factor
            if (getH(node.lc) - getH(node.rc) == 2) {

                // Left-Left case
                if (value < node.lc.data)
                    node = rotatewithlc(node);

                // Left-Right case
                else
                    node = doublerotatewithlc(node);
            }
        }

        // Insert into right subtree
        else if (value > node.data) {
            node.rc = insertRec(node.rc, value);

            // Check balance factor
            if (getH(node.rc) - getH(node.lc) == 2) {

                // Right-Right case
                if (value > node.rc.data)
                    node = rotatewithrc(node);

                // Right-Left case
                else
                    node = doublerotatewithrc(node);
            }
        }

        // Step 2: Update height of current node
        node.h = max(getH(node.lc), getH(node.rc)) + 1;

        return node;
    }

    // Right Rotation (LL case)
    public Node rotatewithlc(Node k2) {
        Node k1 = k2.lc;

        // Perform rotation
        k2.lc = k1.rc;
        k1.rc = k2;

        // Update heights
        k2.h = max(getH(k2.lc), getH(k2.rc)) + 1;
        k1.h = max(getH(k1.lc), getH(k1.rc)) + 1;

        return k1; // New root after rotation
    }

    // Left Rotation (RR case)
    public Node rotatewithrc(Node k1) {
        Node k2 = k1.rc;

        // Perform rotation
        k1.rc = k2.lc;
        k2.lc = k1;

        // Update heights
        k1.h = max(getH(k1.lc), getH(k1.rc)) + 1;
        k2.h = max(getH(k2.lc), getH(k2.rc)) + 1;

        return k2; // New root after rotation
    }

    // Left-Right Rotation (LR case)
    public Node doublerotatewithlc(Node k3) {
        k3.lc = rotatewithrc(k3.lc);
        return rotatewithlc(k3);
    }

    // Right-Left Rotation (RL case)
    public Node doublerotatewithrc(Node k1) {
        k1.rc = rotatewithlc(k1.rc);
        return rotatewithrc(k1);
    }

    // Public inorder traversal
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    // Inorder traversal (Left → Root → Right)
    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.lc);
            System.out.print(node.data + " ");
            inorderTraversal(node.rc);
        }
    }

    // Public search method
    public void search(int key) {
        Node n = search(root, key);

        if (n == null)
            System.out.println("Key not found");
        else
            System.out.println("Key found");
    }

    // Recursive search method
    public Node search(Node node, int key) {

        // If node is null or key found
        if (node == null || node.data == key)
            return node;

        // Search left subtree
        if (key < node.data)
            return search(node.lc, key);

        // Search right subtree
        return search(node.rc, key);
    }
}

// Main class
public class Avltree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ConstructAvltree avlTree = new ConstructAvltree();

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            avlTree.insert(value);
        }

        System.out.println("Inorder traversal:");
        avlTree.inorderTraversal();

        System.out.println("\nEnter element to search:");
        int key = sc.nextInt();
        avlTree.search(key);

        sc.close();
    }
}
