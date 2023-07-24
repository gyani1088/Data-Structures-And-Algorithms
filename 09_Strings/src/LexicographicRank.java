public class LexicographicRank {
    public static void main(String[] args) {
        System.out.println(calculateLexicographicRank("string"));
        System.out.println(calculateLexicographicRank("baaa"));
    }

    //Erronneous: need to properly solve it
    //works only for words with distinct characters
    public static int calculateLexicographicRank(String str){
        int[] count = new int[256];
        int[] factorials = factorials(str.length());
        int rank=0;
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        //Cumulative sum - to calculate the number of characters before the current character(lexicographically).
        for(int i=1;i<256;i++){
            count[i]+=count[i-1];
        }
        for(int i=0;i<str.length()-1;i++){
            rank = rank + count[str.charAt(i)-1]*factorials[str.length()-i-1];
            for(int j=str.charAt(i);j<256;j++){
                count[j]--;
            }
        }
        return rank+1;
    }
    public static int[] factorials(int n){
        int[] factorialsArray = new int[n+1];
        factorialsArray[0]=1;
        for(int i=1;i<=n;i++){
            factorialsArray[i]=factorialsArray[i-1]*i;
        }
        return factorialsArray;
    }
}

// Word: STRING
// Position: 19-20-18-09-14-07
// Cumulative character rank: