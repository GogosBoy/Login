/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import javax.swing.*;
import java.util.ArrayList;

public class KanbanTask {

    private static int taskCount = 0; // Counter for the number of tasks entered

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));

        while (taskCount < numberOfTasks) {
            String menu = "Choose an option:\n" +
                          "1) Add tasks\n" +
                          "2) Show report (Coming Soon)\n" +
                          "3) Quit";

            String choice = JOptionPane.showInputDialog(menu);

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    break;
            }
        }

        int totalHours = Task.returnTotalHours();
        JOptionPane.showMessageDialog(null, "Total Hours for all tasks: " + totalHours);
    }

    private static void addTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        String developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First Last):");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:",
                "Task Status", JOptionPane.QUESTION_MESSAGE, null,
                new String[]{"To Do", "Doing", "Done"}, "To Do");

        new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
        taskCount++; // Increment the task counter

        // Display the full details of the task after it has been entered
        JOptionPane.showMessageDialog(null, "Task added successfully!");
    }
}
