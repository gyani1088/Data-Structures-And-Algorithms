import java.util.ArrayList;

public class LowerCommonAncestor {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(80);

        Node lca = findLCA(root,50,40);
        System.out.println(lca!=null?lca.key:null);
        lca = findLCA(root,90,100);
        System.out.println(lca!=null?lca.key:null);
        lca = findLCA(root,20,70);
        System.out.println(lca!=null?lca.key:null);
        Node lca2 = lca2(root,20,70);
        System.out.println(lca2.key);

    }
    public static boolean findPath(Node root, ArrayList<Node> p, int n){
        if(root==null) return false;
        p.add(root);
        if(root.key==n) return true;
        if(findPath(root.left,p,n) || findPath(root.right,p,n)) return true;
        //if the last element is not equal to n, remove the element and go for the other path,
        // until we find the key or the arraylist exhausts to an empty array after traversing all
        // the node(i.e the key is not found);
        p.remove(p.size()-1);
        return false;
    }

    public static Node findLCA(Node node, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if(findPath(node,path1,n1)==false || findPath(node,path2,n2)==false){
            return null;
        }
        System.out.println("Path1:"+path1+"\nPath2:"+path2);
        for(int i=0;i<path1.size()-1 && i<path2.size()-1;i++){
            if(path1.get(i+1)!=(path2.get(i+1)))
                return path1.get(i);
            if(i+1==Math.min(path1.size()-1,path2.size()-1) && path1.get(i+1)==(path2.get(i+1))) return path1.get(i+1);
        }
        return null;
    }

    //Efficient method, but one caveat: if any of the target node is not present in the
    //tree, then this method will fail
    public static Node lca2(Node root, int n1, int n2){
        if(root==null) return null;
        if(root.key==n1 || root.key==n2) return root;
        Node leftLca = lca2(root.left,n1,n2);
        Node rightLca = lca2(root.right,n1,n2);
        if(leftLca!=null && rightLca!=null) return root;
        if(leftLca!=null) return leftLca;
        else return rightLca;
    }

}
