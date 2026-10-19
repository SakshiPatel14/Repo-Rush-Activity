import javax.swing.*;
import java.awt.*;

public class ViewEntryFrame extends JFrame {

    public ViewEntryFrame(
            String title,
            String content,
            String category,
            String date
    ) {

        // ---------- FRAME ----------

        setTitle("Student Personal Diary - View Entry");
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // ---------- MAIN PANEL ----------

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(245, 247, 250));

        // ---------- HEADER ----------

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBackground(new Color(35, 47, 62));
        headerPanel.setBounds(0, 0, 800, 80);

        JLabel logoLabel = new JLabel("📖");
        logoLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        logoLabel.setBounds(30, 20, 45, 40);
        headerPanel.add(logoLabel);

        JLabel headingLabel =
                new JLabel("View Diary Entry");

        headingLabel.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        headingLabel.setForeground(Color.WHITE);
        headingLabel.setBounds(80, 18, 300, 35);

        headerPanel.add(headingLabel);

        JLabel subtitleLabel =
                new JLabel("Your personal diary");

        subtitleLabel.setFont(
                new Font("Arial", Font.PLAIN, 13)
        );

        subtitleLabel.setForeground(
                new Color(210, 215, 220)
        );

        subtitleLabel.setBounds(82, 48, 250, 20);

        headerPanel.add(subtitleLabel);

        mainPanel.add(headerPanel);

        // ---------- ENTRY CARD ----------

        JPanel entryPanel = new JPanel();
        entryPanel.setLayout(null);
        entryPanel.setBackground(Color.WHITE);

        entryPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(220, 225, 230)
                )
        );

        entryPanel.setBounds(45, 105, 710, 465);

        mainPanel.add(entryPanel);

        // ---------- TITLE ----------

        JLabel titleLabel =
                new JLabel("TITLE");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 12)
        );

        titleLabel.setForeground(
                new Color(100, 110, 120)
        );

        titleLabel.setBounds(30, 25, 100, 20);

        entryPanel.add(titleLabel);

        JLabel titleValue =
                new JLabel(title);

        titleValue.setFont(
                new Font("Arial", Font.BOLD, 21)
        );

        titleValue.setForeground(
                new Color(35, 47, 62)
        );

        titleValue.setBounds(30, 48, 650, 35);

        entryPanel.add(titleValue);

        // ---------- CATEGORY ----------

        JLabel categoryLabel =
                new JLabel("CATEGORY");

        categoryLabel.setFont(
                new Font("Arial", Font.BOLD, 12)
        );

        categoryLabel.setForeground(
                new Color(100, 110, 120)
        );

        categoryLabel.setBounds(30, 95, 100, 20);

        entryPanel.add(categoryLabel);

        JLabel categoryValue =
                new JLabel(category);

        categoryValue.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        categoryValue.setForeground(
                new Color(60, 100, 160)
        );

        categoryValue.setBounds(30, 118, 250, 25);

        entryPanel.add(categoryValue);

        // ---------- DATE ----------

        JLabel dateLabel =
                new JLabel("DATE");

        dateLabel.setFont(
                new Font("Arial", Font.BOLD, 12)
        );

        dateLabel.setForeground(
                new Color(100, 110, 120)
        );

        dateLabel.setBounds(350, 95, 100, 20);

        entryPanel.add(dateLabel);

        JLabel dateValue =
                new JLabel(date);

        dateValue.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        dateValue.setForeground(
                new Color(70, 80, 90)
        );

        dateValue.setBounds(350, 118, 320, 25);

        entryPanel.add(dateValue);

        // ---------- CONTENT ----------

        JLabel contentLabel =
                new JLabel("CONTENT");

        contentLabel.setFont(
                new Font("Arial", Font.BOLD, 12)
        );

        contentLabel.setForeground(
                new Color(100, 110, 120)
        );

        contentLabel.setBounds(30, 160, 100, 20);

        entryPanel.add(contentLabel);

        JTextArea contentArea =
                new JTextArea(content);

        contentArea.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        contentArea.setForeground(
                new Color(50, 55, 60)
        );

        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setEditable(false);

        contentArea.setBackground(
                new Color(248, 249, 250)
        );

        contentArea.setBorder(
                BorderFactory.createEmptyBorder(
                        12, 12, 12, 12
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(contentArea);

        scrollPane.setBounds(
                30, 185, 650, 190
        );

        scrollPane.setBorder(
                BorderFactory.createLineBorder(
                        new Color(225, 228, 232)
                )
        );

        entryPanel.add(scrollPane);

        // ---------- CLOSE BUTTON ----------

        JButton closeButton =
                new JButton("CLOSE");

        closeButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        closeButton.setForeground(Color.WHITE);

        closeButton.setBackground(
                new Color(35, 47, 62)
        );

        closeButton.setBounds(
                285, 395, 140, 42
        );

        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        entryPanel.add(closeButton);

        // ---------- BUTTON ACTION ----------

        closeButton.addActionListener(e -> {
            dispose();
        });

        // ---------- ADD PANEL ----------

        add(mainPanel);

        setVisible(true);
    }
}
