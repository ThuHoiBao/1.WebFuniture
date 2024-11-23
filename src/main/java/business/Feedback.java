package business;
import business.Furniture;
import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Entity
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @OneToOne
    @JoinColumn(name = "CUSTOMERID")
    private Customer customer;

    private String description;
    private int rate;
    // Thay đổi kiểu dữ liệu thành byte[]

    @OneToOne
    @JoinColumn(name = "CATEGORYID")
    private  Category category;

    @OneToOne
    @JoinColumn(name = "ORDERID")
    private  Order  order;

    @OneToMany(mappedBy = "feedback", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <ImageFeedback> imageFeedbacks = new ArrayList<>();


    @Transient // Không lưu thuộc tính này vào cơ sở dữ liệu
    private String base64Data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ImageFeedback> getImageFeedbacks() {
        return imageFeedbacks;
    }

    public void setImageFeedbacks(List<ImageFeedback> imageFeedbacks) {
        this.imageFeedbacks = imageFeedbacks;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id ){
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder (Order order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


    // Constructor, getters và setters
    public void setBase64Data(String base64Data) {
        this.base64Data = base64Data;
    }


}
