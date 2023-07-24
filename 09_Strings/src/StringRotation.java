public class StringRotation {
    public static void main(String[] args) {
        System.out.println(isRotation("abba","baab"));
        System.out.println(isRotation("baba","aba"));
        System.out.println(isRotation("abcd","cdab"));
    }
    public static boolean isRotation(String str1, String str2){
        if(str1.length()!=str2.length()) return false;
        String temp = str1+str1;
        return (RabinKarpStringSearchingAlgo.matchPatternImprovedHash(temp,str2).size()>0);
    }
}
