import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEntryFrame extends JFrame {

        private int userId;
        private ViewDiaryFrame diaryFrame;

        private JTextField titleField;
        private JTextArea contentArea;
        private JComboBox<String> categoryBox;

        public AddEntryFrame(int userId, ViewDiaryFrame diaryFrame) {
                this.userId = userId;
                this.diaryFrame = diaryFrame;
                // =====================================================
                // WINDOW SETTINGS
                // =====================================================

                setTitle("Student Personal Diary - Add Entry");
                setSize(750, 650);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setLocationRelativeTo(null);
                setResizable(false);

                // =====================================================
                // MAIN PANEL
                // =====================================================

                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(null);
                mainPanel.setBackground(
                                new Color(245, 247, 250));

                // =====================================================
                // HEADER
                // =====================================================

                JPanel headerPanel = new JPanel();
                headerPanel.setLayout(null);
                headerPanel.setBackground(
                                new Color(55, 75, 110));

                headerPanel.setBounds(
                                0, 0, 750, 95);

                mainPanel.add(headerPanel);

                // ---------- HEADER TITLE ----------

                JLabel headerLabel = new JLabel("📖  Student Personal Diary");

                headerLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                24));

                headerLabel.setForeground(
                                Color.WHITE);

                headerLabel.setBounds(
                                30, 20, 400, 35);

                headerPanel.add(headerLabel);

                JLabel headerSubtitle = new JLabel("Create a new diary entry");

                headerSubtitle.setFont(
                                new Font(
                                                "Arial",
                                                Font.PLAIN,
                                                15));

                headerSubtitle.setForeground(
                                new Color(220, 225, 235));

                headerSubtitle.setBounds(
                                32, 55, 300, 25);

                headerPanel.add(headerSubtitle);

                // =====================================================
                // PAGE TITLE
                // =====================================================

                JLabel headingLabel = new JLabel("Add Diary Entry");

                headingLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                25));

                headingLabel.setForeground(
                                new Color(40, 50, 70));

                headingLabel.setBounds(
                                50, 120, 300, 35);

                mainPanel.add(headingLabel);

                // =====================================================
                // TITLE
                // =====================================================

                JLabel titleLabel = new JLabel("Diary Title");

                titleLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                titleLabel.setForeground(
                                new Color(60, 70, 85));

                titleLabel.setBounds(
                                50, 175, 200, 25);

                mainPanel.add(titleLabel);

                titleField = new JTextField();

                titleField.setFont(
                                new Font(
                                                "Arial",
                                                Font.PLAIN,
                                                15));

                titleField.setBounds(
                                50, 205, 650, 40);

                mainPanel.add(titleField);

                // =====================================================
                // CATEGORY
                // =====================================================

                JLabel categoryLabel = new JLabel("Category");

                categoryLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                categoryLabel.setForeground(
                                new Color(60, 70, 85));

                categoryLabel.setBounds(
                                50, 270, 200, 25);

                mainPanel.add(categoryLabel);

                String[] categories = {

                                "Personal",
                                "College",
                                "Study",
                                "Travel",
                                "Friends",
                                "Other"
                };

                categoryBox = new JComboBox<>(
                                categories);

                categoryBox.setFont(
                                new Font(
                                                "Arial",
                                                Font.PLAIN,
                                                14));

                categoryBox.setBounds(
                                50, 300, 650, 38);

                mainPanel.add(categoryBox);

                // =====================================================
                // CONTENT
                // =====================================================

                JLabel contentLabel = new JLabel("Diary Content");

                contentLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                contentLabel.setForeground(
                                new Color(60, 70, 85));

                contentLabel.setBounds(
                                50, 355, 200, 25);

                mainPanel.add(contentLabel);

                contentArea = new JTextArea();

                contentArea.setFont(
                                new Font(
                                                "Arial",
                                                Font.PLAIN,
                                                15));

                contentArea.setLineWrap(true);
                contentArea.setWrapStyleWord(true);

                contentArea.setMargin(
                                new Insets(
                                                8, 8, 8, 8));

                JScrollPane scrollPane = new JScrollPane(
                                contentArea);

                scrollPane.setBounds(
                                50, 385, 650, 120);

                mainPanel.add(scrollPane);

                // =====================================================
                // SAVE BUTTON
                // =====================================================

                JButton saveButton = new JButton("SAVE ENTRY");

                saveButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                saveButton.setForeground(
                                Color.WHITE);

                saveButton.setBackground(
                                new Color(55, 75, 110));

                saveButton.setBounds(
                                180, 535, 170, 42);

                saveButton.setFocusPainted(
                                false);

                mainPanel.add(saveButton);

                // =====================================================
                // CANCEL BUTTON
                // =====================================================

                JButton cancelButton = new JButton("CANCEL");

                cancelButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                cancelButton.setBounds(
                                400, 535, 170, 42);

                cancelButton.setFocusPainted(
                                false);

                mainPanel.add(cancelButton);

                // =====================================================
                // BUTTON ACTIONS
                // =====================================================

                saveButton.addActionListener(
                                e -> saveEntry());

                cancelButton.addActionListener(
                                e -> dispose());

                // =====================================================
                // ENTER / CTRL + ENTER
                // =====================================================

                contentArea.getInputMap(
                                JComponent.WHEN_FOCUSED).put(
                                                KeyStroke.getKeyStroke(
                                                                "ctrl ENTER"),
                                                "saveEntry");

                contentArea.getActionMap().put(
                                "saveEntry",
                                new AbstractAction() {

                                        @Override
                                        public void actionPerformed(
                                                        java.awt.event.ActionEvent e) {

                                                saveEntry();
                                        }
                                });

                // =====================================================
                // MAIN PANEL
                // =====================================================

                add(mainPanel);

                setVisible(true);
        }

        // =====================================================
        // SAVE ENTRY
        // =====================================================

        private void saveEntry() {

                String title = titleField
                                .getText()
                                .trim();

                String content = contentArea
                                .getText()
                                .trim();

                String category = categoryBox
                                .getSelectedItem()
                                .toString();

                // =====================================================
                // VALIDATION
                // =====================================================

                if (title.isEmpty()
                                || content.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Please enter diary title and content!",
                                        "Missing Information",
                                        JOptionPane.WARNING_MESSAGE);

                        return;
                }

                // =====================================================
                // SQL QUERY
                // =====================================================

                String sql = "INSERT INTO diary_entries "
                                + "(user_id, title, content, category) "
                                + "VALUES (?, ?, ?, ?)";

                try (
                                Connection connection = DBConnection.getConnection();

                                PreparedStatement statement = connection.prepareStatement(sql)) {

                        statement.setInt(
                                        1,
                                        userId);

                        statement.setString(
                                        2,
                                        title);

                        statement.setString(
                                        3,
                                        content);

                        statement.setString(
                                        4,
                                        category);

                        statement.executeUpdate();

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Diary entry saved successfully!",
                                        "Success",
                                        JOptionPane.INFORMATION_MESSAGE);

                        // =================================================
                        // REFRESH MY DIARY
                        // =================================================
                        diaryFrame.loadDiaryEntries();

                        // =================================================
                        // CLOSE WINDOW
                        // =================================================

                        dispose();

                } catch (Exception e) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Unable to save diary entry!\n"
                                                        + e.getMessage(),
                                        "Database Error",
                                        JOptionPane.ERROR_MESSAGE);

                        e.printStackTrace();
                }
        }
}
