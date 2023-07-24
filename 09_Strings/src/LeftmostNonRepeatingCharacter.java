public class LeftmostNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(solution1("abbca"));
        System.out.println(solution1("abcabc"));
        System.out.println(solution1("apple"));
        System.out.println(efficientSolution("abbca"));
        System.out.println(efficientSolution("abcabc"));
        System.out.println(efficientSolution("apple"));
    }
    //Time complexity: O(n+n)
    //Auxiliary space: 0(256)
    private static int solution1(String inputString){
        int[] charCount = new int[256];
        for(int i=0;i<inputString.length();i++){
            charCount[inputString.charAt(i)]++;
        }
        for(int i=0;i<inputString.length();i++){
            if(charCount[inputString.charAt(i)]==1) return i;
        }
        return -1;
    }

    //Time complexity: O(n+256)
    //Auxiliary space: O(256)
    private static int efficientSolution(String inputString){
        int[] charIndex = new int[256];
        for(int i=0;i<charIndex.length;i++){
            charIndex[i]=-1;
        }
        for(int i=0;i<inputString.length();i++){
            if(charIndex[inputString.charAt(i)]>=0) charIndex[inputString.charAt(i)]=-2;
            else charIndex[inputString.charAt(i)]=i;
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<256;i++){
            if(charIndex[i]>=0) res=Math.min(res,charIndex[i]);
        }
        return (res==Integer.MAX_VALUE)?-1:res;
    }
}


// abbca
