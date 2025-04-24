import javax.swing.*;
import java.awt.*;

/**
 * Screen to display complete booking information after successful booking.
 */
public class BookingConfirmationScreen extends JFrame {
    public BookingConfirmationScreen(String movie, String showtime, String seats) {
        initializeUI(movie, showtime, seats);
    }
    
    private void initializeUI(String movie, String showtime, String seats) {
        setTitle("Booking Confirmation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Header
        JLabel headerLabel = new JLabel("Booking Confirmed!", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(new Color(0, 128, 0)); // Dark green color
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        
        // Booking details panel
        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBorder(BorderFactory.createTitledBorder("Booking Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Movie details
        gbc.gridx = 0;
        gbc.gridy = 0;
        detailsPanel.add(new JLabel("Movie:"), gbc);
        
        gbc.gridx = 1;
        JLabel movieLabel = new JLabel(movie);
        movieLabel.setFont(new Font("Arial", Font.BOLD, 14));
        detailsPanel.add(movieLabel, gbc);
        
        // Showtime details
        gbc.gridx = 0;
        gbc.gridy = 1;
        detailsPanel.add(new JLabel("Showtime:"), gbc);
        
        gbc.gridx = 1;
        JLabel showtimeLabel = new JLabel(showtime);
        showtimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        detailsPanel.add(showtimeLabel, gbc);
        
        // Seats details
        gbc.gridx = 0;
        gbc.gridy = 2;
        detailsPanel.add(new JLabel("Selected Seats:"), gbc);
        
        gbc.gridx = 1;
        JLabel seatsLabel = new JLabel(seats);
        seatsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        detailsPanel.add(seatsLabel, gbc);
        
        // Booking ID (random for demonstration)
        gbc.gridx = 0;
        gbc.gridy = 3;
        detailsPanel.add(new JLabel("Booking ID:"), gbc);
        
        gbc.gridx = 1;
        String bookingId = "BK" + String.format("%06d", (int)(Math.random() * 1000000));
        JLabel bookingIdLabel = new JLabel(bookingId);
        bookingIdLabel.setFont(new Font("Arial", Font.BOLD, 14));
        detailsPanel.add(bookingIdLabel, gbc);
        
        mainPanel.add(detailsPanel, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton homeButton = new JButton("Return to Home");
        homeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        homeButton.addActionListener(e -> {
            new WelcomeScreen().setVisible(true);
            dispose();
        });
        
        JButton printButton = new JButton("Print Ticket");
        printButton.setFont(new Font("Arial", Font.PLAIN, 14));
        printButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, 
                "Ticket printed successfully!\nPlease keep this booking ID for reference: " + bookingId,
                "Print Confirmation",
                JOptionPane.INFORMATION_MESSAGE);
        });
        
        buttonPanel.add(homeButton);
        buttonPanel.add(printButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
} 