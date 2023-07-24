import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(findLongestSubstring("aacda"));
        System.out.println(findLongestSubstringAlternateSolution("abbcaacda"));
    }

    public static int findLongestSubstring(String str) {
        Set<Character> letters = new HashSet<>();
        int lastIndex = -1;
        int length = 0;
        letters.add(str.charAt(0));
        for (int i = 0; i < str.length(); i++) {
            if (letters.contains(str.charAt(i)) && lastIndex < str.substring(lastIndex + 1, i).lastIndexOf(str.charAt(i))) {
                length = i - lastIndex;
                lastIndex = str.substring(lastIndex + 1, i).lastIndexOf(str.charAt(i)) + 1;
            }
            letters.add(str.charAt(i));
        }
        return length;
    }

    public static int findLongestSubstringAlternateSolution(String str) {
        int[] prev = new int[256];
        Arrays.fill(prev, -1);
        int j = -1, res = 0;
        for (int i = 0; i < str.length(); i++) {
            j = Math.max(j, prev[str.charAt(i)] + 1);//002225558
            int maxEnd = i - j + 1; //correct
            res = Math.max(res, maxEnd); //correct
            //System.out.print("("+j+":"+res+","+prev['a']+","+prev['b']+"),");
            prev[str.charAt(i)] = i;

        }
        return res;
    }
}

// abbcaacda
//res:121231231
//j:002225558
//