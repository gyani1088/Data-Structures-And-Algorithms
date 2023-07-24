public class SubsequenceOfAnotherString {
    public static void main(String[] args) {
        System.out.println(isSubsequence("Apple","Ape"));
        System.out.println(isSubsequence("Apple","Apel"));
    }
    private static boolean isSubsequence(String s1, String s2){
        for(int i=0,j=0; i<s1.length() && j<s2.length();i++){
            if(s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            if(j==s2.length()) return true;
        }
        return false;
    }
}
