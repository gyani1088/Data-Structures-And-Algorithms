public class PrintNodeAtDistanceK {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(80);

        print(root,0);
        System.out.println();
        print(root,1);
        System.out.println();
        print(root,2);
        System.out.println();
        print(root,3);
        System.out.println();
        print(root,4);
    }

    public static void print(Node root,int k){
        if(root==null) return;
        if(k==0){
            System.out.print(root.key+" ");
        }
        else {
            print(root.left, k - 1);
            print(root.right, k - 1);
        }
    }
}
