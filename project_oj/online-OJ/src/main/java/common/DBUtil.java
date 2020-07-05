package common;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//借助这个类和数据库建立连接，进一步操作数据库
public class DBUtil {
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/project_oj ? characterEncoding = utf8 & useSSL = true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    //单例模式
    private static volatile DataSource dataSource = null;

    private DBUtil() {
    }

    //懒汉模式实现单例
    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDatasource) dataSource).setURL(URL);
                    ((MysqlDatasource) dataSource).setUser(USERNAME);
                    ((MysqlDatasource) dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            //内置数据库连接池
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭顺序和申请顺序相反
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}