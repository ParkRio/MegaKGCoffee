package com.kgitbank.megakgcoffee.Model.DAO.Payment;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.CartPaymentDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.FindOrderPaymentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IOrderPaymentDAO implements OrderPaymentDAO{

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
    public FindOrderPaymentDTO findByOrderNow(int order_item_seq, int checkReg_seq) {

        FindOrderPaymentDTO findOrderPaymentDTO = null;

        String findByOrderNowSQL = "SELECT check_seq, menu_name, menu_img, item_count, item_price, menu_price, checkOrder"
                + " FROM tb_orderItem O INNER JOIN tb_orderCheck C ON O.item_seq = C.checkItem_seq AND checkOrder = 2"
                + " AND item_seq = ?" // todo :: ? 는 order_item_seq
                + " INNER JOIN tb_menu M ON O.itemMenu_seq = M.menu_seq AND checkReg_seq = 1"; // todo :: checkReg_seq은 테스트로 회원번호 1

        try {
            PreparedStatement ps = connection.prepareStatement(findByOrderNowSQL);
            ps.setInt(1, order_item_seq);
            //ps.setInt(2, checkReg_seq); // todo :: 추후에 회원번호 저장되면 주석 해제
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                findOrderPaymentDTO = new FindOrderPaymentDTO(
                        rs.getInt("check_seq"),
                        rs.getString("menu_name"),
                        rs.getString("menu_img"),
                        rs.getInt("item_count"),
                        rs.getInt("item_price"),
                        rs.getInt("menu_price"),
                        rs.getInt("checkOrder")
                );
            }
            rs.close();
            ps.close();
            return findOrderPaymentDTO;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // todo :: 추후 return 값 변경
    }

    @Override
    public ObservableList<CartPaymentDTO> AllByCartOrder(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq) {

        ObservableList<CartPaymentDTO> observableCartPaymentDTO = FXCollections.observableArrayList();

        String AllByCartOrderSQL = "SELECT check_seq, menu_name, menu_img, item_count, item_price, menu_price, checkOrder"
                + " FROM tb_orderItem O INNER JOIN tb_orderCheck C ON O.item_seq = C.checkItem_seq AND checkOrder = 0"
                + " INNER JOIN tb_menu M ON O.itemMenu_seq = M.menu_seq AND checkReg_seq = 1 AND check_seq = ?";

        for (CartDTO cartDTO : cartDTOArrayList) {
            try {
                PreparedStatement ps = connection.prepareStatement(AllByCartOrderSQL);
                ps.setInt(1, cartDTO.getCheck_seq());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                            observableCartPaymentDTO.add(new CartPaymentDTO(
                                    rs.getString("menu_img"),
                                    rs.getString("menu_name"),
                                    rs.getInt("menu_price"),
                                    rs.getInt("item_count"),
                                    rs.getInt("item_price")
                            ));
                }
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return observableCartPaymentDTO;
    }

    @Override
    public void updateOrderNow(int order_item_seq, int checkReg_seq) {

        System.out.println(order_item_seq);

        String updateOrderNowFinishSQL = "UPDATE tb_orderCheck SET checkOrder = 1"
                + " WHERE check_seq = ? AND checkReg_seq = 1"; // todo :: 회원 테스트번호 1

        try {
            PreparedStatement ps = connection.prepareStatement(updateOrderNowFinishSQL);
            ps.setInt(1, order_item_seq);
            //ps.setInt(2, checkReg_seq);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCartOrder(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq) {

        String updateCartOrderFinishSQL = "UPDATE tb_orderCheck SET checkOrder = 1"
                + " WHERE check_seq = ? AND checkReg_seq = 1"; // todo :: 회원 테스트번호 1

        try {
            PreparedStatement ps = connection.prepareStatement(updateCartOrderFinishSQL);

            for (CartDTO cart : cartDTOArrayList) {

                ps.setInt(1, cart.getCheck_seq());
                //ps.setInt(2, checkReg_seq);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void deleteCheckOrder(int check_seq) {
        String deleteCheckOrderSQL = "DELETE FROM tb_orderCheck WHERE check_seq = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(deleteCheckOrderSQL);
            ps.setInt(1, check_seq);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
