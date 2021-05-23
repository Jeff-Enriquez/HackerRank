import java.util.*;
public class JumpingOnTheClouds {

    public static void main(String args[]){

        printTest(
            "Solution 1", 
            solution1(Arrays.asList(0,0,1,0,0,1,0)), 
            4 // <- this is the expected result
        );

    }

    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(n)
    public static int solution1(List<Integer> clouds){

        /* 
            The first position of the clouds is 0
            We start on position 0
        */
        int position = 0;

        int cloudHopCount = 0;
        
        // Loop until we get to the last cloud
        while(position < clouds.size() - 1){ 

            try {

                /* Can we hop two spaces?
                    If we are on the second to last cloud this will throw IndexOutOfBoundsException. Thus, we only have one more space to move. 
                */
                if(clouds.get(position + 2) == 0){
                    cloudHopCount++;
                    position += 2;
                } 

                // If we can't hop two spaces we know we can hop 1
                else {
                    cloudHopCount++;
                    position++;
                }

            }

            // If error is thrown we only have one cloud left.
            catch(IndexOutOfBoundsException e) {
                cloudHopCount++;
                position++;
            }

        }

        return cloudHopCount;

    }

    public static void printTest(String solution, long result, long expected) {
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }

}
