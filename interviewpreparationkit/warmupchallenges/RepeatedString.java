package hackerrank.interviewpreparationkit.warmupchallenges;

class RepeatedString {
    public static void main(String[] args){
        Print.print(
            "SOLUTION 1",
            solution1("aba", 10), // Expecting: 7
            solution1("a", 1000000000000L) // Expecting: 1000000000000
        );

        Print.print(
            "SOLUTION 2", 
            solution2("aba", 10), // Expecting: 7
            solution2("a", 1000000000000L) // Expecting: 1000000000000
        );
        
    }

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

}