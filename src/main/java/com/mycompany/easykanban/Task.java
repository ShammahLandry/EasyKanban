/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easykanban;
import java.util.List;
/**
 *
 * @author RC_Student_lab
 */
public class Task {
    private static int totalTaskCount = 0;
    private int taskNumber;
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;
    private String taskID;

    public Task(int taskNumber, String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
        totalTaskCount++; // Increment total task count for each task created
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        String namePart = taskName.substring(0, 2).toUpperCase();
        String devPart = developerDetails.split(" ")[1].substring(developerDetails.split(" ")[1].length() - 3).toUpperCase();
        return namePart + ":" + taskNumber + ":" + devPart;
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

    public static int returnTotalHours(List<Task> tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }
}