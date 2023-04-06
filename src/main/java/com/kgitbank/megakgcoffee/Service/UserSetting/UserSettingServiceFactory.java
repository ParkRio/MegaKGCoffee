package com.kgitbank.megakgcoffee.Service.UserSetting;

public class UserSettingServiceFactory {
    public static UserSettingService getUserSettingService() {
        return new IUserSettingService();
    }
}
