import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewDiaryFrame extends JFrame {

        private int userId;

        private JTable diaryTable;
        private DefaultTableModel tableModel;
        private JTextField searchField;

        public ViewDiaryFrame(int userId) {

                this.userId = userId;

                // =====================================================
                // WINDOW SETTINGS
                // =====================================================

                setTitle("Student Personal Diary - My Diary");
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
                                new Color(245, 247, 250));

                // =====================================================
                // HEADER
                // =====================================================

                JPanel headerPanel = new JPanel();
                headerPanel.setLayout(null);
                headerPanel.setBackground(
                                new Color(55, 75, 110));

                headerPanel.setBounds(
                                0, 0, 1000, 100);

                mainPanel.add(headerPanel);

                // ---------- APP NAME ----------

                JLabel appLabel = new JLabel("📖  Student Personal Diary");

                appLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                24));

                appLabel.setForeground(
                                Color.WHITE);

                appLabel.setBounds(
                                35, 20, 400, 35);

                headerPanel.add(appLabel);

                // ---------- WELCOME TEXT ----------

                JLabel welcomeLabel = new JLabel("My Diary");

                welcomeLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.PLAIN,
                                                16));

                welcomeLabel.setForeground(
                                new Color(220, 225, 235));

                welcomeLabel.setBounds(
                                38, 58, 300, 25);

                headerPanel.add(welcomeLabel);

                // =====================================================
                // LOGOUT BUTTON
                // =====================================================

                JButton logoutButton = new JButton("LOGOUT");

                logoutButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                13));

                logoutButton.setForeground(
                                new Color(55, 75, 110));

                logoutButton.setBackground(
                                Color.WHITE);

                logoutButton.setBounds(
                                850, 30, 110, 38);

                logoutButton.setFocusPainted(
                                false);

                headerPanel.add(logoutButton);

                // =====================================================
                // PAGE TITLE
                // =====================================================

                JLabel titleLabel = new JLabel("Your Diary Entries");

                titleLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                25));

                titleLabel.setForeground(
                                new Color(40, 50, 70));

                titleLabel.setBounds(
                                40, 125, 350, 35);

                mainPanel.add(titleLabel);

                // =====================================================
                // ADD ENTRY BUTTON
                // =====================================================

                JButton addButton = new JButton("+ ADD ENTRY");

                addButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                addButton.setForeground(
                                Color.WHITE);

                addButton.setBackground(
                                new Color(55, 75, 110));

                addButton.setBounds(
                                810, 120, 150, 42);

                addButton.setFocusPainted(
                                false);

                mainPanel.add(addButton);

                // =====================================================
                // SEARCH AREA
                // =====================================================

                JLabel searchLabel = new JLabel("Search");

                searchLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                searchLabel.setForeground(
                                new Color(60, 70, 85));

                searchLabel.setBounds(
                                40, 175, 70, 30);

                mainPanel.add(searchLabel);

                searchField = new JTextField();

                searchField.setFont(
                                new Font(
                                                "Arial",
                                                Font.PLAIN,
                                                14));

                searchField.setBounds(
                                105, 173, 570, 35);

                mainPanel.add(searchField);

                // =====================================================
                // SEARCH BUTTON
                // =====================================================

                JButton searchButton = new JButton("SEARCH");

                searchButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                13));

                searchButton.setForeground(
                                Color.WHITE);

                searchButton.setBackground(
                                new Color(80, 100, 135));

                searchButton.setBounds(
                                690, 173, 110, 35);

                searchButton.setFocusPainted(
                                false);

                mainPanel.add(searchButton);

                // =====================================================
                // CLEAR BUTTON
                // =====================================================

                JButton clearButton = new JButton("CLEAR");

                clearButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                13));

                clearButton.setBounds(
                                810, 173, 110, 35);

                clearButton.setFocusPainted(
                                false);

                mainPanel.add(clearButton);

                // =====================================================
                // TABLE
                // =====================================================

                tableModel = new DefaultTableModel(
                                new String[] {
                                                "ID",
                                                "Title",
                                                "Content",
                                                "Category",
                                                "Date"
                                },
                                0) {

                        @Override
                        public boolean isCellEditable(
                                        int row,
                                        int column) {
                                return false;
                        }
                };

                diaryTable = new JTable(tableModel);

                diaryTable.setFont(
                                new Font(
                                                "Arial",
                                                Font.PLAIN,
                                                13));

                diaryTable.setRowHeight(32);

                diaryTable.setSelectionMode(
                                ListSelectionModel.SINGLE_SELECTION);

                diaryTable.getTableHeader().setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                13));

                // ---------- COLUMN WIDTHS ----------

                diaryTable.getColumnModel()
                                .getColumn(0)
                                .setPreferredWidth(50);

                diaryTable.getColumnModel()
                                .getColumn(1)
                                .setPreferredWidth(150);

                diaryTable.getColumnModel()
                                .getColumn(2)
                                .setPreferredWidth(340);

                diaryTable.getColumnModel()
                                .getColumn(3)
                                .setPreferredWidth(110);

                diaryTable.getColumnModel()
                                .getColumn(4)
                                .setPreferredWidth(170);

                JScrollPane scrollPane = new JScrollPane(diaryTable);

                scrollPane.setBounds(
                                40, 220, 920, 270);

                mainPanel.add(scrollPane);

                // =====================================================
                // VIEW BUTTON
                // =====================================================

                JButton viewButton = new JButton("VIEW");

                viewButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                viewButton.setBounds(
                                40, 520, 120, 40);

                viewButton.setFocusPainted(
                                false);

                mainPanel.add(viewButton);

                // =====================================================
                // EDIT BUTTON
                // =====================================================

                JButton editButton = new JButton("EDIT");

                editButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                editButton.setBounds(
                                180, 520, 120, 40);

                editButton.setFocusPainted(
                                false);

                mainPanel.add(editButton);

                // =====================================================
                // DELETE BUTTON
                // =====================================================

                JButton deleteButton = new JButton("DELETE");

                deleteButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                deleteButton.setBounds(
                                320, 520, 120, 40);

                deleteButton.setFocusPainted(
                                false);

                mainPanel.add(deleteButton);

                // =====================================================
                // REFRESH BUTTON
                // =====================================================

                JButton refreshButton = new JButton("REFRESH");

                refreshButton.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                14));

                refreshButton.setBounds(
                                460, 520, 120, 40);

                refreshButton.setFocusPainted(
                                false);

                mainPanel.add(refreshButton);

                // =====================================================
                // BUTTON ACTIONS
                // =====================================================

                addButton.addActionListener(e -> {
                        new AddEntryFrame(userId, this);
                });

                searchButton.addActionListener(e -> {
                        searchDiary();
                });

                clearButton.addActionListener(e -> {

                        searchField.setText("");

                        loadDiaryEntries();
                });

                viewButton.addActionListener(e -> {
                        viewEntry();
                });

                editButton.addActionListener(e -> {
                        editEntry();
                });

                deleteButton.addActionListener(e -> {
                        deleteEntry();
                });

                refreshButton.addActionListener(e -> {

                        searchField.setText("");

                        loadDiaryEntries();
                });

                // =====================================================
                // LOGOUT ACTION
                // =====================================================

                logoutButton.addActionListener(e -> {

                        int confirm = JOptionPane.showConfirmDialog(
                                        this,
                                        "Are you sure you want to logout?",
                                        "Confirm Logout",
                                        JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {

                                new LoginFrame();

                                dispose();
                        }
                });

                // =====================================================
                // DOUBLE CLICK TO VIEW
                // =====================================================

                diaryTable.addMouseListener(
                                new java.awt.event.MouseAdapter() {

                                        @Override
                                        public void mouseClicked(
                                                        java.awt.event.MouseEvent e) {

                                                if (e.getClickCount() == 2) {

                                                        viewEntry();
                                                }
                                        }
                                });

                // =====================================================
                // ADD MAIN PANEL
                // =====================================================

                add(mainPanel);

                // Load entries
                loadDiaryEntries();

                setVisible(true);
        }

        // =====================================================
        // LOAD DIARY ENTRIES
        // =====================================================

        public void loadDiaryEntries() {

                tableModel.setRowCount(0);

                String sql = "SELECT entry_id, title, content, category, entry_date "
                                + "FROM diary_entries "
                                + "WHERE user_id = ? "
                                + "ORDER BY entry_date DESC";

                try (
                                Connection connection = DBConnection.getConnection();

                                PreparedStatement statement = connection.prepareStatement(sql)) {

                        statement.setInt(
                                        1,
                                        userId);

                        ResultSet result = statement.executeQuery();

                        while (result.next()) {

                                tableModel.addRow(
                                                new Object[] {

                                                                result.getInt(
                                                                                "entry_id"),

                                                                result.getString(
                                                                                "title"),

                                                                result.getString(
                                                                                "content"),

                                                                result.getString(
                                                                                "category"),

                                                                result.getTimestamp(
                                                                                "entry_date")
                                                });
                        }

                } catch (Exception e) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Unable to load diary entries!\n"
                                                        + e.getMessage(),
                                        "Database Error",
                                        JOptionPane.ERROR_MESSAGE);

                        e.printStackTrace();
                }
        }

        // =====================================================
        // ADD ENTRY
        // =====================================================



