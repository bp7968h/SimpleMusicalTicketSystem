package musicalticketsystem;

import utils.ShowFetcher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MainPanel extends JPanel {
    private JTextField searchField;
    private JButton searchButton;
    private JPanel gridPanel;

    public MainPanel() {
        setLayout(new BorderLayout());

        // Create and add search panel at the top
        JPanel searchPanel = createSearchPanel();
        add(searchPanel, BorderLayout.NORTH);

        // Create and add event grid in the center
        JScrollPane eventGrid = createEventGrid();
        add(eventGrid, BorderLayout.CENTER);
    }

    private JPanel createSearchPanel() {
        JPanel panel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search Title");
        
        
        searchButton.addActionListener(e -> {
            String searchText = searchField.getText().toLowerCase(); // Convert search text to lowercase for case-insensitive search
        
        // Fetch events from the database
            java.util.List<Event> events = ShowFetcher.fetchEvents();
        
        // Create a filtered list to store matching events
            java.util.List<Event> filteredEvents = new ArrayList<>();
        
        // Iterate through the events and check if the title contains the search text
            for (Event event : events) {
                if (event.getTitle().toLowerCase().contains(searchText)) {
                    filteredEvents.add(event);
             }
         }
        
        // Clear the existing event grid
            gridPanel.removeAll();
        
        // Add the filtered events to the grid
            for (Event event : filteredEvents) {
                JPanel eventPanel = createEventPanel(event);
                gridPanel.add(eventPanel);
            }
        
        // Repaint the panel to reflect the changes
            gridPanel.revalidate();
            gridPanel.repaint();
        });

        panel.add(searchField);
        panel.add(searchButton);
        return panel;
    }

    private JScrollPane createEventGrid() {
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(0, 2, 10, 10)); // 0 rows, 2 columns, 10px horizontal and vertical gaps

        // Fetch events from database
        java.util.List<Event> events = ShowFetcher.fetchEvents();
        for (Event event : events) {
            JPanel eventPanel = createEventPanel(event);
            gridPanel.add(eventPanel);
        }

        // Wrap the grid panel in a JScrollPane for scrolling
        return new JScrollPane(gridPanel);
    }

    private JPanel createEventPanel(Event event) {
    JPanel panel = new JPanel(new BorderLayout(10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    JLabel lblImage = new JLabel(event.getImage());
    JLabel lblText = new JLabel();
    lblText.setText(
        "<html><body style='width: 150px;'>" + // Set a maximum width for the text
        "Title: " + event.getTitle() +
        "<br/>description: " + event.getDescription() +
        "<br/>Date: " + event.getFormattedDate() +
        "<br/>Time: " + event.getFormattedTime() +
        "<br/>Ticket Price: " + event.getTicketPrice() +
        "</body></html>"
    );

    panel.add(lblImage, BorderLayout.WEST);
    panel.add(lblText, BorderLayout.CENTER);
    
    panel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            MusicalTicketSystem.addViewShowPanel(event);
        }
    });

    return panel;
  }
}
