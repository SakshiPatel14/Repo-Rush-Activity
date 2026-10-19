import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginFrame() {

        setTitle("Student Personal Diary - Login");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(245, 247, 250));

        // =====================================================
        // LEFT SECTION
        // =====================================================

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(55, 75, 110));
        leftPanel.setBounds(0, 0, 500, 650);

        mainPanel.add(leftPanel);

        // ---------- LOGO ----------

        JLabel logoLabel = new JLabel("📖");

        logoLabel.setFont(
                new Font("Segoe UI Emoji", Font.PLAIN, 60));

        logoLabel.setHorizontalAlignment(
                SwingConstants.CENTER);

        logoLabel.setBounds(
                150, 100, 200, 80);

        leftPanel.add(logoLabel);

        // ---------- APPLICATION NAME ----------

        JLabel nameLabel =
                new JLabel("Student Personal Diary");

        nameLabel.setFont(
                new Font("Arial", Font.BOLD, 30));

        nameLabel.setForeground(Color.WHITE);

        nameLabel.setHorizontalAlignment(
                SwingConstants.CENTER);

        nameLabel.setBounds(
                40, 200, 420, 45);

        leftPanel.add(nameLabel);

        // ---------- DESCRIPTION ----------

        JLabel descriptionLabel =
                new JLabel(
                        "<html><div style='text-align:center;'>"
                                + "Write, organize and manage your"
                                + "<br>"
                                + "personal diary entries easily."
                                + "</div></html>");

        descriptionLabel.setFont(
                new Font("Arial", Font.PLAIN, 17));

        descriptionLabel.setForeground(
                new Color(225, 230, 240));

        descriptionLabel.setHorizontalAlignment(
                SwingConstants.CENTER);

        descriptionLabel.setBounds(
                60, 270, 380, 70);

        leftPanel.add(descriptionLabel);

        // ---------- BOTTOM TEXT ----------

        JLabel bottomLabel =
                new JLabel("Your thoughts. Your memories. Your diary.");

        bottomLabel.setFont(
                new Font("Arial", Font.ITALIC, 13));

        bottomLabel.setForeground(
                new Color(210, 220, 235));

        bottomLabel.setHorizontalAlignment(
                SwingConstants.CENTER);

        bottomLabel.setBounds(
                50, 560, 400, 30);

        leftPanel.add(bottomLabel);

        // =====================================================
        // RIGHT SECTION
        // =====================================================

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(500, 0, 500, 650);

        mainPanel.add(rightPanel);

        // ---------- LOGIN TITLE ----------

        JLabel loginLabel =
                new JLabel("Welcome Back!");

        loginLabel.setFont(
                new Font("Arial", Font.BOLD, 30));

        loginLabel.setForeground(
                new Color(40, 50, 70));

        loginLabel.setHorizontalAlignment(
                SwingConstants.CENTER);

        loginLabel.setBounds(
                80, 80, 340, 45);

        rightPanel.add(loginLabel);

        // ---------- SUBTITLE ----------

        JLabel subtitleLabel =
                new JLabel("Login to continue to your diary");

        subtitleLabel.setFont(
                new Font("Arial", Font.PLAIN, 15));

        subtitleLabel.setForeground(
                new Color(110, 110, 110));

        subtitleLabel.setHorizontalAlignment(
                SwingConstants.CENTER);

        subtitleLabel.setBounds(
                80, 125, 340, 30);

        rightPanel.add(subtitleLabel);

        // =====================================================
        // EMAIL
        // =====================================================

        JLabel emailLabel =
                new JLabel("Email");

        emailLabel.setFont(
                new Font("Arial", Font.BOLD, 14));

        emailLabel.setForeground(
                new Color(60, 70, 85));

        emailLabel.setBounds(
                80, 190, 340, 25);

        rightPanel.add(emailLabel);

        emailField =
                new JTextField();

        emailField.setFont(
                new Font("Arial", Font.PLAIN, 15));

        emailField.setBounds(
                80, 220, 340, 40);

        rightPanel.add(emailField);

        // =====================================================
        // PASSWORD
        // =====================================================

        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setFont(
                new Font("Arial", Font.BOLD, 14));

        passwordLabel.setForeground(
                new Color(60, 70, 85));

        passwordLabel.setBounds(
                80, 285, 340, 25);

        rightPanel.add(passwordLabel);

        passwordField =
                new JPasswordField();

        passwordField.setFont(
                new Font("Arial", Font.PLAIN, 15));

        passwordField.setBounds(
                80, 315, 340, 40);

        rightPanel.add(passwordField);

        // =====================================================
        // LOGIN BUTTON
        // =====================================================

        JButton loginButton =
                new JButton("LOGIN");

        loginButton.setFont(
                new Font("Arial", Font.BOLD, 15));

        loginButton.setForeground(Color.WHITE);

        loginButton.setBackground(
                new Color(55, 75, 110));

        loginButton.setBounds(
                80, 385, 340, 45);

        loginButton.setFocusPainted(false);

        rightPanel.add(loginButton);

        // =====================================================
        // REGISTER TEXT
        // =====================================================

        JLabel registerLabel =
                new JLabel(
                        "Don't have an account? Register here");

        registerLabel.setFont(
                new Font("Arial", Font.PLAIN, 14));

        registerLabel.setForeground(
                new Color(80, 90, 105));

        registerLabel.setHorizontalAlignment(
                SwingConstants.CENTER);

        registerLabel.setBounds(
                80, 460, 340, 30);

        rightPanel.add(registerLabel);

        // =====================================================
        // REGISTER BUTTON
        // =====================================================

        JButton registerButton =
                new JButton("CREATE ACCOUNT");

        registerButton.setFont(
                new Font("Arial", Font.BOLD, 13));

        registerButton.setForeground(
                new Color(55, 75, 110));

        registerButton.setBackground(Color.WHITE);

        registerButton.setBounds(
                155, 500, 190, 38);

        registerButton.setFocusPainted(false);

        rightPanel.add(registerButton);

        // =====================================================
        // LOGIN ACTION
        // =====================================================

        loginButton.addActionListener(e -> loginUser());

        // =====================================================
        // REGISTER ACTION
        // =====================================================

        registerButton.addActionListener(e -> {
            new RegisterFrame();
            dispose();
        });

        // =====================================================
        // ENTER KEY LOGIN
        // =====================================================

        passwordField.addActionListener(e -> loginUser());

        // =====================================================
        // ADD MAIN PANEL
        // =====================================================

        add(mainPanel);

        setVisible(true);
    }

    // =====================================================
    // LOGIN USER
    // =====================================================

    private void loginUser() {

        String email =
                emailField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword());

        // ---------- VALIDATION ----------

        if (email.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter email and password!",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        // ---------- SQL QUERY ----------

        String sql =
                "SELECT user_id, name " +
                "FROM users " +
                "WHERE email = ? AND password = ?";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet result =
                    statement.executeQuery();

            if (result.next()) {

                int userId =
                        result.getInt("user_id");

                String name =
                        result.getString("name");

                JOptionPane.showMessageDialog(
                        this,
                        "Login successful!",
                        "Welcome",
                        JOptionPane.INFORMATION_MESSAGE);

                // Open existing dashboard
                new ViewDiaryFrame(userId);

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid email or password!",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to login!\n"
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);

            e.printStackTrace();
        }
    }
}

