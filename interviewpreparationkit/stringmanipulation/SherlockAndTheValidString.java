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
        final Integer firstValue = values.get(0);
        // Get the last value
        final Integer lastValue = values.get(values.size()-1);

        if(firstValue.intValue() == 1 && !firstValue.equals(lastValue)){
            try {
                Integer secondLastValue = values.get(values.size()-2);
                return secondLastValue.equals(lastValue) ? "YES" : "NO";
            } catch(IndexOutOfBoundsException e){
                return lastValue - firstValue <= 1 ? "YES" : "NO";
            }
        }
        if(!firstValue.equals(lastValue)){
            if(lastValue - firstValue > 1){
                return "NO";
            }
            try {
                Integer secondLastValue = values.get(values.size()-2);
                return secondLastValue.equals(firstValue) ? "YES" : "NO";
            } catch(IndexOutOfBoundsException e){
                return "YES";
            }
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
