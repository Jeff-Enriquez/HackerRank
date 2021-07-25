import java.util.*;
class TwoStrings {
    public static void main(String[] args){
        printTest(
            "SOLUTION 1.1", 
            solution1("hello","world"), 
            "YES"
        );
        printTest(
            "SOLUTION 1.2", 
            solution1("hi", "world"), 
            "NO"
        );
    }

    public static String solution1(String s1, String s2) {
        String isSubstring = "NO";
        Set<Character> letters = new HashSet<>();
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            letters.add(c);
        }
        for(int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(letters.contains(c)){
                isSubstring = "YES";
                break;
            }
        }
        return isSubstring;
    }

    public static void printTest(String solution, String result, String expected) {
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }
}