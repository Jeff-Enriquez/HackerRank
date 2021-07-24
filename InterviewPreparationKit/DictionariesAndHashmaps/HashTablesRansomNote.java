import java.util.*;

public class HashTablesRansomNote {

    public static void main(String[] args){
        String mString = "give me one grand today night";
        String nString = "give one grand today";
        List<String> magazine = Arrays.asList(mString.split(" "));
        List<String> note = Arrays.asList(nString.split(" "));

        System.out.print("SOLUTION 1" + "\n" + 
        "Result: ");
        solution1(magazine, note);
        System.out.println("Solution: Yes");

        mString = "two times three is not four";
        nString = "two times two is four";
        magazine = Arrays.asList(mString.split(" "));
        note = Arrays.asList(nString.split(" "));

        System.out.print("SOLUTION 1" + "\n" + 
        "Result: ");
        solution1(magazine, note);
        System.out.println("Solution: No");
    }

    // Big O Space Complexity: O(n)
    // Big O Time Complexity: O(n)
    public static void solution1(List<String> magazine, List<String> note){
        // Keep track of result
        String result = "Yes";
        // Count all the words of the magazine
        Map<String, Integer> mWords = new HashMap<>();
        // Find the count of all the words of the magazine 
        for(int i = 0; i < magazine.size(); i++){
            String word = magazine.get(i);
            // If the magazine word does not exist in the hashmap, add the word
            if(!mWords.containsKey(word)){
                mWords.put(word, 1);
            // If the magazine word does exist in the hashmap, increase the count
            } else {
                mWords.put(word, mWords.get(word) + 1);
            }
        }
        // Check if the words in the note exist in the magazine
        for(int i = 0; i < note.size(); i++){
            String word = note.get(i);
            // If the word does not exist in the magazine, result equals no
            // If the word exists more times in the note than the magazine, result equals no
            if(!mWords.containsKey(word) || mWords.get(word) == 0){
                result = "No";
                break;
            // If the word exists in the magazine, subtract one from the count
            } else {
                mWords.put(word, mWords.get(word) - 1);
            }
        }
        // Return the result
        System.out.println(result);
    }

}
