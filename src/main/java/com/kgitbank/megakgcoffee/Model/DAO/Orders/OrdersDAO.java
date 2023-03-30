package com.kgitbank.megakgcoffee.Model.DAO.Orders;

import com.kgitbank.megakgcoffee.Model.DTO.Orders.OrdersDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface OrdersDAO {
    List<OrdersDTO> selectMenu(String category_menu);
    int NumberOfMenusPerCategory(String category_menu);
}
