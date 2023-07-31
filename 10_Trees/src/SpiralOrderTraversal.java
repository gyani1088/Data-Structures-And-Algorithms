import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralOrderTraversal {
    //BFS spirally

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.left = new Node(80);
        root.left.right.left.right = new Node(90);

        traverseSpirally(root);
        method2(root);
    }
    public static void traverseSpirally(Node root){
        if(root==null) return;
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        boolean reverse = false;
        while(queue.isEmpty()==false){
            int count = queue.size();
            for(int i=0;i<count;i++){
                Node curr = queue.poll();
                if(reverse){
                    stack.push(curr.key);
                }
                else System.out.print(curr.key+" ");
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            if(reverse){
                while(stack.isEmpty()==false) System.out.print(stack.pop()+" ");
            }
            reverse=!reverse;
            System.out.println();
        }
    }

    //Efficient
    public static void method2(Node root){
        if(root==null) return;
        Stack<Node> left2Right = new Stack<>();
        Stack<Node> right2Left = new Stack<>();
        left2Right.push(root);
        boolean l2r = true;
        while(!(left2Right.isEmpty() && right2Left.isEmpty())){
            while(l2r && (!left2Right.isEmpty())){
                Node curr = left2Right.pop();
                System.out.print(curr.key+" ");
                if(curr.left!=null) right2Left.push(curr.left);
                if(curr.right!=null) right2Left.push(curr.right);
            }
            while(!l2r && (!right2Left.isEmpty())){
                Node curr = right2Left.pop();
                System.out.print(curr.key+" ");
                if(curr.right!=null) left2Right.push(curr.right);
                if(curr.left!=null) left2Right.push(curr.left);
            }
            l2r=!l2r;
            System.out.println();
        }
    }
}
