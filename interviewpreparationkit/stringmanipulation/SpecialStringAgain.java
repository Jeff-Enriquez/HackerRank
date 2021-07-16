import java.io.*;
import java.nio.file.*;

public class SpecialStringAgain {
    public static void main(String[] args){
        Path filePath = Paths.get(".", "specialString.txt");
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
    // Big O Time Complexity: O(n^2)
    public static int solution1(String specialString){

        // The loop doesn't count the last character so we start with 1
        int count = 1;

        // Loop through the string
        int i = 0;
        while(i < specialString.length()-1){

            // Keep track of the main character
            char mainChar = specialString.charAt(i);

            //Track number of characters left of the exception
            int leftCount = 1;

            // Loop through the rest of the string until it is no longer a special string
            int j = i;
            while(j < specialString.length()-1){

                // If the main character equals the secondary character: increase the count
                if(mainChar == specialString.charAt(++j)){
                    // Add to left count
                    leftCount++;
                    // If we are at the end of the string set i = j to end both loops.
                    if(j == specialString.length()){
                        i = j;
                    }
                } 
                // If the characters do not match we have hit our exception 
                else{
                    // Keep track of how many matching characters there are to the right of the exception
                    int rightCount = 0;
                    // We will start the next iteration at the exception because we know the count to the left of it
                    i = j;
                    final int LEFT_COUNT = leftCount;
                    while(leftCount-- > 0 && j < specialString.length()-1 && mainChar == specialString.charAt(++j)){
                        rightCount++;
                    }
                    count += getCount(LEFT_COUNT, rightCount);
                    break;
                }
            }
        }
        return count;
    }

    // This will give the total combinations of the leftside and add the count of the right side
    private static int getCount(int leftCount, int rightCount){
        int totalCount = 0;
        int sumOfLeft = 0;
        for(int i = 1; i <= leftCount; i++){
            sumOfLeft += i;
        }
        totalCount = sumOfLeft + rightCount;
        return totalCount;
    }
    

    private static void printTest(String solution, long result, long expected){
        System.out.print( "\u001B[33m" +
            solution + "\n" + "\u001B[0m" +
            "Result: " + "\u001B[35m" + result + "\u001B[0m" + " | " +
            "Expected: " + "\u001B[34m" + expected + "\u001B[0m" + "\n"
        );
    }
}
