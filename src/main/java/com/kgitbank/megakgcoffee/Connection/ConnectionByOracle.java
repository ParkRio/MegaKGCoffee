package com.kgitbank.megakgcoffee.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionByOracle implements ConnectionMaker{

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "Douzone"; // 자기 자신의 오라클 아이디로 변경
    String password = "oracle"; // 자기 자신의 오라클 비밀번호로 변경

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url,user,password);
    }

}
