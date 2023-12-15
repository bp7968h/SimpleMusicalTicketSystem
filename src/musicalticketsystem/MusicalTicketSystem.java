/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musicalticketsystem;

/**
 *
 * @author bpandit
 */

import java.awt.CardLayout;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class MusicalTicketSystem {

    private static CardLayout cardLayout;
    private static JPanel cardContainer;
    public static final String MAINPANEL = "MainPanel";
    private static final String VIEWPANEL = "ViewPanel";
    private static final String BOOKING_SUMMARY = "BookingSummary";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Musical Ticket System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardContainer = new JPanel(cardLayout);
        
        MainPanel mainPanel = new MainPanel();
        cardContainer.add(mainPanel, MAINPANEL);

        frame.add(cardContainer);
        frame.setVisible(true);
    }
    
    public static void showCard(String card) {
        cardLayout.show(cardContainer, card);
    }

    public static void addViewShowPanel(Event event) {
        ViewShowPanel viewShowPanel = new ViewShowPanel(event, () -> showCard(MAINPANEL));
        cardContainer.add(viewShowPanel, VIEWPANEL);
        showCard(VIEWPANEL);
    }
    
    public static void showBookingSummary(List<Map<String, String>> bookings) {
        // Create the booking summary panel with the provided booking details
        BookingSummaryPanel bookingSummaryPanel = new BookingSummaryPanel(bookings);
        cardContainer.add(bookingSummaryPanel, BOOKING_SUMMARY);
        cardLayout.show(cardContainer, BOOKING_SUMMARY);
    }
}
