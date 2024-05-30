package poe_prog_part2_anzuza;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains a test case for the Task class.
 * The test case is designed to check the total duration of a task.
 */
public class TaskIT {
    
    @Test
    public void testTotalDuration() {
        
        // Array of additional amounts to be added to the task's duration
        double[] additionalAmounts = {10, 12, 55, 11, 1};

        // Initialize the Task object
        Task task1 = null;
        
        // Loop through the additional amounts and update the task's duration
        for (int i = 0; i < 5; i++) {
            // Create a new Task object with the additional amount for each iteration
            task1 = new Task("", null, null, additionalAmounts[i], 1);
        } 

        // The expected total duration after adding all additional amounts
        double expectedTotalHours = 89; 
        
        // Retrieve the actual total duration from the Task object
        double actualTotalHours = task1.getTotalDuration(); 
        
        // Assert that the expected total duration matches the actual total duration
        assertEquals(expectedTotalHours, actualTotalHours, 0);
    }
}
