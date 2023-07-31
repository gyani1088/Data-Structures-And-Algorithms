public class CountNodes {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(55);
        root.right.right = new Node(60);
        root.left.left.left = new Node(70);
        root.left.left.right = new Node(80);
        root.left.right.left = new Node(90);

        System.out.println(countNodes(root));
        System.out.println(countNodes2(root));
    }
    //Count nodes in a complete binary tree
    //A complete binary tree is a tree in which the last nodes are filled from left
    //to right and from top to bottom( only the last level is allowed to be partially
    //filled

    //General method
    //Time complexity : O(n)
    public static int countNodes(Node node){
        if (node==null) return 0;
        return 1+countNodes(node.left)+countNodes(node.right);
    }

    //Efficient solution
    //Time complexity: O(log n * log n)
    public static int countNodes2(Node node){
        if (node==null) return 0;
        Node curr = node;
        int lh=0,rh=0;
        while(curr!=null){
                curr=curr.left;
                lh++;
        }
        curr=node;
        while(curr!=null){
            curr=curr.right;
            rh++;
        }
        if(lh==rh) return (int) Math.pow(2,lh)-1;
        return 1+countNodes2(node.left)+countNodes2(node.right);
    }
}
