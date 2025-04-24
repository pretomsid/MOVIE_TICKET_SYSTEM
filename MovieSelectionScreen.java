import javax.swing.*;
import java.awt.*;

/**
 * Screen for selecting a movie from the available options.
 */
public class MovieSelectionScreen extends JFrame {
    private final String[] movies = {
        "The Dark Knight",
        "Inception",
        "Interstellar",
        "The Matrix",
        "Pulp Fiction"
    };
    
    public MovieSelectionScreen() {
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("Select Movie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Title label
        JLabel titleLabel = new JLabel("Select a Movie", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);
        
        // Movie dropdown
        JComboBox<String> movieComboBox = new JComboBox<>(movies);
        movieComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(movieComboBox, gbc);
        
        // Next button
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 14));
        nextButton.addActionListener(e -> {
            String selectedMovie = (String) movieComboBox.getSelectedItem();
            new ShowtimeSelectionScreen(selectedMovie).setVisible(true);
            dispose();
        });
        
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainPanel.add(nextButton, gbc);
        
        // Back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.addActionListener(e -> {
            new WelcomeScreen().setVisible(true);
            dispose();
        });
        
        gbc.gridx = 1;
        mainPanel.add(backButton, gbc);
        
        add(mainPanel);
    }
} 