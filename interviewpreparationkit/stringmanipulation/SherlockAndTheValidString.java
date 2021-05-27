import java.util.*;

public class SherlockAndTheValidString {
    public static void main(String[] args){
        printTest(
            "SOLUTION 1", 
            solution1("aabbcd"),
            "NO" // <- this is the expected result 
        );
        printTest( 
            solution1("aabbccddeefghi"),
            "NO" // <- this is the expected result 
        );
        printTest( 
            solution1("abcdefghhgfedecba"),
            "YES" // <- this is the expected result 
        );
    }

    // Big O Space Complexity: O(n)
    // Big O Time Complexity: O(nlogn)
    public static String solution1(String s){
        // Save the count for all characters in the string
        Map<Character, Integer> map = new HashMap<>();

        // Get the count for all characters in the string
        for(char chr : s.toCharArray()){
            if(!map.containsKey(chr)){
                map.put(chr, 0);
            }
            Integer prevValue = map.get(chr);
            map.put(chr, prevValue + 1);
        }

        // Save the values to an array
        List<Integer> values = new ArrayList<>(map.values());

        // Sort the values from smallest to largest
        Collections.sort(values);

        // Get the first value
        Integer firstValue = values.get(0);
        // Get the last value
        Integer lastValue = values.get(values.size()-1);
        // Get the second to last value
        Integer secondLastValue = values.get(values.size()-2);

        /*
            We are only allowed to delete one character to have all the character counts be the same
            Example:
                firstValue = 2
                lastValue = 3
                secondLastValue = 3
            This is why we need the lastValue and secondLastValue
        */
        Integer difference = lastValue - firstValue;
        difference += secondLastValue - firstValue;
        
        if(difference > 1){
            return "NO";
        }
        return "YES";
    }

    private static void printTest(String solution, String result, String expected) {
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }

    private static void printTest(String result, String expected) {
        System.out.print( "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }
}
