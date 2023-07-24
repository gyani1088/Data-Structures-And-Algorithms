public class PatternSearching {
    public static void main(String[] args) {
        patternSearchNaive("abcab","ab");
        patternSearchNaiveDistinctPatternLetters("abcabc","abc");
        patternSearchNaiveDistinctPatternLetters("abdacd","abc");
    }

    public static void patternSearchNaive(String text,String pattern){
        int m = text.length();
        int n = pattern.length();
        for(int i=0;i<=m-n;i++){
            int j;
            //check if each character in pattern matches with that of text
            for (j=0;j<n;j++){
                if(pattern.charAt(j)!=text.charAt(i+j)) {
                    break;
                }
            }
            //if all characters match then print the position of the offset index
            if(j==n) System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void patternSearchNaiveDistinctPatternLetters(String text,String pattern){
        int m = text.length();
        int n = pattern.length();
        for(int i=0;i<=m-n;){
            int j;
            for(j=0;j<n;j++){
                if(pattern.charAt(j)!=text.charAt(i+j)) {
                    break;
                }
            }
            if (j==n) System.out.print(i+" ");
            //if pattern has distinct characters and if it matches
            //then upto p characters then we jump by p characters
            //in the text string
            if (j==0) i++;
            else i+=j;
        }
        System.out.println();
    }
}
