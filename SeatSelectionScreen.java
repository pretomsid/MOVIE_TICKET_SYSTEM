import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Screen for selecting seats in a grid layout.
 * Displays 5 rows with 8 seats each.
 */
public class SeatSelectionScreen extends JFrame {
    private final String selectedMovie;
    private final String selectedShowtime;
    private final List<JButton> selectedSeats;
    private final boolean[][] bookedSeats;
    
    public SeatSelectionScreen(String selectedMovie, String selectedShowtime) {
        this.selectedMovie = selectedMovie;
        this.selectedShowtime = selectedShowtime;
        this.selectedSeats = new ArrayList<>();
        this.bookedSeats = new boolean[5][8];
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("Select Seats");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Header panel
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        JLabel movieLabel = new JLabel("Movie: " + selectedMovie, SwingConstants.CENTER);
        JLabel showtimeLabel = new JLabel("Showtime: " + selectedShowtime, SwingConstants.CENTER);
        movieLabel.setFont(new Font("Arial", Font.BOLD, 16));
        showtimeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        headerPanel.add(movieLabel);
        headerPanel.add(showtimeLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Seat grid panel
        JPanel seatPanel = new JPanel(new GridLayout(5, 8, 5, 5));
        seatPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Create seat buttons
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 8; col++) {
                JButton seatButton = new JButton((row + 1) + "-" + (col + 1));
                seatButton.setFont(new Font("Arial", Font.PLAIN, 12));
                
                // Randomly mark some seats as booked for demonstration
                if (Math.random() < 0.2) {
                    bookedSeats[row][col] = true;
                    seatButton.setEnabled(false);
                    seatButton.setBackground(Color.RED);
                } else {
                    seatButton.addActionListener(e -> toggleSeatSelection(seatButton));
                }
                
                seatPanel.add(seatButton);
            }
        }
        
        mainPanel.add(seatPanel, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton confirmButton = new JButton("Confirm Selection");
        confirmButton.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmButton.addActionListener(e -> showConfirmation());
        
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.addActionListener(e -> {
            new ShowtimeSelectionScreen(selectedMovie).setVisible(true);
            dispose();
        });
        
        buttonPanel.add(confirmButton);
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void toggleSeatSelection(JButton seatButton) {
        if (selectedSeats.contains(seatButton)) {
            selectedSeats.remove(seatButton);
            seatButton.setBackground(null);
        } else {
            selectedSeats.add(seatButton);
            seatButton.setBackground(Color.GREEN);
        }
    }
    
    private void showConfirmation() {
        if (selectedSeats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one seat", 
                "No Seats Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        StringBuilder seats = new StringBuilder();
        for (JButton seat : selectedSeats) {
            seats.append(seat.getText()).append(", ");
        }
        seats.setLength(seats.length() - 2); // Remove last comma and space
        
        int result = JOptionPane.showConfirmDialog(this,
            "Confirm your booking:\n" +
            "Movie: " + selectedMovie + "\n" +
            "Showtime: " + selectedShowtime + "\n" +
            "Seats: " + seats.toString(),
            "Confirm Booking",
            JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.YES_OPTION) {
            new BookingConfirmationScreen(selectedMovie, selectedShowtime, seats.toString()).setVisible(true);
            dispose();
        }
    }
} 