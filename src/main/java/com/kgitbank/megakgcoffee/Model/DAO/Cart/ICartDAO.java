package com.kgitbank.megakgcoffee.Model.DAO.Cart;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ICartDAO implements CartDAO{

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
    public ObservableList<CartDTO> FindAllCartItems(int reg_seq) {

        ObservableList<CartDTO> cartDTOS = FXCollections.observableArrayList();


        String allFindCartItemsSQL = "SELECT C.check_seq, M.menu_name, I.item_count, I.item_price" +
                " FROM tb_orderCheck C LEFT OUTER JOIN tb_orderItem I ON C.checkItem_seq = I.item_seq AND C.checkReg_seq = ?" +
                " INNER JOIN tb_menu M ON I.itemMenu_seq = M.menu_seq WHERE C.checkOrder = 0 ORDER BY C.check_seq ASC";

        try {
            PreparedStatement ps = connection.prepareStatement(allFindCartItemsSQL);
            ps.setInt(1, reg_seq);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cartDTOS.add(new CartDTO(
                        rs.getInt("check_seq"),
                        rs.getString("menu_name"),
                        rs.getInt("item_count"),
                        rs.getInt("item_price"),
                        new CheckBox()
                ));
            }
            rs.close();
            ps.close();
            return cartDTOS;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
