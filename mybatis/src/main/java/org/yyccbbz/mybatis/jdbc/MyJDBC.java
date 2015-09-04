package org.yyccbbz.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyJDBC {

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.2.221:3306/mybatis_0902", "root",
                    "root");

            // 获取statement
            String sql = "SELECT * FROM tb_user WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // 加载参数
            preparedStatement.setLong(1, 1L);

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            // 遍历结果
            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getLong("id"));
                System.out.println("name=" + resultSet.getString("name"));
                System.out.println("password=" + resultSet.getString("password"));
            }
        } finally {
            // 关闭连接,释放资源
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
    }
}
