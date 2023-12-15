package utils;

import musicalticketsystem.Event;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ShowFetcher {

    public static List<Event> fetchEvents() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM shows";

        try (Connection conn = connection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Event event = new Event(
                    rs.getString("showName"), 
                    new ImageIcon(rs.getString("image")), 
                    rs.getString("description"), 
                    rs.getDate("date"), 
                    rs.getTime("time").toLocalTime(), 
                    rs.getDouble("ticketPrice")
                );
                events.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return events;
    }
}
