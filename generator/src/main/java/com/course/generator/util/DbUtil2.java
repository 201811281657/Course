package com.course.generator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DbUtil2 {
    /**
     * 获取连接
     */
    public Connection getConnection() throws Exception{
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/courseimooc";
        String user = "root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }
    /**
     * 获取表注释
     */
    public String getTableComment(String tableName) throws Exception {
        DbUtil2 dbUtil2 = new DbUtil2();
        Connection connection = dbUtil2.getConnection();
        Statement statement = connection.createStatement();
        String tableNameCH = "";
        ResultSet resultSet = statement.executeQuery("select table_comment from information_schema.TABLES where TABLE_NAME = '" + tableName + "'");
                if(resultSet!=null){
                    while(resultSet.next()){
                        tableNameCH = resultSet.getString("table_comment");
                        break;
                    }
                }
                return tableNameCH;
    }
//    public List<Field> getColumnbytableName(String tableName) throws Exception{
//        DbUtil2 dbUtil2 = new DbUtil2();
//        Connection connection = dbUtil2.getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("show full columns from " + tableName + "");
//        if(resultSet!=null){
//            while(resultSet.next()){
//                String column = resultSet.getString("Field");
//                Field field = new Field();
//                field.setName(column);
//
//
//            }
//        }
//    }
}
