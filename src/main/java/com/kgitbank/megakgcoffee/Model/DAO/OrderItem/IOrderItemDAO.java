package com.kgitbank.megakgcoffee.Model.DAO.OrderItem;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.OrderItem.OrderItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IOrderItemDAO implements OrderItemDAO {

    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();

    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int insertOrderItem(OrderItemDTO orderItemDTO) {

        String insertOrderItemSQL = "INSERT INTO tb_orderItem(item_seq, itemMenu_seq, item_count ,item_price)" +
                " VALUES(orderItem_seq.NEXTVAL, ?, ?, ?)";

        String selectOrderItemSQL = "SELECT item_seq FROM (SELECT * FROM tb_orderItem ORDER BY ROWNUM DESC)" +
                " WHERE ROWNUM = 1";

        try {

            PreparedStatement ps = connection.prepareStatement(insertOrderItemSQL);
            ps.setInt(1, orderItemDTO.getItemMenu_seq());
            ps.setInt(2, orderItemDTO.getItem_count());
            ps.setInt(3, orderItemDTO.getItem_total_price());
            ps.executeUpdate();
            ps.close();

            PreparedStatement ps2 = connection.prepareStatement(selectOrderItemSQL);
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                return rs.getInt("item_seq");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
