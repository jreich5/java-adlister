import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements  Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
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
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
//        select * from ads
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            while(rs.next()){
                ads.add(translateRStoAd(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    private Ad translateRStoAd(ResultSet rs){
        try {
            return new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long insert(Ad ad) {
        // insert into ads (title, description, user_id, personality_type, images) values(x,x,x,x,x,x);
        try {
            Statement statement = connection.createStatement();
            String sql = String.format("insert into ads (title, description, user_id, personality_type, images) values('%s', '%s', %d, 'calm', null)", ad.getTitle(), ad.getDescription(), ad.getUserId());
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs =  statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
