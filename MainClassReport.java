/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import javax.swing.JOptionPane;

/**
 * Main class for the Task Manager application.
 * Provides a user interface for managing tasks, including adding, searching, deleting, and reporting tasks.
 * 
 * @author RC_Student_lab
 */
public class MainClassReport {
    public static void main(String[] args) {
        // Create a TaskReport object to manage tasks. Initialize it with a capacity of 10 tasks.
        TaskReport taskReport = new TaskReport(10); 

        // Define the options available in the menu
        String[] options = {
            "Add Task", 
            "Display 'Done' Tasks", 
            "Longest Task", 
            "Search by Name", 
            "Search by Developer", 
            "Delete Task", 
            "Task Report", 
            "Exit"
        };
        
        int choice;  // Variable to hold the user's menu choice

        // Loop to continuously display the menu until the user chooses to exit
        do {
            // Display the menu to the user and get their choice using a JOptionPane dialog
            choice = JOptionPane.showOptionDialog(
                null, 
                "Choose an option", 
                "Task Manager", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]
            );

            // Process the user's choice using a switch statement
            switch (choice) {
                case 0 -> {
                    // Add Task
                    // Prompt the user for task details and add the task to the report
                    String developer = JOptionPane.showInputDialog("Enter Developer Name:");
                    String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                    int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
                    String taskStatus = JOptionPane.showInputDialog("Enter Task Status (To Do / Doing / Done):");

                    // Add the new task to the report
                    taskReport.addTask(developer, taskName, taskDuration, taskStatus);
                }

                case 1 -> // Display 'Done' Tasks
                    // Display all tasks that have the status 'Done'
                    taskReport.displayTasksWithStatusDone();

                case 2 -> // Longest Task
                    // Display the task with the longest duration
                    taskReport.displayLongestTask();

                case 3 -> {
                    // Search by Task Name
                    // Prompt the user for a task name and search for it in the task list
                    String searchName = JOptionPane.showInputDialog("Enter Task Name to Search:");
                    taskReport.searchTaskByName(searchName);
                }

                case 4 -> {
                    // Search by Developer Name
                    // Prompt the user for a developer name and display tasks assigned to that developer
                    String searchDeveloper = JOptionPane.showInputDialog("Enter Developer Name to Search:");
                    taskReport.searchTasksByDeveloper(searchDeveloper);
                }

                case 5 -> {
                    // Delete Task
                    // Prompt the user for a task name to delete from the list
                    String deleteName = JOptionPane.showInputDialog("Enter Task Name to Delete:");
                    taskReport.deleteTaskByName(deleteName);
                }

                case 6 -> // Task Report
                    // Display a complete report of all tasks in the system
                    taskReport.displayTaskReport();

                case 7 -> // Exit
                    // Inform the user that the program is exiting
                    JOptionPane.showMessageDialog(null, "Exiting Task Manager. Goodbye!", "Exit", JOptionPane.INFORMATION_MESSAGE);

                default -> // If the user selects an invalid option, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid option!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (choice != 7); // The loop continues until the user selects "Exit"
    }
}
