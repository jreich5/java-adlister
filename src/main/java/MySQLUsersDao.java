import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {

    Connection connection;

    public MySQLUsersDao(){
        try {

            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public long insert(User user) {
        try {
            Statement stmt = connection.createStatement();

            String sql = String.format("insert into users (username, email, password, preferences) values('%s', '%s', '%s', 'asd')", user.getUsername(), user.getEmail(), user.getPassword());

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
