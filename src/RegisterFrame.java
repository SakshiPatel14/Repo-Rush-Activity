import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterFrame extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    public RegisterFrame() {

        // =====================================================
        // WINDOW SETTINGS
        // =====================================================

        setTitle("Student Personal Diary - Register");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(
                new Color(245, 247, 250)
        );

        // =====================================================
        // LEFT SECTION
        // =====================================================

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(
                new Color(55, 75, 110)
        );

        leftPanel.setBounds(
                0, 0, 500, 650
        );

        mainPanel.add(leftPanel);

        // ---------- LOGO ----------

        JLabel logoLabel =
                new JLabel("📖");

        logoLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        60
                )
        );

        logoLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        logoLabel.setBounds(
                150, 100, 200, 80
        );

        leftPanel.add(logoLabel);

        // ---------- APPLICATION NAME ----------

        JLabel nameLabel =
                new JLabel(
                        "Student Personal Diary"
                );

        nameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        nameLabel.setForeground(
                Color.WHITE
        );

        nameLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        nameLabel.setBounds(
                40, 200, 420, 45
        );

        leftPanel.add(nameLabel);

        // ---------- DESCRIPTION ----------

        JLabel descriptionLabel =
                new JLabel(
                        "<html><div style='text-align:center;'>"
                                + "Create your personal diary account"
                                + "<br>"
                                + "and keep your memories organized."
                                + "</div></html>"
                );

        descriptionLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        17
                )
        );

        descriptionLabel.setForeground(
                new Color(225, 230, 240)
        );

        descriptionLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        descriptionLabel.setBounds(
                60, 270, 380, 70
        );

        leftPanel.add(descriptionLabel);

        // ---------- BOTTOM TEXT ----------

        JLabel bottomLabel =
                new JLabel(
                        "Your thoughts. Your memories. Your diary."
                );

        bottomLabel.setFont(
                new Font(
                        "Arial",
                        Font.ITALIC,
                        13
                )
        );

        bottomLabel.setForeground(
                new Color(210, 220, 235)
        );

        bottomLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        bottomLabel.setBounds(
                50, 560, 400, 30
        );

        leftPanel.add(bottomLabel);

        // =====================================================
        // RIGHT SECTION
        // =====================================================

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(
                Color.WHITE
        );

        rightPanel.setBounds(
                500, 0, 500, 650
        );

        mainPanel.add(rightPanel);

        // ---------- REGISTER TITLE ----------

        JLabel registerTitle =
                new JLabel(
                        "Create Account"
                );

        registerTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        registerTitle.setForeground(
                new Color(40, 50, 70)
        );

        registerTitle.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        registerTitle.setBounds(
                80, 55, 340, 45
        );

        rightPanel.add(registerTitle);

        // ---------- SUBTITLE ----------

        JLabel subtitleLabel =
                new JLabel(
                        "Create an account to start your diary"
                );

        subtitleLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        subtitleLabel.setForeground(
                new Color(110, 110, 110)
        );

        subtitleLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        subtitleLabel.setBounds(
                60, 100, 380, 30
        );

        rightPanel.add(subtitleLabel);

        // =====================================================
        // NAME
        // =====================================================

        JLabel nameFieldLabel =
                new JLabel("Full Name");

        nameFieldLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        nameFieldLabel.setForeground(
                new Color(60, 70, 85)
        );

        nameFieldLabel.setBounds(
                80, 150, 340, 25
        );

        rightPanel.add(nameFieldLabel);

        nameField =
                new JTextField();

        nameField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        nameField.setBounds(
                80, 180, 340, 40
        );

        rightPanel.add(nameField);

        // =====================================================
        // EMAIL
        // =====================================================

        JLabel emailLabel =
                new JLabel("Email");

        emailLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        emailLabel.setForeground(
                new Color(60, 70, 85)
        );

        emailLabel.setBounds(
                80, 235, 340, 25
        );

        rightPanel.add(emailLabel);

        emailField =
                new JTextField();

        emailField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        emailField.setBounds(
                80, 265, 340, 40
        );

        rightPanel.add(emailField);

        // =====================================================
        // PASSWORD
        // =====================================================

        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        passwordLabel.setForeground(
                new Color(60, 70, 85)
        );

        passwordLabel.setBounds(
                80, 320, 340, 25
        );

        rightPanel.add(passwordLabel);

        passwordField =
                new JPasswordField();

        passwordField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        passwordField.setBounds(
                80, 350, 340, 40
        );

        rightPanel.add(passwordField);

        // =====================================================
        // CREATE ACCOUNT BUTTON
        // =====================================================

        JButton registerButton =
                new JButton("CREATE ACCOUNT");

        registerButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        registerButton.setForeground(
                Color.WHITE
        );

        registerButton.setBackground(
                new Color(55, 75, 110)
        );

        registerButton.setBounds(
                80, 420, 340, 45
        );

        registerButton.setFocusPainted(
                false
        );

        rightPanel.add(registerButton);

        // =====================================================
        // LOGIN BUTTON
        // =====================================================

        JLabel loginText =
                new JLabel(
                        "Already have an account?"
                );

        loginText.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        loginText.setForeground(
                new Color(90, 90, 90)
        );

        loginText.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        loginText.setBounds(
                80, 485, 340, 25
        );

        rightPanel.add(loginText);

        JButton loginButton =
                new JButton("BACK TO LOGIN");

        loginButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        loginButton.setForeground(
                new Color(55, 75, 110)
        );

        loginButton.setBackground(
                Color.WHITE
        );

        loginButton.setBounds(
                155, 515, 190, 38
        );

        loginButton.setFocusPainted(
                false
        );

        rightPanel.add(loginButton);

        // =====================================================
        // REGISTER ACTION
        // =====================================================

        registerButton.addActionListener(
                e -> registerUser()
        );

        // =====================================================
        // LOGIN ACTION
        // =====================================================

        loginButton.addActionListener(e -> {

            new LoginFrame();

            dispose();
        });

        // =====================================================
        // ENTER KEY
        // =====================================================

        passwordField.addActionListener(
                e -> registerUser()
        );

        // =====================================================
        // ADD MAIN PANEL
        // =====================================================

        add(mainPanel);

        setVisible(true);
    }

    // =====================================================
    // REGISTER USER
    // =====================================================

    private void registerUser() {

        String name =
                nameField.getText().trim();

        String email =
                emailField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword()
                );

        // ---------- CHECK EMPTY FIELDS ----------

        if (name.isEmpty()
                || email.isEmpty()
                || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields!",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // ---------- EMAIL VALIDATION ----------

        if (!email.contains("@")
                || !email.contains(".")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid email address!",
                    "Invalid Email",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // ---------- PASSWORD VALIDATION ----------

        if (password.length() < 6) {

            JOptionPane.showMessageDialog(
                    this,
                    "Password must contain at least 6 characters!",
                    "Invalid Password",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // ---------- SQL QUERY ----------

        String sql =
                "INSERT INTO users "
                        + "(name, email, password) "
                        + "VALUES (?, ?, ?)";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    name
            );

            statement.setString(
                    2,
                    email
            );

            statement.setString(
                    3,
                    password
            );

            statement.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Account created successfully!",
                    "Registration Successful",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // ---------- CLEAR FIELDS ----------

            nameField.setText("");

            emailField.setText("");

            passwordField.setText("");

        } catch (SQLException e) {

            if (e.getMessage().contains(
                    "Duplicate")) {

                JOptionPane.showMessageDialog(
                        this,
                        "This email is already registered!",
                        "Registration Failed",
                        JOptionPane.ERROR_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Registration failed!\n"
                                + e.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
