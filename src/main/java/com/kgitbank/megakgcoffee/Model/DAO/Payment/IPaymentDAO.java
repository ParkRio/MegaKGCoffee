package com.kgitbank.megakgcoffee.Model.DAO.Payment;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Orders.OrdersDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.PaymentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IPaymentDAO implements PaymentDAO{

    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();

    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // select문 작업중
//    @Override
//    public List<OrdersDTO> selectPayment(String select_payment) {
//
//        List<PaymentDTO> paymentDTOS = new ArrayList<>();
//
//        String selectPayment = "SELECT * FROM payment_view" +
//                " WHERE payment_seq = ?";
//
//        try {
//            PreparedStatement ps = connection.prepareStatement(selectPayment);
//            ps.setString(1, selectPayment);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()) {
//                PaymentDTO paymentDTO = new PaymentDTO(
//                        rs.getString(""),
//                        rs.getString(""),
//                        rs.getString(""),
//                        rs.getString(""),
//                        rs.getInt("")
//                );
//                paymentDTOS.add(PaymentDTO);
//            }
//            return paymentDTOS;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null; //
//    }


    @Override
    public void insert(PaymentDTO PaymentDTO) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");

//        String insertSQL = "INSERT INTO payment_view(payment_seq, paymentReg_style, paymentReg_comment, payment_CashReceipts)" +
//                " VALUES (payment_view.NEXTVAL, ?, ?, ?)";
        String insertSQL = "INSERT INTO payment_view(payment_seq, payment_comment, payment_cashReceipts)" +
                " VALUES (payment_view.NEXTVAL, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(insertSQL);
            ps.setInt(1, 1);
//            ps.setString(2, PaymentDTO.getPaymentReg_style());
            ps.setString(2, PaymentDTO.getPayment_comment());
            ps.setString(3, PaymentDTO.getPayment_cashReceipts());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
