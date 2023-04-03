package com.kgitbank.megakgcoffee.Service.OrderItem;

import com.kgitbank.megakgcoffee.Model.DAO.OrderItem.OrderItemDAO;
import com.kgitbank.megakgcoffee.Model.DAO.OrderItem.OrderItemDAOFactory;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Model.DTO.OrderItem.OrderItemDTO;
import com.kgitbank.megakgcoffee.Service.OrderCheck.OrderCheckServiceFactory;
import com.kgitbank.megakgcoffee.Service.OrderCheck.OrderCheckService;
import javafx.scene.control.Alert;

public class IOrderItemService implements OrderItemService{

    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();
    OrderItemDAO orderItemDAO = OrderItemDAOFactory.getOrderItemDAO();
    OrderCheckService orderCheckService = OrderCheckServiceFactory.getOrderCheckService();
    int orderItemMenu_seq; // 주문상품상세 테이블 입력용
    int orderItem_seq; // 주문체크 테이블 입력용

    @Override
    public void insertOrderItem(String itemMenu_seq, int cnt, int total_price) {
        try {
            orderItemMenu_seq = Integer.valueOf(itemMenu_seq);
            OrderItemDTO orderItemDTO = new OrderItemDTO(orderItemMenu_seq, cnt, total_price);
            orderItem_seq = orderItemDAO.insertOrderItem(orderItemDTO);
            if (orderItem_seq > 0) {
                orderCheckService.createOrderCheckToCart(orderItem_seq, 1); // todo :: 주문상세번호, 회원번호 (test로 회원번호 1)    
            }
            else {
                System.out.println("주문체크 테이블 입력 오류"); // todo :: 추후 삭제
            }

        } catch (NumberFormatException ne) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("관리자에게 문의해주세요.");
            alert.setContentText("알수없는 오류");
            alert.showAndWait();
            ne.printStackTrace();
        }
    }

    @Override
    public void orderNow(String itemMenu_seq, int cnt, int total_price) {
        try {
            orderItemMenu_seq = Integer.valueOf(itemMenu_seq);
            OrderItemDTO orderItemDTO = new OrderItemDTO(orderItemMenu_seq, cnt, total_price);
            orderItem_seq = orderItemDAO.insertOrderItem(orderItemDTO);
            orderDataSingleton.setOrder_item_seq(orderItem_seq); // todo :: 주문 담은거 PK값 싱글톤에 저장
            if (orderItem_seq > 0) {
                orderCheckService.createOrderNow(orderItem_seq, 1); // todo :: 주문상세번호, 회원번호 (test로 회원번호 1)
            } else {
                System.out.println("주문체크 테이블 입력 오류"); // todo :: 추후 삭제
            }
        } catch (NumberFormatException ne) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("관리자에게 문의해주세요.");
            alert.setContentText("알수없는 오류");
            alert.showAndWait();
            ne.printStackTrace();
        }
    }
}
