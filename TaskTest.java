/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("Implement Feature", "Details about the feature", "Alice Smith", 5, "In Progress");
    }

    @Test
    public void testCreateTaskID() {
        String expectedID = "Im:0:Ali"; // "Im" from "Implement Feature", "0" is the task number, "Ali" from "Alice Smith"
        assertEquals(expectedID, task.createTaskID());
    }

    @Test
    public void testPrintTaskDetails() {
        String expectedDetails = "Task Status: In Progress\n" +
                "Developer Details: Alice Smith\n" +
                "Task Number: 0\n" +
                "Task Name: Implement Feature\n" +
                "Task Description: Details about the feature\n" +
                "Task ID: " + task.createTaskID() + "\n" +
                "Duration: 5 hours";
        
        assertEquals(expectedDetails, task.printTaskDetails().trim());
    }

    @Test
    public void testReturnTotalHours() {
        new Task("Task 1", "Description 1", "Dev 1", 3, "Open");
        new Task("Task 2", "Description 2", "Dev 2", 4, "Completed");
        
        // Total should be 3 + 4 + 5 (the one created in setUp)
        assertEquals(12, Task.returnTotalHours());
    }

    @Test
    public void testTaskInitialization() {
        assertEquals("Implement Feature", task.taskName);
        assertEquals("Details about the feature", task.taskDescription);
        assertEquals("Alice Smith", task.developerDetails);
        assertEquals(5, task.taskDuration);
        assertEquals("In Progress", task.taskStatus);
        assertEquals(0, task.taskNumber); // first task, so task number should be 0
    }
}
