class RepeatedString {

    public static void main(String[] args){

        // First test for solution 1
        printTest(
            "Solution 1.1",
            solution1("aba", 10),
            7 // <- this is the expected result
        );

        // Second test for solution 1
        printTest(
            "SOLUTION 1.2",
            solution1("a", 1000000000000L),
            1000000000000L // <- this is the expected result
        );

        // First test for solution 2
        printTest(
            "Solution 2.1",
            solution2("aba", 10),
            7 // <- this is the expected result
        );

        // Second test for solution 2
        printTest(
            "SOLUTION 2.2",
            solution2("a", 1000000000000L),
            1000000000000L // <- this is the expected result
        );

    }

    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(n)
    public static long solution1(String s, long n) {
        
        // Keep track of how many a's are in the string
        long count = 0;

        if (n < s.length()) {

            // Count the first n characters in the string
            for (int i = 0; i < n; i++) {

                if (s.charAt(i) == 'a') {

                    count++;

                }

            }

        } else {

            // Count every 'a' in the string
            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == 'a') {

                    count++;

                }

            }

            // The number of times the length of the string fits into n
            long times = (long) Math.floor( n / s.length());

            // Update the count
            count *= times;

            // The remaining number of characters to count
            long remainder = n % s.length();
            
            for (int i = 0; i < remainder; i++) {

                if (s.charAt(i) == 'a') {

                    count++;

                }

            }

        }

        return count;

    }

    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(n)
    // Better than solution 1
    public static long solution2(String s, long n) {
        
        // Keep track of how many a's are in the string
        long count = 0;

        // The number of times the length of the string fits into n
        long times = 0;

        // The remaining number of characters to count
        long remainder = n;
        
        if (n > s.length()) {

            times = (long) Math.floor( n / s.length() );

            remainder = n % s.length();

        }
        
        int countFirstPartOfString = 0;

        // Loop through the remaining count
        for (int i = 0; i < remainder; i++) {

            if (s.charAt(i) == 'a') {

                countFirstPartOfString++;

            }

        }
        
        int countSecondPartOfString = 0;

        // Only need to count the rest of the string if times > 0
        if (times > 0) {

            // Loop through the remaining of the string
            for (int i = (int) remainder; i < s.length(); i++) {
                if (s.charAt(i) == 'a') {

                    countSecondPartOfString++;

                }

            }

        }
        
        int totalStringCount = countFirstPartOfString + countSecondPartOfString;

        count += totalStringCount * times;
        
        count += countFirstPartOfString;
        
        return count;

    }

    public static void printTest(String solution, long result, long expected) {
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }
}