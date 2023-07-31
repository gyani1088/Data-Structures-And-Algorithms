import java.util.ArrayList;

public class SerializationDeserialization {
    private static final int EMPTY = -1;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
        root.left.right.left.right = new Node(80);

        ArrayList<Integer> arr = new ArrayList<>();
        serialize(root,arr);
        System.out.println(arr);

        Node node = deserialize(arr);
        TreeTraversal.preOrderTraversal(node);
        index=0;
    }

    //SERIALIZATION
    public static void serialize(Node root, ArrayList<Integer> arr){
        if(root==null){
            arr.add(EMPTY);
            return;
        }
        arr.add(root.key);
        serialize(root.left,arr);
        serialize(root.right,arr);
    }

    //DESERIALIZATION
    private static int index =0;
    public static Node deserialize(ArrayList<Integer> arr){
        if(index==arr.size()) return null;
        int val = arr.get(index);
        index++;
        if(val==EMPTY) return null;
        Node root = new Node(val);
        root.left = deserialize(arr);
        root.right = deserialize(arr);
        return root;
    }
}
