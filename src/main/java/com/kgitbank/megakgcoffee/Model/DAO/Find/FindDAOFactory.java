package com.kgitbank.megakgcoffee.Model.DAO.Find;

public class FindDAOFactory {

    public static FindDAO getFindDAO() {
        return new IFindDAO();
    }
}
