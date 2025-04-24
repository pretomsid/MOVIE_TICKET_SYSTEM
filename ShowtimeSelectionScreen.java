import javax.swing.*;
import java.awt.*;

/**
 * Screen for selecting a showtime for the chosen movie.
 */
public class ShowtimeSelectionScreen extends JFrame {
    private final String[] showtimes = {
        "10:00 AM",
        "1:00 PM",
        "4:00 PM",
        "7:00 PM",
        "10:00 PM"
    };
    
    public ShowtimeSelectionScreen(String selectedMovie) {
        initializeUI(selectedMovie);
    }
    
    private void initializeUI(String selectedMovie) {
        setTitle("Select Showtime");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Movie title label
        JLabel movieLabel = new JLabel("Movie: " + selectedMovie, SwingConstants.CENTER);
        movieLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(movieLabel, gbc);
        
        // Showtime label
        JLabel showtimeLabel = new JLabel("Select Showtime", SwingConstants.CENTER);
        showtimeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        mainPanel.add(showtimeLabel, gbc);
        
        // Showtime dropdown
        JComboBox<String> showtimeComboBox = new JComboBox<>(showtimes);
        showtimeComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        mainPanel.add(showtimeComboBox, gbc);
        
        // Next button
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 14));
        nextButton.addActionListener(e -> {
            String selectedShowtime = (String) showtimeComboBox.getSelectedItem();
            new SeatSelectionScreen(selectedMovie, selectedShowtime).setVisible(true);
            dispose();
        });
        
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainPanel.add(nextButton, gbc);
        
        // Back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.addActionListener(e -> {
            new MovieSelectionScreen().setVisible(true);
            dispose();
        });
        
        gbc.gridx = 1;
        mainPanel.add(backButton, gbc);
        
        add(mainPanel);
    }
} 