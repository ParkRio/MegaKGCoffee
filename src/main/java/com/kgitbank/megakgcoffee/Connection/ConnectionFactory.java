package com.kgitbank.megakgcoffee.Connection;

public class ConnectionFactory {

    public static ConnectionMaker getOracleInstance() {
        return new ConnectionByOracle();
    }
}
