//Sum of the 2 children should be equal to the root value
public class ChildrenSumProperty {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(6);
        root.right.right = new Node(6);

        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(6);
        root2.right.right = new Node(6);

        System.out.println(isChildrenSumPropertyExisting(root));
        System.out.println(isChildrenSumPropertyExisting(root2));
    }
    public static boolean isChildrenSumPropertyExisting(Node node){
        if (node==null) return true;
        //when the node is a leaf
        if (node.left==null && node.right==null) return true;
        int sum = 0;
        int left = (node.left==null)?0:node.left.key;
        int right = (node.right==null)?0:node.right.key;
        sum=left+right;
        return (sum==node.key &&
                isChildrenSumPropertyExisting(node.left) &&
                isChildrenSumPropertyExisting(node.right));
    }
}
