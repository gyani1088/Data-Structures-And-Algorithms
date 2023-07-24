import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LeftmostRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(betterApproach("abccb"));
        System.out.println(efficientApproach("abcccbb"));
        System.out.println(efficientApproach2("abcccbb"));
    }


    private static int betterApproach(String inputString){
        int[] count = new int[256];
        //ASCII value of the character will be used as the index in the count array and every occurrence of
        //the value will increase the value at that index
        for(int i=0;i<inputString.length();i++){
            count[inputString.charAt(i)]++;
        }
        //first character in the input string with count value in the count array greater than 1
        for(int i=0;i<inputString.length();i++){
            if(count[inputString.charAt(i)]>1) return i;
        }
        return -1;
    }

    private static int efficientApproach(String inputString){
        int[] firstOccurrence = new int[256];
        for(int i=0;i<256;i++){
            firstOccurrence[i]=-1;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<inputString.length();i++) {
                int fi = firstOccurrence[inputString.charAt(i)];
                if(fi==-1) firstOccurrence[inputString.charAt(i)]=i;
                else res=Math.min(res,fi);
        }
        return (res==Integer.MAX_VALUE) ? -1:res;
    }

    private static int efficientApproach2(String inputString){
        int res=-1;
        boolean[] visited = new boolean[256];
        for(int i=0;i<256;i++){
            visited[i]=false;
        }
        for(int i=inputString.length()-1;i>=0;i--){
            if(visited[inputString.charAt(i)]) res=i;
            else visited[inputString.charAt(i)]=true;
        }
        return res;
    }
}
