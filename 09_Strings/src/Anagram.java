public class Anagram {
    public static void main(String[] args) {
        System.out.println(areAnagram("apple","papel"));
    }

    // auxiliary space: O(charcount) here O(256)
    // time complexity: O(n+charCount)
    private static boolean areAnagram(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        int[] charCount = new int[256];
        for(int i=0;i<s1.length();i++){
            charCount[s1.charAt(i)]++;
            charCount[s2.charAt(i)]--;
        }
        for(int i=0;i<256;i++){
            if(charCount[i]!=0) return false;
        }
        return true;
    }
}
