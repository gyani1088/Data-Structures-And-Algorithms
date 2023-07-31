import java.util.Stack;

public class TreeTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);

        System.out.println("==IN-ORDER-TRAVERSAL==");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("==PRE-ORDER-TRAVERSAL==");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("==POST-ORDER-TRAVERSAL==");
        postOrderTraversal(root);
        System.out.println();
        System.out.println("==IN-ORDER-TRAVERSAL(iterative)==");
        iterativeInOrderTraversal(root);
        System.out.println("==PRE-ORDER-TRAVERSAL(iterative)==");
        iterativePreOrderTraversal(root);
        System.out.println("==PRE-ORDER-TRAVERSAL(iterative and Space-Optimised)==");
        iterativePreOrderTraversal(root); 
    }
    //LEFT-ROOT-RIGHT
    public static void inOrderTraversal(Node node){
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.key+" ");
        inOrderTraversal(node.right);
    }
    //ROOT-LEFT-RIGHT
    public static void preOrderTraversal(Node node){
        if (node == null) return;
        System.out.print(node.key+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    //LEFT-RIGHT-ROOT
    public static void postOrderTraversal(Node node){
        if (node == null) return;
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
        System.out.print(node.key+" ");
    }

    //Time complexity:O(n)
    //Aux space: O(h)
    public static void iterativeInOrderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr!=null || stack.isEmpty()==false){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            System.out.print(curr.key+" ");
            curr=curr.right;
        }
        System.out.println();
    }

    //Time complexity:o(n)
    //Aux space:O(n)
    public static void iterativePreOrderTraversal(Node root){
        if(root==null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(stack.isEmpty()==false){
            Node curr = stack.pop();
            System.out.print(curr.key+" ");
            if (curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left);
        }
        System.out.println();
    }

    //Efficient solution
    //Time complexity:o(n)
    //Aux space:O(n)
    public static void iterativePreOrderTraversalEfficient(Node root){
        if(root==null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node curr=root;
        while(stack.isEmpty()==false){
            while(curr!=null){
                System.out.print(curr.key+" ");
                if (curr.right!=null) stack.push(curr.right);
                curr=curr.left;
            }
            curr = stack.pop();
        }
        System.out.println();
    }
}
