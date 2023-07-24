import java.util.ArrayList;
import java.util.List;

//uses Hash function of the window in consideration to match the hash of the pattern requested
public class RabinKarpStringSearchingAlgo {
    public static void main(String[] args) {
        System.out.println(matchPatternImprovedHash("abcdabcdabc","abc"));
    }
    public static List<Integer> matchPatternImprovedHash(String inputString, String pattern){
        List<Integer> indices = new ArrayList<>();
        int d = pattern.length();
        int n = inputString.length();
        int m = pattern.length();
        int hash = 0;
        int localHash = 0;
        for(int i=0;i<m;i++){
            hash += ((char) pattern.charAt(i)%96)*((int)Math.pow(d,m-i-1));
            localHash += ((char) inputString.charAt(i)%96)*((int)Math.pow(d,m-i-1));
        }
        if(hash==localHash) System.out.print("0"+" ");
        for(int i=1;i<=n-m;i++){
            int hashLastChar = ((char) inputString.charAt(i+m-1)%96);
            int hashFirstChar = ((char) inputString.charAt(i-1)%96)*((int)Math.pow(d,m-1));
            localHash = localHash * d
                    - d * hashFirstChar
                    + hashLastChar;

            if(hash==localHash){

                indices.add(i);
            }
        }
        return indices;
    }
}

//
// can give spurious hits
//