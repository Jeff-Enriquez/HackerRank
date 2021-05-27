import java.util.*;

public class MakingAnagrams {

    public static void main(String[] args){

        printTest(
            "SOLUTION 1", 
            solution1("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"),
            30 // <- this is the expected result 
        );

        printTest(
            "SOLUTION 2", 
            solution2("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"),
            30 // <- this is the expected result 
        );

        printTest(
            "SOLUTION 3", 
            solution3("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"),
            30 // <- this is the expected result 
        );

    }   

    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(n^2)
    public static int solution1(String a, String b){

        // Count how many characters need to be deleted to make the strings an anagram
        int deleteCount = 0;

        // Iterate through every character of string a
        for(int i = 0; i < a.length(); i++){
            
            char aChar = a.charAt(i);

            boolean isMatch = false;

            // Iterate through every character of string b
            for(int j = 0; j < b.length(); j++){

                char bChar = b.charAt(j);

                if(aChar == bChar){
                    // Remove bChar from b string
                    b = b.substring(0, j) + b.substring(j+1);
                    
                    isMatch = true;

                    break;
                }

            }

            // aChar does not exist in string b
            if(!isMatch){
                deleteCount++;
            }

        }
        
        // We have deleted all characters from string b that match string a
        // Any remaining characters need to be added to our delete count
        deleteCount += b.length();

        return deleteCount;
    }

    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(nlogn)
    public static int solution2(String a, String b){

        // Count how many characters need to be deleted to make the strings an anagram
        int deleteCount = 0;

        // Sort String a
        a = sortString(a);

        // Sort String b
        b = sortString(b);

        // Keep track of the index for both strings
        int aIdx = 0;
        int bIdx = 0;

        // Loop through each string while the index is less than the length of the string
        while(aIdx < a.length() && bIdx < b.length()){

            char aChar = a.charAt(aIdx);
            char bChar = b.charAt(bIdx);

            // If the characters are a match, check the next characters
            if(aChar == bChar){
                aIdx++;
                bIdx++;
                continue;
            } 
            // Increase the index
            else if(aChar < bChar){
                aIdx++;
            } else {
                bIdx++;
            }
            // We didn't have a match so we increase the delete count
            deleteCount++;
        }
        // If there is any remaining characters we did not check we have to add that to the delete count
        if(aIdx < a.length()){
            deleteCount += a.length() - aIdx;
        }
        if(bIdx < b.length()){
            deleteCount += b.length() - bIdx;
        }

        return deleteCount;
    }

    // Big O Space Complexity: O(n)
    // Big O Time Complexity: O(n)
    public static int solution3(String a, String b){

        // Count how many characters need to be deleted to make the strings an anagram
        int deleteCount = 0;

        // Keep track of the count of all characters from both strings
        Map<Character, Integer> characterMap = new HashMap<>();

        // Add 1 for every character in string a
        for(int i = 0; i < a.length(); i++){
            Character aChar = a.charAt(i);
            if(!characterMap.containsKey(aChar)){
                characterMap.put(aChar, 0);
            }
            int prevValue = characterMap.get(aChar);
            characterMap.put(aChar, prevValue + 1);
        }

        // Subtract 1 for every character in string b
        for(int i = 0; i < b.length(); i++){
            Character bChar = b.charAt(i);
            if(!characterMap.containsKey(bChar)){
                characterMap.put(bChar, 0);
            }
            int prevValue = characterMap.get(bChar);
            characterMap.put(bChar, prevValue - 1);
        }

        // If the strings are an anagram than all the values will be 0
        // Otherwise the value will be either a positive or negative number
        for(Integer value : characterMap.values()){
            deleteCount += Math.abs(value);
        }

        return deleteCount;

    }

    private static String sortString(String str){
        // convert input string to char array
        char chars[] = str.toCharArray();
                
        // sort tempArray
        Arrays.sort(chars);
        
        // return new sorted string
        return new String(chars);
    }

    public static void printTest(String solution, long result, long expected) {
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }
}
