package hackerrank.interviewpreparationkit.warmupchallenges;

public class JumpingOnTheClouds {
    public static void main(String args[]){

    }
    // Big O Space Complexity: O(1)
    // Big O Time Complexity: O(n)
    public static solution1(List<Integer> clouds){
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
}
