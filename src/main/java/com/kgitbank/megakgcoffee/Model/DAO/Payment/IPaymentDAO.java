package com.kgitbank.megakgcoffee.Model.DAO.Payment;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.PaymentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    @Override
    public void insert(PaymentDTO PaymentDTO) {

        String insertSQL = "INSERT INTO payment_view(payment_seq, paymentReg_style, paymentReg_comment)" +
                " VALUES (test_Coffee_payment_seq.NEXTVAL,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(insertSQL);
            ps.setString(1, PaymentDTO.getPaymentReg_style());
            ps.setString(2, PaymentDTO.getPaymentReg_comment());
            ps.executeQuery();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
