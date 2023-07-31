import java.util.LinkedList;

public class TreeToDoublyLinkedList {

    private static Node prev = null;
    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(80);

        convert(root);
    }

    //inorder traversal
    public static Node convert(Node root){
        if(root==null) return root;
        Node head = convert(root.left);
        if(prev==null) {head = root;}
        else{
            root.left = prev;
            prev.right = root;
        }
        prev=root;
        convert(root.right);
        return head;
    }
}