import javax.swing.*;
import java.awt.*;

/**
 * Welcome screen of the Movie Ticket Booking System.
 * Displays a welcome message and a button to start the booking process.
 */
public class WelcomeScreen extends JFrame {
    public WelcomeScreen() {
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("Movie Ticket Booking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Welcome label
        JLabel welcomeLabel = new JLabel("Movie Ticket Booking System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        
        // Book Ticket button
        JButton bookTicketButton = new JButton("Book Ticket");
        bookTicketButton.setFont(new Font("Arial", Font.PLAIN, 16));
        bookTicketButton.addActionListener(e -> {
            new MovieSelectionScreen().setVisible(true);
            dispose();
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bookTicketButton);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        add(mainPanel);
    }
} 