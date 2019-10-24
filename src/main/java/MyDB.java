import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class MyDB {

    public static void main(String[] args) {


        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/catlister_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM ads";
            ResultSet resultSet = stmt.executeQuery(sql);

            while(resultSet.next()){
                System.out.println("resultSet.getLong(2) = " + resultSet.getLong(2));
                System.out.println("resultSet.getLong(2) = " + resultSet.getString(3));
            }

            stmt.execute("DELETE from ads where user_id = 1");

            resultSet = stmt.executeQuery(sql);

            while(resultSet.next()){
                System.out.println("resultSet.getLong(2) = " + resultSet.getLong(2));
                System.out.println("resultSet.getLong(2) = " + resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
