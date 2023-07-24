import java.util.List;

public class KMPStringMatching {
    public static void main(String[] args) {
        patternMatching("abcabcaa","bca");
    }

    //Time complexity:
    private static void patternMatching(String str, String pattern){
        List<Integer> LPSArray = LongestProperPrefixSuffixArray.efficientSolution(pattern);
        int N = str.length();
        int M = pattern.length();
        int i=0,j=0;
        while(i<N){
            if(str.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
            if(j==M) {
                System.out.print((i-j)+" ");
                //Matches perfectly and prepares for next character match (i.e) if there are perfect matches
                j=LPSArray.get(j-1);
            }
            else if(i<N && str.charAt(i)!=pattern.charAt(j)){
                if(j==0) i++;
                //Mismatch
                else j=LPSArray.get(j-1); //j reduced by the previous LPSArray value, maximum it reaches 0
            }
        }
    }
}
