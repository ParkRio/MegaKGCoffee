package com.kgitbank.megakgcoffee.Model.DAO.Find;

import com.kgitbank.megakgcoffee.Model.DTO.Register.ResponseRegDTO;

public interface FindDAO {
    ResponseRegDTO findId(String name, String phone);
    String findPwd(String id, String Phone, String BirthDay);
}
