public class PatternAnagramInAText {
    public static void main(String[] args) {
        System.out.println(isAnagramPresentInText("geeksforgeeks","frog"));
        System.out.println(isAnagramPresentInText("railway","wire"));
    }
    public static boolean isAnagramPresentInText(String str,String pattern){
        int[] charFrequencyArray = new int[256];
        for(int i=0;i<str.length();i++){
            charFrequencyArray[str.charAt(i)]++;
        }
        for(int i=0;i<pattern.length();i++){
            if(--charFrequencyArray[pattern.charAt(i)]<0) return false;
        }
        return true;
    }
}
