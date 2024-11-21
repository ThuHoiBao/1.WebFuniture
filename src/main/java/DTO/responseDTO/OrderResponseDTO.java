package DTO.responseDTO;

import business.OrderStatus;

import java.util.Date;

public class OrderResponseDTO {
    private Long orderID;
    private Date orderDate;
    private String status;

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
