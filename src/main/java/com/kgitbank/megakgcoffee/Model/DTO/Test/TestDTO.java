package com.kgitbank.megakgcoffee.Model.DTO.Test;

public class TestDTO {

    private int test_seq;
    private String test_id;
    private String test_password;

    public TestDTO(){}

    public TestDTO(String test_id, String test_password) {
        this.test_id = test_id;
        this.test_password = test_password;
    }

    public static TestDTO registerUser(String test_id, String test_password) {
        return new TestDTO(test_id, test_password);
    }

    public int getTest_seq() {
        return test_seq;
    }

    public String getTest_id() {
        return test_id;
    }

    public String getTest_password() {
        return test_password;
    }
}
