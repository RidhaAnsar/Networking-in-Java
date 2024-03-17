import java.sql.*;
class Employee {
    private int eno;
    private String ename;
    private double esal;

    public Employee(int eno, String ename, double esal) {
        this.eno = eno;
        this.ename = ename;
        this.esal = esal;
    }

    public int getEno() {
        return eno;
    }

    public String getEname() {
        return ename;
    }

    public double getEsal() {
        return esal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", esal=" + esal +
                '}';
    }
}

// DatabaseConnector class responsible for database connectivity and operations
class DatabaseConnectorUsingOOPS {
    private Connection connection;

    // Constructor to initialize database connection
    public DatabaseConnector(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    // Method to fetch employees from the database
    public Employee[] getEmployees() throws SQLException {
        String query = "SELECT * FROM Employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        // Count the number of rows in the ResultSet
        resultSet.last();
        int rowCount = resultSet.getRow();
        resultSet.beforeFirst();

        // Create an array to store employees
        Employee[] employees = new Employee[rowCount];

        int index = 0;
        while (resultSet.next()) {
            int eno = resultSet.getInt("eno");
            String ename = resultSet.getString("ename");
            double esal = resultSet.getDouble("esal");
            employees[index] = new Employee(eno, ename, esal);
            index++;
        }

        return employees;
    }

    // Method to close the database connection
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

public class DatabaseConnectivityDemo {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try {
            // Connect to the database
            DatabaseConnector connector = new DatabaseConnector(url, username, password);

            // Fetch employees from the database
            Employee[] employees = connector.getEmployees();

            // Display employees
            for (Employee employee : employees) {
                System.out.println(employee);
            }

            // Close the database connection
            connector.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
