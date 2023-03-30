package com.kgitbank.megakgcoffee.Model.DAO.Orders;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Orders.OrdersDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IOrdersDAO implements OrdersDAO{

    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();

    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrdersDTO> selectMenu(String category_menu) {

        List<OrdersDTO> ordersDTOS = new ArrayList<>();

        String selectMenu = "SELECT * FROM tb_menu" +
                " WHERE menu_category = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(selectMenu);
            ps.setString(1, category_menu);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                OrdersDTO ordersDTO = new OrdersDTO(
                        rs.getString("menu_category"),
                        rs.getString("menu_name"),
                        rs.getString("menu_img"),
                        rs.getString("menu_desc"),
                        rs.getInt("menu_price")
                );
                ordersDTOS.add(ordersDTO);
            }
            return ordersDTOS;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // todo :: null 값 반환하지말고 다른 값 반환하게 추후 변경
    }

    @Override
    public int NumberOfMenusPerCategory(String category_menu) {
        return 0;
    }
}
