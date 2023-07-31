public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(80);

        System.out.println(height(root));

    }

    //Auxiliary Space: O(height)
    public static int height(Node node){
        if(node==null) return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }
}
