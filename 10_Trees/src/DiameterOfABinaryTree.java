public class DiameterOfABinaryTree {
    private static int diameter = 0;

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

        System.out.println(diameter(root));
        height2(root);
        System.out.println(diameter);
    }
    public static int height (Node root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    //Time complexity: O(n2)
    public static int diameter(Node root){
        if (root==null) return 0;
        int d1 = 1+ height(root.left)+ height(root.right);
        int d2 = diameter(root.left);
        int d3 = diameter(root.right);
        return Math.max(d1,Math.max(d2,d3));
    }

    //Efficient Solution
    //Time complexity: O(n)
    public static int height2(Node root){
        if (root==null) return 0;
        int lh = height2(root.left);
        int rh = height2(root.right);
        diameter=Math.max(diameter,1+lh+rh);
        return 1+Math.max(lh,rh);

    }
}
