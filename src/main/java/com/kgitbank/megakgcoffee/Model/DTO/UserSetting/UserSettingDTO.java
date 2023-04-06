package com.kgitbank.megakgcoffee.Model.DTO.UserSetting;

public class UserSettingDTO {
    private String menu_name;
    private int count_purchase;

    public UserSettingDTO(){}

    public UserSettingDTO(String menu_name, int count_purchase){
        this.menu_name = menu_name;
        this.count_purchase = count_purchase;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public int getCount_purchase() {
        return count_purchase;
    }
}
