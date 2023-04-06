package com.kgitbank.megakgcoffee.Model.DAO.UserSetting;

public class UserSettingFactory {
    public static UserSettingDAO getUserSettingDAO() {
        return new IUserSettingDAO();
    }
}
