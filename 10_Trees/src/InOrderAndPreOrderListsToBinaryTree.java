public class InOrderAndPreOrderListsToBinaryTree {
    private static int preIndex = 0;
    public static void main(String[] args) {
        int[] in = {40,20,60,50,70,10,80,100,30};
        int[] pre = {10,20,40,50,60,70,30,80,100};
        Node root = convert(pre,in,0,in.length-1);
        TreeTraversal.inOrderTraversal(root);
        System.out.println();
        TreeTraversal.preOrderTraversal(root);
    }

    //Time Complexity = O(n2)
    public static Node convert(int[] pre, int[] in, int inStart, int inEnd){
        if(inStart>inEnd) return null;
        Node root = new Node(pre[preIndex++]);
        int inIndex = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==root.key){
                inIndex=i;
                break;
            }
        }
        root.left = convert(pre,in,inStart,inIndex-1);
        root.right = convert(pre,in,inIndex+1,inEnd);
        return root;
    }
}
