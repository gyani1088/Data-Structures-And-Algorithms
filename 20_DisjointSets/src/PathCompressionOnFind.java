import java.util.Arrays;
import java.util.stream.Collectors;

public class PathCompressionOnFind {
    public static int N = 5;
    public static int[] parent = new int[N];

    public static void main(String[] args) {
        initialize();
        System.out.println("parent="+ Arrays.stream(parent).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        union(2,3);
        System.out.println("parent="+ Arrays.stream(parent).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        union(1,2);
        System.out.println("parent="+ Arrays.stream(parent).mapToObj(a->a+"").collect(Collectors.joining(" ")));
        union(0,1);
        System.out.println("parent="+ Arrays.stream(parent).mapToObj(a->a+"").collect(Collectors.joining(" ")));
    }
    public static void initialize(){
        for(int i=0;i<N;i++){
            parent[i] = i;
        }
    }

    //Optimization on find operation
    public static int find(int x){
        if (parent[x]==x) return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y){
        int xRep = find(x);
        int yRep = find(y);
        if(xRep==yRep) return;
        parent[yRep] = xRep;
    }
}
