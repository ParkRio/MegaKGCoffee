package com.kgitbank.megakgcoffee.Opener;

import com.kgitbank.megakgcoffee.Controller.HomeView.HomeViewHomeController;
import com.kgitbank.megakgcoffee.Controller.HomeView.HomeViewMainController;
import com.kgitbank.megakgcoffee.Controller.Orders.OrdersController;
import com.kgitbank.megakgcoffee.Controller.Payment.OrderPaymentController;
import com.kgitbank.megakgcoffee.Controller.Register.LoginController;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Opener {

    private Stage primaryStage;

    OrderDataSingleton data = OrderDataSingleton.getInstance();

    // opener 가 생성할 화면 구성
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void BeforeLoginOpen(Stage stage) { //로그인 버튼 눌르면 // 로그인 창으로 이동 // 지금은 홈으로 이동 되게끔
            try {
                URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Login.fxml").toURI().toURL();
                FXMLLoader loader = new FXMLLoader(fxmlPath);
                Parent orderDetailForm = null;
                orderDetailForm = loader.load();
                Opener opener = new Opener();
                LoginController loginController = loader.getController();
                loginController.setOpener(opener);
                Scene scene = new Scene(orderDetailForm);
                stage.setTitle("Mega Kg Coffee");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    // 회원 가입 화면 실행
    public void regOpen(Stage regStage) {
        //Stage regStage = new Stage();
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Register.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Scene scene = new Scene(fxmlLoader.load());
            regStage.setTitle("Mega Kg Coffee");
            regStage.setScene(scene);
            regStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원 아이디, 비밀번호 찾기 화면 실행
    public void findOpen(Stage findStage) {
        //Stage findStage = new Stage();
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Find.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Scene scene = new Scene(fxmlLoader.load());
            findStage.setTitle("Mega Kg Coffee");
            findStage.setScene(scene);
            findStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 메뉴 화면 실행
    public void menuOpen(Stage stage) {
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/HomeView_home.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(fxmlPath);
            Parent homeView_homeForm = null;
            homeView_homeForm = loader.load();
            Opener opener = new Opener();
            HomeViewHomeController homeViewHomeController = loader.getController();
            homeViewHomeController.setOpener(opener);
            Scene scene = new Scene(homeView_homeForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginOpen(Stage stage) {
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Login.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(fxmlPath);
            Parent LoginForm = null;
            LoginForm = loader.load();
            Opener opener = new Opener();
            LoginController LoginController = loader.getController();
            LoginController.setOpener(opener);
            Scene scene = new Scene(LoginForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 주문 페이지 화면 실행
    public void OrderPageOpen(Stage stage) {
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Orders.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Parent paymentForm = fxmlLoader.load();
            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            OrdersController ordersController = fxmlLoader.getController();
            ordersController.setOpener(opener);
            Scene scene = new Scene(paymentForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 주문 상세 페이지 화면 실행
    public void OrderDetailPageOpen(String menu_seq) {
        
        data.setMenu_seq(menu_seq); // 어떤 메뉴인지 확인하기 위함

        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/OrderDetail.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(fxmlPath);
            Parent orderDetailForm = null;
            orderDetailForm = loader.load();
            Scene scene = new Scene(orderDetailForm);
            primaryStage.setTitle("Mega Kg Coffee");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 장바구니 페이지 화면 실행
    public void CartPageOpen() {

        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Cart.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(fxmlPath);
            Parent cartForm = null;
            cartForm = loader.load();
            Scene scene = new Scene(cartForm);
            primaryStage.setTitle("Mega Kg Coffee");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 바로 주문 클릭시 결제화면 실행
    public void OrderPayment(Stage stage) {
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/OrderPayment.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Parent paymentForm = fxmlLoader.load();
            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            OrderPaymentController orderPaymentController = fxmlLoader.getController();
            orderPaymentController.setOpener(opener);
            Scene scene = new Scene(paymentForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CartToOrderPayment(Stage stage) {
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/OrderPayment.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Parent CartToPaymentForm = fxmlLoader.load();
            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            OrderPaymentController orderPaymentController = fxmlLoader.getController();
            orderPaymentController.setOpener(opener);
            Scene scene = new Scene(CartToPaymentForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 결제화면에서 다시 주문 페이지 화면 실행
    public void PaymentForBackToOrderPage(Stage stage) {
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Orders.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Parent paymentToOrderForm = fxmlLoader.load();
            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            OrdersController ordersController = fxmlLoader.getController();
            ordersController.setOpener(opener);
            Scene scene = new Scene(paymentToOrderForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 주문 페이지로 돌아가는 화면 실행
    public void BackToOrderPage(Stage stage) {

        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Orders.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Parent orderForm = fxmlLoader.load();
            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            OrdersController ordersController = fxmlLoader.getController();
            ordersController.setOpener(opener);
            Scene scene = new Scene(orderForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////Home View /////////////////////////////////////
    public void LoginOpen(Stage stage) { //로그인 버튼 눌르면 // 로그인 창으로 이동 // 지금은 홈으로 이동 되게끔
//        main.
        //같은 창에서 fxml만 교체해서 열어야함.
        try {
            URL homePath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/HomeView_home.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(homePath);
            Parent homeform = fxmlLoader.load();

            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            HomeViewHomeController homeViewHomeController = fxmlLoader.getController();
            homeViewHomeController.setOpener(opener);
            Scene scene = new Scene(homeform);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void BackButton(Stage stage) {
        try {
            URL backPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/HomeView_main2.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(backPath);
            Parent backForm = fxmlLoader.load();

            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            HomeViewMainController mainController = fxmlLoader.getController();
            mainController.setOpener(opener);

            Scene backScene = new Scene(backForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(backScene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void CoffeeButton(Stage stage){
        try {

            // coffe 화면으로 fxml 주소 변경해야함
            URL backPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/HomeView_main.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(backPath);
            Parent coffeeForm = fxmlLoader.load();

            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            HomeViewMainController mainController = fxmlLoader.getController();
            mainController.setOpener(opener);

            Scene backScene = new Scene(coffeeForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(backScene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void LoginButton(Stage stage){
        try {

            // coffe 화면으로 fxml 주소 변경해야함
            URL backPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Register.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(backPath);
            Parent coffeeForm = fxmlLoader.load();

            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            HomeViewMainController mainController = fxmlLoader.getController();
            mainController.setOpener(opener);

            Scene backScene = new Scene(coffeeForm);
            stage.setTitle("Mega Kg Coffee");
            stage.setScene(backScene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
