package com.course.generator.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DbUtil {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/courseimooc";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;

    }

    /**
     * 获得表注释
     */
    public static String getTableComment(String tableName) throws Exception {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select table_comment from information_schema.TABLES where TABLE_NAME = '" + tableName + "'");
        String tableNameCH = "";
        if (resultSet != null) {
            while (resultSet.next()) {
                tableNameCH = resultSet.getString("table_comment");
                break;
            }
        }
        resultSet.close();
        statement.close();
        System.out.println("表名:" + tableNameCH);
        return tableNameCH;
    }

    /**
     * 获取所有列信息
     */
    public static List<Field> getColumnByTableName(String tableName) throws Exception {
        List<Field> fieldList = new ArrayList<>();
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("show full columns from " + tableName + "");
        if (resultSet != null) {
            while (resultSet.next()) {
                String columnName = resultSet.getString("Field");
                System.out.println("columnName:"+columnName);
                String type = resultSet.getString("Type");
                System.out.println("type:"+type);
                String comment = resultSet.getString("Comment");
                System.out.println("comment:"+comment);
                Field field = new Field();
                field.setName(columnName);
                field.setNameHump(lineToHump(columnName));
                field.setNameBigHump(lineToBigHump(columnName));
                field.setType(type);
                field.setJavaType(DbUtil.sqlTypeToJavaType(resultSet.getString("Type")));
                field.setComment(comment);
                if (comment.contains("|")) {
                    field.setNameCn(comment.substring(0, comment.indexOf("|")));
                } else {
                    field.setNameCn(comment);
                }
                fieldList.add(field);
                System.out.println(fieldList);
            }
        }
        resultSet.close();
        statement.close();
        connection.close();
        System.out.println("列信息:"+fieldList);
        return fieldList;

    }
    /**
     * 下划线转小驼峰
     */
    public static String lineToHump(String string){
        Pattern linePattern = Pattern.compile("_(\\w)");
        string = string.toLowerCase();
        Matcher matcher = linePattern.matcher(string);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb,matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    /**
     * 下划线转大驼峰
     */
    public static String lineToBigHump(String string){
        String s = lineToHump(string);
        return s.substring(0,1).toUpperCase()+s.substring(1);
    }
    /**
     * 数据库类型转为java类型
     */
    public static String sqlTypeToJavaType(String sqlType) {
        if (sqlType.toUpperCase().contains("varchar".toUpperCase())
                || sqlType.toUpperCase().contains("char".toUpperCase())
                || sqlType.toUpperCase().contains("text".toUpperCase())) {
            return "String";
        } else if (sqlType.toUpperCase().contains("datetime".toUpperCase())) {
            return "Date";
        } else if (sqlType.toUpperCase().contains("int".toUpperCase())) {
            return "Integer";
        } else if (sqlType.toUpperCase().contains("long".toUpperCase())) {
            return "Long";
        } else if (sqlType.toUpperCase().contains("decimal".toUpperCase())) {
            return "BigDecimal";
        } else {
            return "String";
        }
    }
}
