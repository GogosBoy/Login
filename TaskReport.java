/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import javax.swing.JOptionPane;

/**
 * Class to manage tasks including adding, searching, displaying, deleting, and generating reports.
 * The tasks are stored in arrays, and actions are performed through a series of methods.
 * 
 * @author RC_Student_lab
 */
public class TaskReport {

    // Arrays to store task details for developers, task names, task IDs, durations, and statuses
    private final String[] developers; // Array to store names of developers assigned to tasks
    private final String[] taskNames; // Array to store names of tasks
    private final String[] taskIDs; // Array to store unique IDs for tasks
    private final int[] taskDurations; // Array to store the durations of tasks in hours
    private final String[] taskStatuses; // Array to store the current status of each task (e.g., To Do, Doing, Done)
    private int taskCount; // Keeps track of how many tasks have been added

    // Constructor to initialize arrays based on the maximum number of tasks
    public TaskReport(int maxTasks) {
        // Initialize arrays with the given maximum task limit
        developers = new String[maxTasks];
        taskNames = new String[maxTasks];
        taskIDs = new String[maxTasks];
        taskDurations = new int[maxTasks];
        taskStatuses = new String[maxTasks];
        taskCount = 0; // Initially, there are no tasks in the report
    }

    // Method to add a new task to the arrays
    public void addTask(String developer, String taskName, int taskDuration, String taskStatus) {
        // Check if there is space to add a new task
        if (taskCount >= developers.length) {
            // If the task list is full, show an error message
            JOptionPane.showMessageDialog(null, "Task list is full.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add the task details to the corresponding arrays
        developers[taskCount] = developer;
        taskNames[taskCount] = taskName;
        taskDurations[taskCount] = taskDuration;
        taskStatuses[taskCount] = taskStatus;

        // Generate a unique Task ID and store it in the taskIDs array
        taskIDs[taskCount] = generateTaskID(taskName, developer, taskCount);
        taskCount++; // Increment taskCount to reflect the addition of the new task

        // Show a success message indicating the task has been added
        JOptionPane.showMessageDialog(null, "Task successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Helper method to generate a unique Task ID based on task name, developer, and task number
    private String generateTaskID(String taskName, String developer, int taskNumber) {
        // Task ID format: <First two letters of task name>:<Task number>:<Last three letters of developer name>
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developer.substring(developer.length() - 3).toUpperCase();
    }

    // Method to display all tasks with the status "Done"
    public void displayTasksWithStatusDone() {
        // Initialize a StringBuilder to build the result message
        StringBuilder result = new StringBuilder("Tasks with status 'Done':\n");

        // Iterate through all tasks and collect those with a "Done" status
        for (int i = 0; i < taskCount; i++) {
            if (taskStatuses[i].equalsIgnoreCase("Done")) {
                result.append("Developer: ").append(developers[i])
                      .append(", Task Name: ").append(taskNames[i])
                      .append(", Duration: ").append(taskDurations[i])
                      .append(" hrs\n");
            }
        }

        // Show the list of "Done" tasks
        JOptionPane.showMessageDialog(null, result.toString(), "Tasks with Status 'Done'", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to find and display the task with the longest duration
    public void displayLongestTask() {
        // Check if there are any tasks to compare
        if (taskCount == 0) {
            // If there are no tasks, show an error message
            JOptionPane.showMessageDialog(null, "No tasks available.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Initialize the index of the task with the longest duration
        int maxIndex = 0;

        // Iterate through tasks to find the one with the longest duration
        for (int i = 1; i < taskCount; i++) {
            if (taskDurations[i] > taskDurations[maxIndex]) {
                maxIndex = i;
            }
        }

        // Show the task with the longest duration
        String message = "Longest Task: Developer: " + developers[maxIndex] + ", Duration: " + taskDurations[maxIndex] + " hrs";
        JOptionPane.showMessageDialog(null, message, "Longest Task", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to search for a task by its name and display its details
    public void searchTaskByName(String taskName) {
        // Search for a task by its name (ignoring case)
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                // If found, show the task details
                String message = "Task Found:\nTask Name: " + taskNames[i] + "\nDeveloper: " + developers[i] + "\nStatus: " + taskStatuses[i];
                JOptionPane.showMessageDialog(null, message, "Task Search", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        // If the task is not found, show an error message
        JOptionPane.showMessageDialog(null, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to search for all tasks assigned to a specific developer and display them
    public void searchTasksByDeveloper(String developerName) {
        // Initialize a StringBuilder to hold the results
        StringBuilder result = new StringBuilder("Tasks assigned to " + developerName + ":\n");
        boolean found = false;

        // Iterate through tasks to find those assigned to the specified developer
        for (int i = 0; i < taskCount; i++) {
            if (developers[i].equalsIgnoreCase(developerName)) {
                result.append("Task Name: ").append(taskNames[i])
                      .append(", Status: ").append(taskStatuses[i])
                      .append("\n");
                found = true;
            }
        }

        // Display the search results or an error message if no tasks were found
        if (found) {
            JOptionPane.showMessageDialog(null, result.toString(), "Tasks by Developer", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for " + developerName, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to delete a task by its name and shift the remaining tasks in the arrays
    public void deleteTaskByName(String taskName) {
        // Search for the task by its name (ignoring case)
        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                // Shift tasks to the left in the arrays to fill the gap created by the deletion
                for (int j = i; j < taskCount - 1; j++) {
                    developers[j] = developers[j + 1];
                    taskNames[j] = taskNames[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                }
                taskCount--; // Decrement the task count after deletion
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted successfully.", "Task Deletion", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        // If the task is not found, show an error message
        JOptionPane.showMessageDialog(null, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to display a full report of all tasks
    public void displayTaskReport() {
        // Initialize a StringBuilder to build the task report
        StringBuilder report = new StringBuilder("Task Report:\n");

        // Iterate through all tasks and add their details to the report
        for (int i = 0; i < taskCount; i++) {
            report.append("Task ID: ").append(taskIDs[i]).append("\n");
            report.append("Developer: ").append(developers[i]).append("\n");
            report.append("Task Name: ").append(taskNames[i]).append("\n");
            report.append("Duration: ").append(taskDurations[i]).append(" hrs\n");
            report.append("Status: ").append(taskStatuses[i]).append("\n");
            report.append("-----------------------------------\n");
        }

        // Show the full task report
        JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.INFORMATION_MESSAGE);
    }

    // Getters for unit testing purposes: returning clones to avoid external modifications
    public String[] getTaskNames() {
        return taskNames.clone();
    }

    public String[] getDevelopers() {
        return developers.clone();
    }

    public int[] getTaskDurations() {
        return taskDurations.clone();
    }

    public int getTaskCount() {
        return taskCount;
    }
}