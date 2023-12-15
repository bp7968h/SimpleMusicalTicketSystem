package musicalticketsystem;

import javax.swing.ImageIcon;
import java.util.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;

public class Event {
    private String title;
    private ImageIcon image;
    private String description;
    private Date date;
    private LocalTime time; // You can also use java.sql.Time or java.time.LocalTime
    private double ticketPrice;

    // Constructor
    public Event(String title, ImageIcon image, String description, Date date, LocalTime time, double ticketPrice) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.date = date;
        this.time = time;
        this.ticketPrice = ticketPrice;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageIcon getImage() {
        return image;
    }
    
    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }
    
    public String getFormattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd YYYY");
        return formatter.format(date);
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
