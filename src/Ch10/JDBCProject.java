package Ch10;

import java.sql.*;

public class JDBCProject {
    public static void main(String[] args ) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            //注册表驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //通过DiverManager获取数据库链接
            String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT%2B8&useSSL=false";
            String username = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url,username,password);
            // 通过connection对象获取Satement对象
            statement = connection.createStatement();
            // 使用statement执行sql语句
            String sql = "select * from mydb_user";
            resultSet = statement.executeQuery(sql);
            //操作resultset结果集
            System.out.println("id   |    name");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + "    |    " + name);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            //回收数据库资源
            if(resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                resultSet = null;
            }
            if (statement != null){
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
