package com.Project.JournalApp.JournalApp.Entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ErrorResponse {
    private String message;
    private int statusCode; // optional
    private String timestamp; // formatted timestamp

    public ErrorResponse(String message) {
        this.message = message;
        this.timestamp = formatTimestamp(System.currentTimeMillis());
    }

    // Overloaded constructor to include status code
    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = formatTimestamp(System.currentTimeMillis());
    }

    // Method to format the timestamp
    private String formatTimestamp(long millis) {
        // Convert milliseconds to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());

        // Define the formatter for 12-hour format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        // Format the dateTime to a string
        return dateTime.format(formatter);
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}