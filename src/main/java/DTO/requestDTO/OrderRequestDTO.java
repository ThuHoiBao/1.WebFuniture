package DTO.requestDTO;

import java.util.Date;

public class OrderRequestDTO {
    private Long id;
    private Date orderDate;
    private Long CustomerId;

    public Long getCustomerId() {
        return CustomerId;
    }
    public void setCustomerId(Long customerId) {
        CustomerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
