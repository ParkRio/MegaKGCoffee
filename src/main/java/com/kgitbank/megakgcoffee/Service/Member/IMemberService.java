package com.kgitbank.megakgcoffee.Service.Member;

import com.kgitbank.megakgcoffee.Model.DAO.Member.MemberDAO;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;

public class IMemberService {

    private MemberDAO memberDao;
    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    public IMemberService() {
        memberDao = new MemberDAO();
    }

//    public void MemberCheck() {
//        memberDao.MemberInfo();
//    }


}
