module com.kgitbank.megakgcoffee {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ojdbc8;


    opens com.kgitbank.megakgcoffee to javafx.fxml;
    exports com.kgitbank.megakgcoffee;
    //opens com.kgitbank.megakgcoffee.Controller.Test to javafx.fxml;
    //opens com.kgitbank.megakgcoffee.Controller.Orders to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Controller.Register;
    opens com.kgitbank.megakgcoffee.Controller.Register to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Model.DAO.Register;
    opens com.kgitbank.megakgcoffee.Model.DAO.Register to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Model.DTO.Register;
    opens com.kgitbank.megakgcoffee.Model.DTO.Register to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Service.Register;
    opens com.kgitbank.megakgcoffee.Service.Register to javafx.fxml;

    opens com.kgitbank.megakgcoffee.Controller.HomeView;
    exports com.kgitbank.megakgcoffee.Controller.HomeView to javafx.fxml;


    opens com.kgitbank.megakgcoffee.Opener;
    exports com.kgitbank.megakgcoffee.Opener to javafx.fxml;

    opens com.kgitbank.megakgcoffee.Controller.Test to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Controller.Test;

    opens com.kgitbank.megakgcoffee.Controller.Orders to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Controller.Orders;

    opens com.kgitbank.megakgcoffee.Controller.OrderDetail to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Controller.OrderDetail;


    exports com.kgitbank.megakgcoffee.Model.DAO.HomeView;
    opens com.kgitbank.megakgcoffee.Model.DAO.HomeView to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Model.DTO.HomeView;
    opens com.kgitbank.megakgcoffee.Model.DTO.HomeView to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Service.HomeView;
    opens com.kgitbank.megakgcoffee.Service.HomeView to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Openner.HomeView;
    opens com.kgitbank.megakgcoffee.Openner.HomeView to javafx.fxml;


    opens com.kgitbank.megakgcoffee.Controller.Cart to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Controller.Cart;

    opens com.kgitbank.megakgcoffee.Controller.Payment to javafx.fxml;
    exports com.kgitbank.megakgcoffee.Controller.Payment;


//    exports com.kgitbank.megakgcoffee.Model.DAO.HomeView;
//    opens com.kgitbank.megakgcoffee.Model.DAO.HomeView to javafx.fxml;
//
//    exports com.kgitbank.megakgcoffee.Model.DTO.HomeView;
//    opens com.kgitbank.megakgcoffee.Model.DTO.HomeView to javafx.fxml;
//
//    exports com.kgitbank.megakgcoffee.Service.HomeView;
//    opens com.kgitbank.megakgcoffee.Service.HomeView to javafx.fxml;
}