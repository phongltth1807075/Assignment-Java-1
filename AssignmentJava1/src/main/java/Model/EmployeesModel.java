package Model;
import entity.Employee;

import java.sql.*;


public class EmployeesModel {

    private static Connection connection;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection =
                    DriverManager
                            .getConnection("jdbc:mysql://localhost/human_resource?user=root&password=");
        }
    }

    public boolean register(Employee employee) {
        try {
            initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into employees (Account, Email, Password, Name, Address) values (?,?,?,?,?)");
            preparedStatement.setString(1, employee.getAccount());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setString(4, employee.getName());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.execute();
            System.out.println("Đăng kí tài khoản thành công!");
            return true;
        } catch (SQLException e) {
            System.out.println("Đăng kí tài khoản không thành công!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkExistAccount(String account) {
        try {
            initConnection();
            String SQL = "SELECT * FROM employees WHERE account = ?";
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setString(1, account);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Errors: " + e.getMessage());
            return false;
        }
        return false;
    }

    public Employee login(String account, String password) {
        Employee employee = new Employee();
        try {
            initConnection();
            String SQL = "SELECT * FROM employees WHERE account = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                employee.setAccount(rs.getString(1));
                employee.setEmail(rs.getString(2));
                employee.setPassword(rs.getString(3));
                employee.setName(rs.getString(4));
                employee.setAddress(rs.getString(5));
                employee.setStatus(rs.getInt(8));
                employee.setUpdatedAt(rs.getDate(7));
                employee.setCreatedAt(rs.getDate(6));
            } else {
                return null;
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return employee;
    }


}
