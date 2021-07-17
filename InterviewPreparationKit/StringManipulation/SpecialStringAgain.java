import java.io.*;
import java.nio.file.*;

public class SpecialStringAgain {
    public static void main(String[] args){
        Path filePath = Paths.get(".", "SpecialString.txt");
        String specialString = "";
        try{
            specialString = Files.readString(filePath);
        } catch(IOException e){
            e.printStackTrace();
        }
        printTest(
            "SOLUTION 1", 
            solution1("abcbaba"),
            10 // <- this is the expected result 
        );
        printTest(
            "SOLUTION 2", 
            solution1(specialString),
            1272919);
    }   

    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(n)
    public static int solution1(String specialString){
        
        // Keep track fo count
        int count = 0;

        // Loop through every letter
        int i = 0;
        while(i < specialString.length()){
            int repeat = 1;
            // If the letters match increment repeat count
            while(i < specialString.length()-1 && specialString.charAt(i) == specialString.charAt(i+1)){
                repeat++;
                i++;
            }
            i++;

            // Count the combinations of the repeating letters
            count += (repeat * repeat + repeat) / 2;

            int pointer = 1;
            // Check for all special combinations
            while(i-pointer >= 0 && i+pointer < specialString.length() 
            && specialString.charAt(i-1) == specialString.charAt(i+pointer)
            && specialString.charAt(i-1) == specialString.charAt(i-pointer)){
                count++;
                pointer++;
            }
        }

        return count;
    }

    private static void printTest(String solution, long result, long expected){
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }
}
