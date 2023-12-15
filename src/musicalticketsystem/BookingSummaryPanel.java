/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicalticketsystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.swing.*;
/**
 *
 * @author bpandit
 */
public class BookingSummaryPanel extends JPanel {
    
    
    public BookingSummaryPanel(List<Map<String, String>> bookings) {
        setLayout(new BorderLayout());
        add(new JLabel("Booking Summary", SwingConstants.CENTER), BorderLayout.NORTH);

        // Panel to display booking details as ticket-like cards
        JPanel ticketsPanel = new JPanel();
        ticketsPanel.setLayout(new BoxLayout(ticketsPanel, BoxLayout.Y_AXIS));

        int totalTickets = 0;
        double totalCost = 0.0;

        for (Map<String, String> booking : bookings) {
            totalTickets++;
            totalCost += Double.parseDouble(booking.get("price"));

            JPanel ticketPanel = new JPanel();
            ticketPanel.setLayout(new BoxLayout(ticketPanel, BoxLayout.Y_AXIS));
            ticketPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            ticketPanel.add(new JLabel("Event Name: " + booking.get("eventName")));
            ticketPanel.add(new JLabel("Seat: " + booking.get("seat")));
            ticketPanel.add(new JLabel("Date: " + booking.get("date")));
            ticketPanel.add(new JLabel("Time: " + booking.get("time")));
            ticketPanel.add(new JLabel("Ticket Type: " + booking.get("ticketType")));
            ticketPanel.add(new JLabel("Price: £" + booking.get("price")));
            ticketsPanel.add(Box.createVerticalStrut(10)); // Space between cards
            ticketsPanel.add(ticketPanel);
            
            JPanel centeredTicketPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            centeredTicketPanel.add(ticketPanel);
            ticketsPanel.add(centeredTicketPanel);
            ticketsPanel.add(Box.createVerticalStrut(10));
        }

        // Add the ticketsPanel to a container panel for center alignment
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.add(Box.createVerticalGlue());
        containerPanel.add(ticketsPanel);
        containerPanel.add(Box.createVerticalGlue());

        JScrollPane scrollPane = new JScrollPane(containerPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Total panel
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        totalPanel.add(new JLabel("Total Tickets: " + totalTickets));
        totalPanel.add(new JLabel("Total Cost: £" + String.format("%.2f", totalCost)));

        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton printButton = new JButton("Print");
        JButton homeButton = new JButton("Home");
        buttonsPanel.add(printButton);
        buttonsPanel.add(homeButton);

        // Add totalPanel and buttonsPanel to a single panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(totalPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

       //action listnr
       printButton.addActionListener(e -> {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save Booking Summary");
    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        String filePath = fileToSave.getAbsolutePath();
        if (!filePath.endsWith(".csv")) {
            filePath += ".csv"; // Ensure the file has a .csv extension
        }

        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            StringBuilder sb = new StringBuilder();
            // Add headers
            sb.append("Event Name");
            sb.append(',');
            sb.append("Seat");
            sb.append(',');
            sb.append("Date");
            sb.append(',');
            sb.append("Time");
            sb.append(',');
            sb.append("Ticket Type");
            sb.append(',');
            sb.append("Price");
            sb.append('\n');

            // Iterate over bookings and add to StringBuilder
            for (Map<String, String> booking : bookings) {
                sb.append(booking.get("eventName"));
                sb.append(',');
                sb.append(booking.get("seat"));
                sb.append(',');
                sb.append(booking.get("date"));
                sb.append(',');
                sb.append(booking.get("time"));
                sb.append(',');
                sb.append(booking.get("ticketType"));
                sb.append(',');
                sb.append(booking.get("price"));
                sb.append('\n');
            }

            writer.write(sb.toString());
            JOptionPane.showMessageDialog(null, "Booking summary saved to " + filePath);
        } 
    catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage());
        }}
});
       homeButton.addActionListener(e -> {
            MusicalTicketSystem.showCard(MusicalTicketSystem.MAINPANEL);
        });
    }
}