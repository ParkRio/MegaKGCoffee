package com.kgitbank.megakgcoffee.Model.DAO.UserSetting;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.UserSetting.UserSettingDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IUserSettingDAO implements UserSettingDAO{

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
    public ObservableList<UserSettingDTO> UserPurchase(int reg_seq) {

        ObservableList<UserSettingDTO> userSettingDTOS = FXCollections.observableArrayList();

        String UserPurChaseSQL = "SELECT M.menu_name AS menu_name, SUM(item_count) AS count FROM tb_orderCheck O" +
                " INNER JOIN tb_orderItem I ON O.checkItem_seq = I.item_seq AND O.checkReg_seq = ? AND O.checkOrder = 1" +
                " INNER JOIN tb_menu M ON I.itemMenu_seq = M.menu_seq GROUP BY M.menu_name";

        try {
            PreparedStatement ps = connection.prepareStatement(UserPurChaseSQL);
            ps.setInt(1, reg_seq);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userSettingDTOS.add(
                        new UserSettingDTO(
                                rs.getString("menu_name"),
                                rs.getInt("count")
                        )
                );
            }
            rs.close();
            ps.close();
            return userSettingDTOS;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userSettingDTOS;
    }

    @Override
    public void updateNickname(String reg_nick, int reg_seq) {

        String nicknameChangedSQL = "UPDATE tb_register SET reg_nick = ? WHERE reg_seq = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(nicknameChangedSQL);
            ps.setString(1, reg_nick);
            ps.setInt(2, reg_seq);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePassword(String reg_pwd, int reg_seq) {

        String passwordChangedSQL = "UPDATE tb_register SET reg_pwd = ? WHERE reg_seq = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(passwordChangedSQL);
            ps.setString(1, reg_pwd);
            ps.setInt(2, reg_seq);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String presentPassword(int reg_seq) {

        String presentPasswordSQL = "SELECT reg_pwd FROM tb_register WHERE reg_seq = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(presentPasswordSQL);
            ps.setInt(1, reg_seq);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return rs.getString("reg_pwd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void deleteMember(String reg_pwd, int reg_seq) {

        String deleteMemberSQL = "UPDATE tb_register SET reg_delete = 'Y' WHERE reg_pwd = ? AND reg_seq = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(deleteMemberSQL);
            ps.setString(1, reg_pwd);
            ps.setInt(2, reg_seq);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
