/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author ASUS
 */
@Entity
public class Cart implements Serializable {
    @Id
    private String cartID;
    
    @OneToMany
    private List<Furniture> listFurniture;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMERID") // Tên cột trong bảng Cart để lưu trữ ID của Customer
    private Customer customer;

    public Cart() {
    }

    public Cart(String cartID, List<Furniture> listFurniture, Customer customer) {
        this.cartID = cartID;
        this.listFurniture = listFurniture;
        this.customer = customer;
    }
     

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }
    
    public List<Furniture> getListFurniture() {
        return listFurniture;
    }

    public void setListFurniture(List<Furniture> listFurniture) {
        this.listFurniture = listFurniture;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
