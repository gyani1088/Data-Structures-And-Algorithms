//A tree is said to be balanced if the left subtree and the right subtree height differ by a maximum of 1 level
public class BalancedTree {
    public static void main(String[] args) {
        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(6);
        root2.right.right = new Node(6);

        System.out.println(checkForBalancedTree(root2));
        System.out.println(checkForBalancedTreeEfficient(root2)!=-1);

        root2.right.right.right = new Node(6);
        System.out.println(checkForBalancedTree(root2));

        System.out.println(checkForBalancedTreeEfficient(root2)!=-1);

    }

    //Recursive Approach
    //Naive soln O(n2) time complexity
    public static boolean checkForBalancedTree(Node root){
        if (root==null) return true;
        int lh = HeightOfBinaryTree.height(root.left);
        int rh = HeightOfBinaryTree.height(root.right);
        return (Math.abs(lh-rh)<=1 &&
                checkForBalancedTree(root.left) &&
                checkForBalancedTree(root.right));
    }

    //Efficient Solution
    //O(n) time complexity we check for height =-1 each time we recurse, if so we stop the flow and return -1(false)
    public static int checkForBalancedTreeEfficient(Node root){
        if(root==null) return 0;
        int lh = checkForBalancedTreeEfficient(root.left);
        if(lh==-1) return -1;
        int rh = checkForBalancedTreeEfficient(root.right);
        if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh,rh)+1;

    }
}
