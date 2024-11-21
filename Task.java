/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import java.util.ArrayList;
import java.util.List;

public class Task {

    // Task attributes
    private final String taskName;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskStatus;
    private final String taskID;

    // Static variables to manage the tasks
    private static int taskCounter = 0;  // Counter to assign unique task numbers
    private static final List<Task> taskList = new ArrayList<>();  // List to store all tasks

    // Arrays to store task details
    public static String[] developers = new String[100];
    public static String[] taskNames = new String[100];
    public static String[] taskIDs = new String[100];
    public static int[] taskDurations = new int[100];
    public static String[] taskStatuses = new String[100];

    // Constructor for creating a task
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = generateTaskID(taskName, developerDetails, taskCounter);

        // Store the task details in the static arrays
        taskNames[taskCounter] = taskName;
        developers[taskCounter] = developerDetails;
        taskDurations[taskCounter] = taskDuration;
        taskStatuses[taskCounter] = taskStatus;
        taskIDs[taskCounter] = taskID;

        taskCounter++;  // Increment the task counter
        boolean add = taskList.add(this); // Add the task to the static list
    }

    // Method to generate a unique Task ID
    private String generateTaskID(String taskName, String developerDetails, int taskNumber) {
        String namePart = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String developerPart = developerDetails.length() >= 3 ? developerDetails.substring(0, 3).toUpperCase() : developerDetails.toUpperCase();
        return namePart + ":" + taskNumber + ":" + developerPart;
    }

    // Method to return the task details in a formatted string
    public String printTaskDetails() {
        return String.format("""
                Task Name: %s
                Task Description: %s
                Developer: %s
                Duration: %d hours
                Status: %s
                Task ID: %s
                """, taskName, taskDescription, developerDetails, taskDuration, taskStatus, taskID);
    }

    // Method to return the total hours of all tasks
    public static int returnTotalHours() {
        int totalHours = 0;
        for (int i = 0; i < taskCounter; i++) {
            totalHours += taskDurations[i];
        }
        return totalHours;
    }

    // Method to display all tasks with the 'Done' status
    public static String displayTasksWithStatusDone() {
        StringBuilder doneTasks = new StringBuilder("Tasks with 'Done' Status:\n\n");

        for (int i = 0; i < taskCounter; i++) {
            if (taskStatuses[i].equals("Done")) {
                doneTasks.append("Developer: ").append(developers[i])
                        .append(", Task Name: ").append(taskNames[i])
                        .append(", Duration: ").append(taskDurations[i])
                        .append(" hours\n");
            }
        }

        return doneTasks.length() > 0 ? doneTasks.toString() : "No tasks with 'Done' status.";
    }

    // Method to find the task with the longest duration
    public static String findLongestTask() {
        int maxDurationIndex = 0;
        for (int i = 1; i < taskCounter; i++) {
            if (taskDurations[i] > taskDurations[maxDurationIndex]) {
                maxDurationIndex = i;
            }
        }

        return String.format("Longest Task:\nDeveloper: %s\nTask Name: %s\nDuration: %d hours",
                developers[maxDurationIndex], taskNames[maxDurationIndex], taskDurations[maxDurationIndex]);
    }

    // Method to search for a task by its name
    public static String searchTaskByName(String searchName) {
        for (int i = 0; i < taskCounter; i++) {
            if (taskNames[i].equalsIgnoreCase(searchName)) {
                return String.format("Task Found:\nTask Name: %s\nDeveloper: %s\nStatus: %s",
                        taskNames[i], developers[i], taskStatuses[i]);
            }
        }
        return "Task not found.";
    }

    // Method to search for tasks by developer name
    public static String searchTasksByDeveloper(String developerName) {
        StringBuilder developerTasks = new StringBuilder("Tasks Assigned to " + developerName + ":\n\n");

        for (int i = 0; i < taskCounter; i++) {
            if (developers[i].equalsIgnoreCase(developerName)) {
                developerTasks.append("Task Name: ").append(taskNames[i])
                        .append(", Status: ").append(taskStatuses[i])
                        .append("\n");
            }
        }

        return developerTasks.length() > 0 ? developerTasks.toString() : "No tasks assigned to this developer.";
    }

    // Method to delete a task by its name
    public static String deleteTaskByName(String taskName) {
        for (int i = 0; i < taskCounter; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                // Shift all tasks after the deleted task to the left
                for (int j = i; j < taskCounter - 1; j++) {
                    taskNames[j] = taskNames[j + 1];
                    developers[j] = developers[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                }

                // Clear the last task data
                taskNames[taskCounter - 1] = null;
                developers[taskCounter - 1] = null;
                taskDurations[taskCounter - 1] = 0;
                taskStatuses[taskCounter - 1] = null;
                taskIDs[taskCounter - 1] = null;

                taskCounter--;  // Decrease the task counter
                return "Task \"" + taskName + "\" has been deleted.";
            }
        }
        return "Task not found.";
    }

    // Method to display the full task report
    public static String displayFullTaskReport() {
        StringBuilder report = new StringBuilder("Task Report:\n\n");

        for (int i = 0; i < taskCounter; i++) {
            report.append("Task Name: ").append(taskNames[i])
                    .append("\nDeveloper: ").append(developers[i])
                    .append("\nDuration: ").append(taskDurations[i])
                    .append(" hours\nStatus: ").append(taskStatuses[i])
                    .append("\nTask ID: ").append(taskIDs[i])
                    .append("\n\n");
        }

        return report.length() > 0 ? report.toString() : "No tasks available.";
    }
}
