import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    public static void main(String[] args) {
        Node root = new Node(10);
        System.out.println(maxWidth(root));
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(80);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(50);

        System.out.println(maxWidth(root));
    }

    //Aux space: O(w)
    public static int maxWidth(Node node){
        if(node==null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int returnValue = 0;
        while(queue.isEmpty()==false){
            int count = queue.size();
            returnValue = Math.max(count,returnValue);
            for(int i=0;i<count;i++){
                Node curr = queue.poll();
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
        return returnValue;
    }
}
