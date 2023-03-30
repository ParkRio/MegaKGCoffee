package com.kgitbank.megakgcoffee.Service.Test;

import com.kgitbank.megakgcoffee.Model.DAO.Test.ITestDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Test.TestDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Test.TestDAOFactory;
import com.kgitbank.megakgcoffee.Model.DTO.Test.TestDTO;

public class ITestService implements TestService{

    TestDAO testDAO = TestDAOFactory.getTestDAO();

    @Override
    public void register(String id, String password) {
        testDAO.insert(TestDTO.registerUser(id, password));
    }
}
