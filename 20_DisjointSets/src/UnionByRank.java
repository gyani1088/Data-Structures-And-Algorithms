import java.util.Arrays;
import java.util.stream.Collectors;

public class UnionByRank {
    public static int N = 5;
    public static int[] parent = new int[N];
    public static int[] rank = new int[N];

    public static void main(String[] args) {
        initialize();
        System.out.println("parent="+ Arrays.stream(parent).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        System.out.println("  rank="+ Arrays.stream(rank).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        union(3,4);
        System.out.println("parent="+ Arrays.stream(parent).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        System.out.println("  rank="+ Arrays.stream(rank).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        union(2,3);
        System.out.println("parent="+ Arrays.stream(parent).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        System.out.println("  rank="+ Arrays.stream(rank).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        union(1,2);
        System.out.println("parent="+ Arrays.stream(parent).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        System.out.println("  rank="+ Arrays.stream(rank).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        union(0,1);
        System.out.println("parent="+ Arrays.stream(parent).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        System.out.println("  rank="+ Arrays.stream(rank).mapToObj(a->a+"").collect(Collectors.joining(" ")));
    }
    public static void initialize(){
        for(int i=0;i<N;i++){
            parent[i] = i;
            rank[i]=0;//height of the tree
        }
    }
    public static int find(int x){
        if (parent[x]==x) return x;
        else return find(parent[x]);
    }

    public static void union(int x, int y){
        int xRep = find(x);
        int yRep = find(y);
        if(xRep==yRep) return;
        if(rank[xRep]<rank[yRep]) parent[xRep]=yRep;
        else if(rank[xRep]>rank[yRep]) parent[yRep]=xRep;
        else{
            parent[yRep] = xRep;
            rank[xRep]++;
        }
    }
}