// =====================================================
// EDIT ENTRY
// =====================================================

private void editEntry() {

        int selectedRow = diaryTable.getSelectedRow();

        // ---------- CHECK SELECTION ----------

        if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                                this,
                                "Please select a diary entry to edit!",
                                "No Entry Selected",
                                JOptionPane.WARNING_MESSAGE);

                return;
        }

        // ---------- GET ENTRY DATA ----------

        int entryId = Integer.parseInt(
                        tableModel.getValueAt(
                                        selectedRow,
                                        0).toString());

        String title = tableModel.getValueAt(
                        selectedRow,
                        1).toString();

        String content = tableModel.getValueAt(
                        selectedRow,
                        2).toString();

        String category = tableModel.getValueAt(
                        selectedRow,
                        3).toString();

        // ---------- OPEN EDIT WINDOW ----------

        new EditEntryFrame(
                        entryId,
                        userId,
                        title,
                        content,
                        category,
                        this);
}


        // =====================================================
        // DELETE ENTRY
        // =====================================================

        private void deleteEntry() {

                int selectedRow = diaryTable.getSelectedRow();

                if (selectedRow == -1) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Please select a diary entry to delete!",
                                        "No Entry Selected",
                                        JOptionPane.WARNING_MESSAGE);

                        return;
                }

                int entryId = Integer.parseInt(
                                tableModel.getValueAt(
                                                selectedRow,
                                                0).toString());

                String title = tableModel.getValueAt(
                                selectedRow,
                                1).toString();

                int confirm = JOptionPane.showConfirmDialog(
                                this,
                                "Are you sure you want to delete:\n\n"
                                                + title + "?",
                                "Confirm Delete",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE);

                if (confirm != JOptionPane.YES_OPTION) {

                        return;
                }

                String sql = "DELETE FROM diary_entries "
                                + "WHERE entry_id = ? "
                                + "AND user_id = ?";

                try (
                                Connection connection = DBConnection.getConnection();

                                PreparedStatement statement = connection.prepareStatement(sql)) {

                        statement.setInt(
                                        1,
                                        entryId);

                        statement.setInt(
                                        2,
                                        userId);

                        int rows = statement.executeUpdate();

                        if (rows > 0) {

                                JOptionPane.showMessageDialog(
                                                this,
                                                "Diary entry deleted successfully!",
                                                "Success",
                                                JOptionPane.INFORMATION_MESSAGE);

                                loadDiaryEntries();

                        } else {

                                JOptionPane.showMessageDialog(
                                                this,
                                                "Entry could not be deleted.",
                                                "Delete Failed",
                                                JOptionPane.ERROR_MESSAGE);
                        }

                } catch (Exception e) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Unable to delete entry!\n"
                                                        + e.getMessage(),
                                        "Database Error",
                                        JOptionPane.ERROR_MESSAGE);

                        e.printStackTrace();
                }
        }

        // =====================================================
        // VIEW ENTRY
        // =====================================================

        private void viewEntry() {

                int selectedRow = diaryTable.getSelectedRow();

                if (selectedRow == -1) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Please select a diary entry to view!",
                                        "No Entry Selected",
                                        JOptionPane.WARNING_MESSAGE);

                        return;
                }

                String title = tableModel.getValueAt(
                                selectedRow,
                                1).toString();

                String content = tableModel.getValueAt(
                                selectedRow,
                                2).toString();

                String category = tableModel.getValueAt(
                                selectedRow,
                                3).toString();

                String date = tableModel.getValueAt(
                                selectedRow,
                                4).toString();

                new ViewEntryFrame(
                                title,
                                content,
                                category,
                                date);
        }

        // =====================================================
        // SEARCH DIARY
        // =====================================================

        private void searchDiary() {

                String searchText = searchField.getText().trim();

                if (searchText.isEmpty()) {

                        loadDiaryEntries();

                        return;
                }

                tableModel.setRowCount(0);

                String sql = "SELECT entry_id, title, content, category, entry_date "
                                + "FROM diary_entries "
                                + "WHERE user_id = ? "
                                + "AND (title LIKE ? "
                                + "OR content LIKE ? "
                                + "OR category LIKE ?) "
                                + "ORDER BY entry_date DESC";

                try (
                                Connection connection = DBConnection.getConnection();

                                PreparedStatement statement = connection.prepareStatement(sql)) {

                        String searchPattern = "%" + searchText + "%";

                        statement.setInt(
                                        1,
                                        userId);

                        statement.setString(
                                        2,
                                        searchPattern);

                        statement.setString(
                                        3,
                                        searchPattern);

                        statement.setString(
                                        4,
                                        searchPattern);

                        ResultSet result = statement.executeQuery();

                        while (result.next()) {

                                tableModel.addRow(
                                                new Object[] {

                                                                result.getInt(
                                                                                "entry_id"),

                                                                result.getString(
                                                                                "title"),

                                                                result.getString(
                                                                                "content"),

                                                                result.getString(
                                                                                "category"),

                                                                result.getTimestamp(
                                                                                "entry_date")
                                                });
                        }

                        if (tableModel.getRowCount() == 0) {

                                JOptionPane.showMessageDialog(
                                                this,
                                                "No diary entries found!",
                                                "Search Result",
                                                JOptionPane.INFORMATION_MESSAGE);
                        }

                } catch (Exception e) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Unable to search diary entries!\n"
                                                        + e.getMessage(),
                                        "Database Error",
                                        JOptionPane.ERROR_MESSAGE);

                        e.printStackTrace();
                }
        }
}
