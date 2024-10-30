/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Task {

    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;
    private int taskNumber;
    private String taskID;
    private static int taskCounter = 0;
    private static List<Task> taskList = new ArrayList<>();

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = taskCounter++;
        this.taskID = createTaskID();
        taskList.add(this); // Add this task to the static list
    }

    public String createTaskID() {
        String namePart = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName.toUpperCase();
        String developerPart = developerDetails.length() >= 3 ? developerDetails.substring(0, 3) : developerDetails.toUpperCase();
        return namePart + ":" + taskNumber + ":" + developerPart;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
                "\nDeveloper Details: " + developerDetails +
                "\nTask Number: " + taskNumber +
                "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription +
                "\nTask ID: " + taskID +
                "\nDuration: " + taskDuration + " hours";
    }

    public static int returnTotalHours() {
        int totalHours = 0;
        for (Task task : taskList) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }
}
