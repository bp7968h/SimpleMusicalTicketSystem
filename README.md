# MusicalTicketSystem
The London Musical Ticket System is a Java based application that aims to transform the way customers engage with the London music scene. This innovative system, developed as part of the COMP1618 Software Tools and Techniques coursework not demonstrates the versatility of Java. Also embodies modern software engineering principles. It seamlessly integrates database connectivity, user interface design and file handling to provide a solution for booking and managing tickets.Below core functionalities of the application is listed:
* Database Driven Content: At its core this system utilizes a JDBC connection to establish a connection with a MySQL database (connection class). This database plays a role in the system's functionality by storing information about various musical events. It ensures dynamic content management allowing the application to adapt effortlessly to changes in event schedules, pricing and availability.
* Search Capability: One of the system's standout features is its search functionality located within the MainPanel. This convenient feature enables users to effortlessly find events based on their titles. The search function is designed to be responsive and user friendly providing real time event filtering and updating for an user experience. It simplifies the process of locating shows from an extensive range of options.
* Displaying Event Information, with Graphics: of presenting events in text form the application goes the extra mile by incorporating visual elements. By including images of the shows users have an informative experience. This feature, combined with detailed event descriptions gives customers an overview to help them make informed decisions when purchasing tickets.
* Flexible Ticket Personalization: One standout aspect is the flexibility offered when booking tickets. Users have the option to choose from a variety of shows each offering ticket types such as Adult, Senior or Student. With the ViewShowPanel class users can easily select their preferred date, time, seat and ticket type for each show. The system can efficiently handle ticket bookings in a transaction to cater to different customer preferences.
* Exporting Booking Details: After completing a booking users can export their ticket details. The BookingSummaryPanel provides an overview of the booking by showcasing information, like the number of tickets purchased and total price. This summary can be exported in CSV format as a record of the transaction that enhances the post booking user experience.

The London Musical Ticket System is a user application that offers a ticket booking experience. By leveraging the power of Java and advanced software development techniques it seamlessly combines functionalities such as event browsing, ticket booking and exporting booking details. This system caters to the needs of the London musical theater audience providing a tool for managing tickets while demonstrating the practical application of Java programming and software development, in real world scenarios.

## Design and Development
The London Musical Ticket System, built with Java Swing features an user-friendly interface that allows for smooth interaction with the application. Its design incorporates components of Swing, such as buttons, text fields, combo boxes and panels. These elements are arranged in a layout for effortless navigation and functionality. This system showcases the utilization of Java Swing to create a modular and visually attractive application for managing complex tasks, like browsing events, booking tickets and handling data.
### GUI Design
The graphical user interface (GUI) layout of the London Musical Ticket System has been carefully designed to ensure that it is easy to use and effectively presents information.
* Main Window: The main window, created using JFrame acts as a container for panels. Its layout is simple and intuitive, encouraging users to explore and interact with it.
* Main Panel: This panel includes a search bar at the top. Displays events, in a grid format. This layout allows users to quickly access the search functionality while visually engaging them with event options.
* Event Display: Each event is presented in a card format showing the events image, title and important details. This design choice enhances appeal. Makes information easily understandable.
* Booking and Summary Panels: These panels follow a layout that guides users through the booking process and provides a summary of their choices at the end.
  
![GUISketch](https://github.com/bp7968h/SimpleMusicalTicketSystem/assets/126598388/80f99970-b861-4c63-b0d2-a23550e5dc0d)

### Prototype Implementation
The main goal of the prototype was to create a foundation for the graphical user interface (GUI) by establishing its structure and layout of any integration.
* GUI Elements: For the GUI elements we used Swing components such as JPanels, JButtons, JTextFields and JLabels to lay out the framework of the application.
* Design Choices:When making design choices our focus was, on ensuring that the user interface is visually pleasing, easy to navigate and self explanatory. We arranged the components in a way that follows a flow of user interaction.

### Full Implementations
The implemented system combines a designed graphical user interface (GUI), with strong backend functions.
* System Description: The final application seamlessly integrates all GUI components with the logic. The MainPanel enables users to search for and display events ViewShowPanel handles ticket selection and BookingSummaryPanel finalizes the booking process.
* Java Technologies and Tools: This application extensively utilizes Java Swing for the GUI, JDBC for connecting to databases. Java I/O for exporting data in CSV format. By combining these technologies we ensure that the application is responsive, data driven and user friendly.
* Integration of External Data Source; To provide real time event information and store user bookings effectively the system connects to a MySQL database. This integration is essential for keeping event details up to date and securely managing user bookings.
![export](https://github.com/bp7968h/SimpleMusicalTicketSystem/assets/126598388/ea7b34c7-99c5-40f1-85fa-2d80beff151a)

### Event Responsiveness
Event listeners are meticulously implemented to ensure that user actions prompt responses. As a result the application becomes interactive and dynamic, in its behavior.

### Class Diagram Initiative
A class diagram plays a role, in object oriented programming as it allows us to visualize the structure of a system. It presents an overview of classes, their attributes, methods and how they interact with one another. This helps developers have a blueprint to work with facilitates communication among stakeholders, identifies areas for design enhancements and ensures everyone has a unified understanding of the systems architecture. Ultimately this leads to the development of efficient software.
file:///home/bpandit/Documents/UniversityGreenwich/SoftwareToolsTech/classDiagram.png

### Innovative Feature
The London Musical Ticket System is impressive, due to its capabilities, which include a search function, real time database connectivity and visually displaying event images. These features greatly enhance user engagement. The system's interface is intuitive. Incorporates functionalities like disabling the 'Book' button when no tickets are selected. This streamlines the booking process. Enhances the user experience. By combining these elements the system becomes both user friendly and technologically sophisticated.
* Database Connection: The ShowFetcher class, in the London Musical Ticket System retrieves information about shows by using its fetchEvents method. This method establishes a connection with the database through the connection class, runs a SQL query to gather details about the shows and then fills a list of Event objects with this data. Each Event contains information such as the shows name, image and timing ensuring that the application presents up to date and thorough show information to the user.
  file:///home/bpandit/Documents/UniversityGreenwich/SoftwareToolsTech/db.png

* Search Function: The search feature, in the MainPanel of the London Musical Ticket System is designed to be user friendly. Users can enter their search criteria in the searchField. When they click on the searchButton an actionListener is activated. This listener calls ShowFetcher.fetchEvents() to fetch all events and filter them based on the search term. Updates the gridPanel to show the events that are relevant. This makes it easier and more efficient for users to find events they are looking for.
file:///home/bpandit/Documents/UniversityGreenwich/SoftwareToolsTech/search.png

* Use of Images: In the London Musical Ticket Systems MainPanel we use the createEventPanel method to display event images. This method takes each Event objects ImageIcon. Adds it to a JLabel, which is then shown on the grid. To enhance the user interface visually we retrieve the images, from the database through the ShowFetcher.fetchEvents() method giving a representation of each event.
![image](https://github.com/bp7968h/SimpleMusicalTicketSystem/assets/126598388/bfc45c32-1919-4616-bdd5-19b797fb39bf)

In summary the creation and implementation of the London Musical Ticket System using Java Swing showcases a balance of attractive user friendly design and technical reliability. This software not only meets all the functionalities but also offers a captivating and user friendly interface, for its users.
