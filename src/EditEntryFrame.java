import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditEntryFrame extends JFrame {

    private int entryId;
    private int userId;
    private ViewDiaryFrame diaryFrame;

    private JTextField titleField;
    private JComboBox<String> categoryBox;
    private JTextArea contentArea;

    public EditEntryFrame(
            int entryId,
            int userId,
            String title,
            String content,
            String category,
            ViewDiaryFrame diaryFrame) {

        this.entryId = entryId;
        this.userId = userId;
        this.diaryFrame = diaryFrame;

        // =====================================================
        // WINDOW SETTINGS
        // =====================================================

        setTitle("Student Personal Diary - Edit Entry");
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

        JLabel headerLabel = new JLabel("📖  Student Personal Diary");

        headerLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        headerLabel.setForeground(Color.WHITE);

        headerLabel.setBounds(
                30, 20, 400, 35);

        headerPanel.add(headerLabel);

        JLabel headerSubtitle = new JLabel("Edit your diary entry");

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

        JLabel headingLabel = new JLabel("Edit Diary Entry");

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

        titleField = new JTextField(title);

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

        categoryBox = new JComboBox<>(categories);

        categoryBox.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14));

        categoryBox.setBounds(
                50, 300, 650, 38);

        categoryBox.setSelectedItem(category);

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

        contentArea = new JTextArea(content);

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

        JScrollPane scrollPane = new JScrollPane(contentArea);

        scrollPane.setBounds(
                50, 385, 650, 120);

        mainPanel.add(scrollPane);

        // =====================================================
        // UPDATE BUTTON
        // =====================================================

        JButton updateButton = new JButton("UPDATE ENTRY");

        updateButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14));

        updateButton.setForeground(Color.WHITE);

        updateButton.setBackground(
                new Color(55, 75, 110));

        updateButton.setBounds(
                180, 535, 170, 42);

        updateButton.setFocusPainted(false);

        mainPanel.add(updateButton);

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

        cancelButton.setFocusPainted(false);

        mainPanel.add(cancelButton);

        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        updateButton.addActionListener(
                e -> updateEntry());

        cancelButton.addActionListener(
                e -> dispose());

        // =====================================================
        // CTRL + ENTER
        // =====================================================

        contentArea.getInputMap(
                JComponent.WHEN_FOCUSED).put(
                        KeyStroke.getKeyStroke(
                                "ctrl ENTER"),
                        "updateEntry");

        contentArea.getActionMap().put(
                "updateEntry",
                new AbstractAction() {

                    @Override
                    public void actionPerformed(
                            java.awt.event.ActionEvent e) {
                        updateEntry();
                    }
                });

        // =====================================================
        // MAIN PANEL
        // =====================================================

        add(mainPanel);

        setVisible(true);
    }

    // =====================================================
    // UPDATE ENTRY
    // =====================================================

    private void updateEntry() {

        String title = titleField.getText().trim();

        String content = contentArea.getText().trim();

        String category = categoryBox
                .getSelectedItem()
                .toString();

        // =====================================================
        // VALIDATION
        // =====================================================

        if (title.isEmpty() ||
                content.isEmpty()) {

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

        String sql = "UPDATE diary_entries "
                + "SET title = ?, content = ?, category = ? "
                + "WHERE entry_id = ? AND user_id = ?";

        try (
                Connection connection = DBConnection.getConnection();

                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(
                    1, title);

            statement.setString(
                    2, content);

            statement.setString(
                    3, category);

            statement.setInt(
                    4, entryId);

            statement.setInt(
                    5, userId);
            int rows = statement.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Diary entry updated successfully!",
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

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Entry could not be updated.",
                        "Update Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to update diary entry!\n"
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);

            e.printStackTrace();
        }
    }
}
