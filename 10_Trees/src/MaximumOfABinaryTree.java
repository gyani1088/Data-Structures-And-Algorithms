public class MaximumOfABinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(80);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(50);

        System.out.println(maximum(root));
    }

    //recursive Approach
    //Aux space:O(h)
    //Time complexity: O(n)
    public static int maximum(Node node){
        if(node==null) return Integer.MIN_VALUE;
        else return Math.max(node.key,Math.max(maximum(node.left),maximum(node.right)));
    }

}
