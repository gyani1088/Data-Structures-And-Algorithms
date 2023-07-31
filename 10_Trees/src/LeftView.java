import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    private static int maxLevel = 0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(80);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(50);

        printLeftView(root,1);
        System.out.println();
        printLeftView(root);
    }

    //Similar to pre-order traversal with additional comparison of maxLevel to the current level
    //recursive approach
    //Time complexity: O(n)
    public static void printLeftView(Node root,int level){
        if(root==null) return;
        //level= level of the current Node
        if(maxLevel<level){
            System.out.print(root.key+" ");
            maxLevel=level;
        }
        printLeftView(root.left,level+1);
        printLeftView(root.right,level+1);
    }

    //Iterative approach using queues
    //Time complexity: O(n)
    //Auxiliary space: O(w) where w=max width of the tree i.e n/2
    public static void printLeftView(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.isEmpty()==false){
            int count = q.size();
            for(int i=0;i<count;i++){
                Node curr = q.poll();
                if(i==0) System.out.print(curr.key+" ");
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
}
