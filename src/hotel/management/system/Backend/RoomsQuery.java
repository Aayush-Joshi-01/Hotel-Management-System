package hotel.management.system.Backend;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class RoomsQuery extends JFrame {
    private JTable resultTable;
    public RoomsQuery() {
        setTitle("Query Result Table Example");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create and add components to the frame
        resultTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane);

        // Fetch data from the database and populate the JTable
        fetchQueryResultsFromDatabase();

        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void fetchQueryResultsFromDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/hotel", "root", "1234567890")) {
            Statement statement = connection.createStatement();

            // Replace "SELECT * FROM YourTable" with your actual query
            String query = "SELECT * FROM Room";
            ResultSet resultSet = statement.executeQuery(query);

            // Populate the JTable with query results
            resultTable.setModel(buildTableModel(resultSet));

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from the database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // Get column names
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }

        // Get data rows
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        while (resultSet.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        }

        return tableModel;
    }
    public static void roomsQuery() {
        SwingUtilities.invokeLater(RoomsQuery::new);
    }
}

