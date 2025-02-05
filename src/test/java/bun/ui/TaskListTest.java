package bun.ui;  //same package as the class being tested

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskListTest {
    @Test
    public void invalidIndexExceptionThrown() {
        try{
            new TaskList().markTask(233);
            fail();
        } catch (InvalidIndexException e) {
            assertEquals("    There is no Task 234 >< You have 0 task(s) now.", e.getMessage());

        }
    }
}
