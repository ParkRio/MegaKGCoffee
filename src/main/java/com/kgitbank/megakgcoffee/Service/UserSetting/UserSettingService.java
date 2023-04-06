package com.kgitbank.megakgcoffee.Service.UserSetting;

import com.kgitbank.megakgcoffee.Model.DTO.UserSetting.UserSettingDTO;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public interface UserSettingService {
    ObservableList<UserSettingDTO> userPurchase(int reg_seq);
    void ChangeNickName(String reg_nick);
    void changePassword(String present_reg_pwd, String new_reg_pwd);
    boolean withdrawalMember(String reg_pwd);
}
