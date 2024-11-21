package DTO.requestDTO;

import java.util.Date;

public class OrderRequestDTO {
    private Long orderID;
    private Date orderDate;
    private String CustomerId;

    public String getCustomerId() {
        return CustomerId;
    }
    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }
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

}
