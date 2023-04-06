package com.kgitbank.megakgcoffee.Service.Find;

import javafx.scene.control.Label;

public interface FindService {
    void FindId(String name, String phone, Label label);
    void FindPwd(String id, String Phone, String Birthday, Label label);
}
