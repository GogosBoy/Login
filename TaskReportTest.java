/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskReportTest {

private TaskReport taskReport;

@BeforeEach
public void setup() {
// Initialize TaskReport with capacity for 10 tasks
taskReport = new TaskReport(10);

// Populate arrays with test data
taskReport.addTask("Mike Smith", "Create Login", 5, "To Do");
taskReport.addTask("Edward Harrison", "Create Add Features", 8, "Doing");
taskReport.addTask("Samantha Paulson", "Create Reports", 2, "Done");
taskReport.addTask("Glenda Oberholzer", "Add Arrays", 11, "To Do");
}

@Test
public void testArrayPopulation() {
// Check that the task count matches the number of added tasks
assertEquals(4, taskReport.getTaskCount());

// Verify that task names were added correctly
assertArrayEquals(new String[]{"Create Login", "Create Add Features", "Create Reports", "Add Arrays"}, taskReport.getTaskNames());

// Verify that developers were added correctly
assertArrayEquals(new String[]{"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"}, taskReport.getDevelopers());

// Verify task durations
assertArrayEquals(new int[]{5, 8, 2, 11}, taskReport.getTaskDurations());
}

@Test
public void testDisplayTasksWithStatusDone() {
// This is a visual test - for validation, ensure "Create Reports" is displayed as 'Done'
taskReport.displayTasksWithStatusDone();
}

@Test
public void testLongestTask() {
// Task with the longest duration should be "Add Arrays" with 11 hours
taskReport.displayLongestTask();

// Validate the longest duration programmatically
int[] durations = taskReport.getTaskDurations();
assertTrue(durations[3] == 11);
}

@Test
public void testSearchTaskByName() {
// Search for "Create Login" and ensure it's found
taskReport.searchTaskByName("Create Login");

// Negative test: search for a task that doesn't exist
taskReport.searchTaskByName("Nonexistent Task");
}

@Test
public void testSearchTasksByDeveloper() {
// Search for tasks assigned to "Mike Smith"
taskReport.searchTasksByDeveloper("Mike Smith");

// Negative test: search for tasks assigned to a developer not in the data
taskReport.searchTasksByDeveloper("Unknown Developer");
}

@Test
public void testDeleteTaskByName() {
// Delete the task "Create Reports"
taskReport.deleteTaskByName("Create Reports");

// Verify that the task count is now 3
assertEquals(3, taskReport.getTaskCount());

// Verify that "Create Reports" is no longer in the task names array
assertFalse(java.util.Arrays.asList(taskReport.getTaskNames()).contains("Create Reports"));
}

@Test
public void testDisplayTaskReport() {
// Visual test: Ensure all tasks are displayed correctly in the report
taskReport.displayTaskReport();
}
}
