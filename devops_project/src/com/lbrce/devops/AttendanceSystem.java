package com.lbrce.devops;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AttendanceSystem extends JFrame {

    private JTextField studentIdField;
    private JTextField studentNameField;
    private ArrayList<String> attendanceRecords;

    public AttendanceSystem() {
        attendanceRecords = new ArrayList<>(); // Initialize the attendance records list

        setTitle("Student Attendance System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2)); // Change to GridLayout

        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdField = new JTextField(15);
        
        JLabel studentNameLabel = new JLabel("Student Name:");
        studentNameField = new JTextField(15);
        
        JButton markAttendanceButton = new JButton("Mark Attendance");
        JButton viewAttendanceButton = new JButton("View Attendance");
        
        markAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markAttendance();
            }
        });

        viewAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAttendance();
            }
        });

        // Add components to the frame
        add(studentIdLabel);
        add(studentIdField);
        add(studentNameLabel);
        add(studentNameField);
        add(markAttendanceButton);
        add(viewAttendanceButton);

        setVisible(true);
    }

    private void markAttendance() {
        String studentId = studentIdField.getText();
        String studentName = studentNameField.getText();

        if (!studentId.isEmpty() && !studentName.isEmpty()) {
            String record = "Attendance marked for: " + studentName + " (ID: " + studentId + ")";
            attendanceRecords.add(record); // Add record to the list
            studentIdField.setText("");
            studentNameField.setText("");
            JOptionPane.showMessageDialog(this, "Attendance marked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both Student ID and Name", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewAttendance() {
        if (attendanceRecords.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No attendance records available.", "Attendance Log", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder records = new StringBuilder();
            for (String record : attendanceRecords) {
                records.append(record).append("\n"); // Collect all attendance records
            }
            JOptionPane.showMessageDialog(this, records.toString(), "Attendance Log", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new AttendanceSystem();
    }
}
