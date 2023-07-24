import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseSentence("I am good"));
    }

        public static String reverseWords(String input) {
            // Split the string into individual words
            String[] words = input.split("\\s+");

            // Create a StringBuilder to store the reversed words
            StringBuilder reversed = new StringBuilder();

            // Iterate over the words in reverse order and append them to the StringBuilder
            for (int i = words.length - 1; i >= 0; i--) {
                reversed.append(words[i]);
                if (i > 0) {
                    reversed.append(" ");
                }
            }

            // Convert the StringBuilder back to a string
            return reversed.toString();
        }

        public static String reverseLetters(String inputString){
            StringBuilder output = new StringBuilder();
            for(int i=inputString.length()-1;i>=0;i--){
                output.append(inputString.charAt(i));
            }
            return output.toString();
        }

        public static String reverseSentence(String inputString){
            StringBuilder output = new StringBuilder();
            List<String> words = new ArrayList<>();
            StringBuilder word = new StringBuilder();
            //Split the words delimited by spaces and reverse letters in each words
            for(int i=inputString.length()-1;i>=0;i--){
               if(inputString.charAt(i)==' ') {
                   words.add(word.toString());
                   word = new StringBuilder();
               }
               else word.append(inputString.charAt(i));
            }
            words.add(word.toString());
            //reverse individual words and
            int len = words.size();
            for(int i=0;i<len-1;i++){
                output.append(reverseLetters(words.get(i))+" ");
            }
            output.append(reverseLetters(words.get(len-1)));
            return output.toString();
        }

    }

//
//I am good
//reverse letters ----> I ma doog
//reverse the whole sentence ---> good am I

// I am good
// words = ["doog","ma","I"]
// output = good am I