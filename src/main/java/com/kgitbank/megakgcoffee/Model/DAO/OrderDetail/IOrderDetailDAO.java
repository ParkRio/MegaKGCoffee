package com.kgitbank.megakgcoffee.Model.DAO.OrderDetail;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IOrderDetailDAO implements OrderDetailDAO{

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
    public OrderDetailDTO selectedMenu(int menu_seq) {

        OrderDetailDTO orderDetailDTO;

//        String selectedMenuSQL = "SELECT menu_name, menu_img, menu_desc, item_count, menu_price" +
//                " FROM tb_orderItem O INNER JOIN tb_menu M" +
//                " ON O.itemMenu_seq = M.menu_seq" +
//                " AND M.menu_seq = ?";

        String selectedMenuSQL = "SELECT menu_name, menu_img, menu_desc, menu_price" +
                " FROM tb_menu WHERE menu_seq = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(selectedMenuSQL);
            ps.setInt(1, menu_seq);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                orderDetailDTO = new OrderDetailDTO(
                        rs.getString("menu_name"),
                        rs.getString("menu_img"),
                        rs.getString("menu_desc"),
                        rs.getInt("menu_price")
                );
                return orderDetailDTO;
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // todo :: 추후 변경
    }
}
