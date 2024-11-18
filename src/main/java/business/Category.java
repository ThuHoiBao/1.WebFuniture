
package business;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryID;
    private String categoryName;
    private String categoryDescription;
    @Enumerated(EnumType.STRING)
    private BusinessStatus categoryStatus;
    private String manufacture;
    
    @OneToMany
    private List<Furniture> furnitures;

    public Category() {
    }

    public Category(Long categoryID, String categoryName, String categoryDescription, BusinessStatus categoryStatus, String manufacture, List<Furniture> furnitures) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryStatus = categoryStatus;
        this.manufacture = manufacture;
        this.furnitures = furnitures;
    }
    
    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public BusinessStatus getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(BusinessStatus categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }
}