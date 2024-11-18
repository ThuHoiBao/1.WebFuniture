/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "Orders") // Renaming the table in the database
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderID;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ORDERID")    
    private List<OrderItem> listOrderItem;
    
    @OneToOne
    @JoinColumn(name = "CUSTOMERID")
    private Customer customer;
    
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    private OrderStatus status;

    public Order() {
    }

    public Order(List<OrderItem> listOrderItem, Customer customer, Date orderDate, OrderStatus status) {
        this.listOrderItem = listOrderItem;
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
    }
   
    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public List<OrderItem> getListOrderItem() {
        return listOrderItem;
    }

    public void setListOrderItem(List<OrderItem> listOrderItem) {
        this.listOrderItem = listOrderItem;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }    
}
