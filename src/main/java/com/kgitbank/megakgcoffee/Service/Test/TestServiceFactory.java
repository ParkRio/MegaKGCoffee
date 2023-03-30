package com.kgitbank.megakgcoffee.Service.Test;

public class TestServiceFactory {
    public static TestService getTestService() {
        return new ITestService();
    }
}
