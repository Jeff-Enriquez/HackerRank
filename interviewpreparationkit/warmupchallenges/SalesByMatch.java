import java.util.*;

public class SalesByMatch {

    public static void main(String[] args) {
        printTest(
            "SOLUTION 1", 
            solution1(9, Arrays.asList(10,20,20,10,10,30,50,10,20)),
            3 // <- this is the expected result 
            );
    }
    
    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(n)
    public static int solution1(int n, List<Integer> ar) {
        int numOfPairs = 0;
        Set<Integer> pairs = new HashSet<>();
        for(int i = 0; i < n; i++){
            int sock = ar.get(i);
            if(pairs.contains(sock)){
                pairs.remove(sock);
                numOfPairs++;
            } else{
                pairs.add(sock);
            }
        }
        return numOfPairs;
    }

    public static void printTest(String solution, long result, long expected) {
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }
    
}
