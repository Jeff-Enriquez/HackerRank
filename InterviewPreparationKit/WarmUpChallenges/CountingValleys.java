public class CountingValleys {
    public static void main(String[] args){

        printTest(
            "Solution 1", 
            solution1(12, "DDUUDDUDUUUD"), 
            2 // <- this is the expected result
        );

    }
    
    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(n)
    public static int solution1(int steps, String path){
        // Track the elevation
        int elevation = 0;

        // Count the number of valleys
        int valleyCount = 0;

        for(int i = 0; i < steps; i++) {

            char step = path.charAt(i);

            if(step == 'D') {

                // If the elevation is 0 and we are stepping down we know that is one valley
                if(elevation == 0) {
                    valleyCount++;
                }

                elevation--;

            } else {
                elevation++;
            }

        }

        return valleyCount;

    }

    public static void printTest(String solution, long result, long expected) {
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }

}
