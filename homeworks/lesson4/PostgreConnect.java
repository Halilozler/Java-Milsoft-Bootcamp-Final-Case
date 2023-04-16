package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnect {
    private Connection connection;
    public PostgreConnect() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "mysecretpassword";
        String driver = "org.postgresql.Driver";
        Class.forName(driver).newInstance();

        connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        return connection;
    }
}
