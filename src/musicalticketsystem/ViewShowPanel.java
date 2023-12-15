package musicalticketsystem;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.IntStream;

public class ViewShowPanel extends JPanel {
    private JComboBox<String> seatSelection;
    private JComboBox<String> dateSelection;
    private JComboBox<String> timeSelection;
    private JComboBox<String> ticketTypeSelection;
    private JTextField tCount;
    private JTextField total;
    private final JButton confirmButton;
    private final JButton bookButton;
    private int ticketCount = 0;
    private double totalCost = 0.0;
    private List<Map<String, String>> bookings = new ArrayList<>();

    public ViewShowPanel(Event event, Runnable onBack) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;

        // Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> onBack.run());
        add(backButton, gbc);

        // Reset for image
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // span across all columns
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1; // give vertical space

        JPanel imageAndDescriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // Image with padding
        JLabel imageLabel = new JLabel(event.getImage());
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 4, 2, 10));
//        add(imageLabel, gbc);
        imageAndDescriptionPanel.add(imageLabel);

        // Description below image
        gbc.gridx++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0; // reset to default
        JLabel aboutText = new JLabel();
        aboutText.setText(
        "<html><body style='width: 200px;'>" + // Set a maximum width for the text
        "Show Name: <b>" + event.getTitle() + "<b/> <br/>" +
        "<br/>Description: " + event.getDescription() + "<br/>" +
        "<br/>Duration: 2 hours"+ "<br/>" +
        "<br/>Adult Ticket Price: " + event.getTicketPrice() + 
        "<br/>Senior Ticker Price: " + event.getTicketPrice() / 2 +
        "<br/>Student Ticket Price: " + event.getTicketPrice()  / 5 +
        "</body></html>"
        );
        imageAndDescriptionPanel.add(aboutText);
        add(imageAndDescriptionPanel, gbc);
        //add(aboutText, gbc);

        // Seat selection
        JLabel seatLabel = new JLabel("Select Seat:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(seatLabel, gbc);

        gbc.gridy++;
        seatSelection = new JComboBox<>(IntStream.rangeClosed(1, 20)
                .mapToObj(Integer::toString)
                .toArray(String[]::new));
        add(seatSelection, gbc);

        // Date and Time selection
        JLabel dateLabel = new JLabel("Select Date and Time:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(dateLabel, gbc);
        gbc.gridy++;
        dateSelection = new JComboBox<>(new String[]{"2023-12-16", "2023-12-17", "2023-12-18", "2023-12-19", "2023-12-20"});
        timeSelection = new JComboBox<>(new String[]{"20:00:00", "20:30:00", "20:45:00", "21:30:00", "21:45:00", "22:00:00"});
        // ... populate dateSelection and timeSelection with data
        add(dateSelection, gbc);
        gbc.gridy++;
        add(timeSelection, gbc);

        // Ticket Type and Quantity selection
        JLabel ticketTypeLabel = new JLabel("Select Ticket Type:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(ticketTypeLabel, gbc);
        gbc.gridy++;
        ticketTypeSelection = new JComboBox<>(new String[]{"Adult", "Senior", "Student"});
        add(ticketTypeSelection, gbc);

        JPanel confirmPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Confirm and Book buttons
        confirmButton = new JButton("Add Ticket");
        confirmPanel.add(confirmButton);
        
        
         // Ticket Count label and text field
        JLabel tcountLabel = new JLabel("Ticket Count:");
        confirmPanel.add(tcountLabel);
        tCount = new JTextField("0", 3);
        tCount.setEditable(false);
        confirmPanel.add(tCount);
        JLabel totalLabel = new JLabel("Total Cost:");
        confirmPanel.add(totalLabel);
        total = new JTextField("0", 5);
        total.setEditable(false);
        confirmPanel.add(total);
        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 8; // Span across two columns
        add(confirmPanel, gbc);
        
 
        bookButton = new JButton("Book");
        gbc.gridy++; // move to the next column
        add(bookButton, gbc);
        
        if (ticketCount == 0) {
            bookButton.setEnabled(false);
        }
 
        // Invisible filler to push everything up
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weighty = 1; // give weight to push everything to the top
        gbc.fill = GridBagConstraints.VERTICAL;
        Component filler = Box.createVerticalGlue();
        add(filler, gbc); 
        
        
        //Action Listners:
        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the selected seat, date, time, and ticket type
                String selectedSeat = (String) seatSelection.getSelectedItem();
                String selectedDate = (String) dateSelection.getSelectedItem();
                String selectedTime = (String) timeSelection.getSelectedItem();
                String selectedTicketType = (String) ticketTypeSelection.getSelectedItem();
                double ticketPrice = getPriceForTicketType(selectedTicketType, event.getTicketPrice());
                String eventName = event.getTitle();
                Map<String, String> bookingDetails = new HashMap<>();
                
                bookingDetails.put("seat", selectedSeat);
                bookingDetails.put("date", selectedDate);
                bookingDetails.put("time", selectedTime);
                bookingDetails.put("ticketType", selectedTicketType);
                bookingDetails.put("price", String.valueOf(ticketPrice));
                bookingDetails.put("eventName", eventName);
                bookings.add(bookingDetails);
                
                ticketCount++;
                totalCost += ticketPrice;
                tCount.setText(String.valueOf(ticketCount));
                total.setText(String.format("%.2f", totalCost));
                bookButton.setEnabled(true);
            }
        });
        
        bookButton.addActionListener((var e) -> {
            MusicalTicketSystem.showBookingSummary(bookings);
        });
    }
    
    private double getPriceForTicketType(String ticketType, double ticketPrice) {
        return switch (ticketType) {
            case "Adult" -> ticketPrice;
            case "Senior" -> ticketPrice / 2;
            case "Student" -> ticketPrice / 5;
            default -> ticketPrice;
        };
    }
}