package com.kgitbank.megakgcoffee.Model.DAO.Test;

public class TestDAOFactory {

    public static TestDAO getTestDAO() {
        return new ITestDAO();
    }
}
