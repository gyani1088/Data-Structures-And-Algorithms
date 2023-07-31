import java.util.LinkedList;
import java.util.Queue;

public class SizeOfTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(80);
        System.out.println(size(root));
        System.out.println(sizeIterative(root));
    }
    public static int size(Node node){
        if (node==null) return 0;
        return 1+size(node.left)+size(node.right);
    }

    public static int sizeIterative(Node node){
        if(node==null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int count = 0;
        while(q.isEmpty()==false){
            Node curr = q.poll();
            count++;
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }
        return count;
    }
}
