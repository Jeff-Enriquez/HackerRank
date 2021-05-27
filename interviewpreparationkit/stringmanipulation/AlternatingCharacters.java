public class AlternatingCharacters {
    public static void main(String[] args){
        printTest(
            "SOLUTION 1", 
            solution1("AAABBBAABB"),
            6 // <- this is the expected result 
        );
        printTest( 
            solution1("AABBAABB"),
            4 // <- this is the expected result 
        );
        printTest( 
            solution1("ABABABAA"),
            1 // <- this is the expected result 
        );
    }

    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(n)
    public static int solution1(String s){
        // Count how many characters need to be deleted to make the strings an anagram
        int deleteCount = 0;

        /*
            i and j are both indexes
            j will always be at least 1 more than i
            We use these indexes to compare the characters in the string
        */
        int i = 0;
        int j = 1;

        /* How this works
            1) Compare the first character of the string at index i to the next character of the string at index j
            2) If the characters are the same
                2.1) Increment the delete count
                2.2) Increment index j so we can compare the character at index i to the next character in the string
            3) If the characters are NOT the same.
                3.1) Set index i equal to j
                3.2) Add 1 to index j
            4) Repeat until the end of the string
        */
        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                j++;
                deleteCount++;
            } else {
                i = j;
                j++;
            }
        }

        return deleteCount;
    }

    public static void printTest(String solution, int result, int expected) {
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }

    public static void printTest(int result, int expected) {
        System.out.print( "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }
}
