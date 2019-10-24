import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class MyDB {

    public static void main(String[] args) {


        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/employees?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM employees limit 5";
            ResultSet resultSet = stmt.executeQuery(sql);

            while(resultSet.next()){
                System.out.println("resultSet.getLong(emp_no) = " + resultSet.getLong("emp_no"));
                System.out.println("resultSet = " + resultSet.getString("first_name"));
                System.out.println("resultSet.getString(\"gender\") = " + resultSet.getString("gender"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
