package com.kgitbank.megakgcoffee.Model.DAO.OrderDetail;

import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDetailDTO;

public interface OrderDetailDAO {
    OrderDetailDTO selectedMenu(int menu_seq);
}
