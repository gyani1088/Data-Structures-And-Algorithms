import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal_BFS {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(80);

        print(root);
        System.out.println();
        printLineByLine(root);
        System.out.println();
        printLineByLine2(root);

    }

    //Recursion is not a good idea here
    //Use a queue data structure
    //Time complexity: O(n)
    //Auxiliary Space: O(n)--- O(w) where w -> width of binary tree
    public static void print(Node node){
        if(node==null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(queue.isEmpty()==false){
            Node curr = queue.poll();
            //printing the current level key
            System.out.print(curr.key+" ");
            //enqueing the next level
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }
    }

    //Aux Space: O(w)
    //Time complexity: O(n)
    public static void printLineByLine(Node node){
        if(node==null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while(queue.size()>1){
            Node curr = queue.poll();
            if(curr==null){
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(curr.key+" ");
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }
    }

    public static void printLineByLine2(Node node){
        if(node==null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(queue.isEmpty()==false){
            int count = queue.size();
            for(int i=0;i<count;i++){
                Node curr = queue.poll();
                System.out.print(curr.key+" ");
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            System.out.println();
        }
    }
}

