package com.kgitbank.megakgcoffee.Service.UserSetting;

import com.kgitbank.megakgcoffee.Controller.HomeView.HomeViewHomeController;
import com.kgitbank.megakgcoffee.Model.DAO.UserSetting.UserSettingDAO;
import com.kgitbank.megakgcoffee.Model.DAO.UserSetting.UserSettingFactory;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Model.DTO.UserSetting.UserSettingDTO;
import com.kgitbank.megakgcoffee.Service.Register.CommonService;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Optional;

public class IUserSettingService implements UserSettingService{

    UserSettingDAO userSettingDAO = UserSettingFactory.getUserSettingDAO();
    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    @Override
    public ObservableList<UserSettingDTO> userPurchase(int reg_seq) {
        return userSettingDAO.UserPurchase(reg_seq);
    }

    @Override
    public void ChangeNickName(String reg_nick) {
        if (reg_nick.isEmpty()) {
            CommonService.msg("변경하실 닉네임을 입력해주세요.");
        }
        else if (orderDataSingleton.getReg_nickname().equals(reg_nick)) {
            CommonService.msg("동일한 닉네임으로 변경이 불가능합니다.");
        } else {
            userSettingDAO.updateNickname(reg_nick, orderDataSingleton.getReg_seq());
            orderDataSingleton.setReg_nickname(reg_nick);
            CommonService.msg("정상적으로 변경되었습니다.");
        }
    }

    @Override
    public void changePassword(String present_reg_pwd, String new_reg_pwd) {

        if (present_reg_pwd.isEmpty() || new_reg_pwd.isEmpty()) {
            CommonService.msg("정보를 모두 입력해주세요.");
        } else if (!present_reg_pwd.equals(userSettingDAO.presentPassword(orderDataSingleton.getReg_seq()))) {
            CommonService.msg("비밀번호가 올바르지 않습니다.");
        } else {
            userSettingDAO.updatePassword(new_reg_pwd, orderDataSingleton.getReg_seq());
            CommonService.msg("비밀번호가 정상적으로 변경되었습니다.");
        }
    }

    @Override
    public boolean withdrawalMember(String reg_pwd) {

        if (reg_pwd == null) {
            CommonService.msg("비밀번호를 입력해주세요.");
        } else if (!reg_pwd.equals(userSettingDAO.presentPassword(orderDataSingleton.getReg_seq()))) {
            CommonService.msg("비밀번호가 올바르지 않습니다.");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("회원탈퇴");
            alert.setContentText("회원탈퇴 진행 후 회원복구가 되지 않을 수 있습니다." + System.lineSeparator() + "탈퇴하시겠습니까?");
            Optional<ButtonType> click = alert.showAndWait();
            if (click.get() == ButtonType.OK) {
                userSettingDAO.deleteMember(reg_pwd, orderDataSingleton.getReg_seq());
                Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                alertInfo.setTitle("INFORMATION");
                alertInfo.setHeaderText("회원탈퇴");
                alertInfo.setContentText("정상적으로 탈퇴처리 되었습니다.");
                Optional<ButtonType> clickInfo = alertInfo.showAndWait();
                if (clickInfo.get() == ButtonType.OK) {
                    return true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
