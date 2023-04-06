package com.kgitbank.megakgcoffee.Service.Find;

public class FindServiceFactory {
    public static FindService getFindService() {
        return new IFindService();
    }
}
