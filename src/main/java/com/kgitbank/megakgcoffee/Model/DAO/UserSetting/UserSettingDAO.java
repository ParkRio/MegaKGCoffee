package com.kgitbank.megakgcoffee.Model.DAO.UserSetting;

import com.kgitbank.megakgcoffee.Model.DTO.UserSetting.UserSettingDTO;
import javafx.collections.ObservableList;

public interface UserSettingDAO {
    ObservableList<UserSettingDTO> UserPurchase(int reg_seq);
    void updateNickname(String reg_nick, int reg_seq);
    void updatePassword(String reg_pwd, int reg_seq);
    String presentPassword(int reg_seq);
    void deleteMember(String reg_pwd, int reg_seq);
}
