import java.util.ArrayList;
import java.util.List;

//KMP Algorithm
public class LongestProperPrefixSuffixArray {
    public static void main(String[] args) {
            System.out.println(generateProperPrefixSuffixArray("ababa"));
        System.out.println(efficientSolution("aabcabaabaabca"));

    }
    private static List<Integer> generateProperPrefixSuffixArray(String inputString){
        List<Integer> returnList = new ArrayList<>();
        for(int i=0;i<inputString.length();i++){
            returnList.add(matchSuffixAndPrefix(inputString.substring(0,i+1)));
        }
        return returnList;
    }
    private static int matchSuffixAndPrefix(String inputString){
        for(int len=inputString.length()-1;len>0;len--){
            boolean flag=true;
            for(int i=0;i<len;i++){
                if(inputString.charAt(i)!=inputString.charAt(i+inputString.length()-len)) flag = false;
            }
            if(flag==true) return len;

        }
        return 0;
    }


    //Efficient Solution: O(n)
    public static List<Integer> efficientSolution(String inputString){
        List<Integer> returnList = new ArrayList<>();
        int i=0;
        int len=0;
        while(i<inputString.length()){
            if(i==0){
                returnList.add(0);
                i++;
            }
            if(inputString.charAt(i)==inputString.charAt(len)){
                len++;
                i++;
                returnList.add(len);
            }
            else{
                if(len==0){
                    returnList.add(len);
                    i++;
                }
                else len=returnList.get(len-1);
            }
        }
        return returnList;
    }
}

// ababa - [0,0,1-a,2-ab,3-aba]
// ababc - [0,0,1-a,2-ab,0]
// cabba - [0,0,0,0,0]
