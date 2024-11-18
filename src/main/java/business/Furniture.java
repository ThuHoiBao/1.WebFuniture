package business;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Furniture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String furnitureID;
    private String furnitureName;
    private String furnitureColor;
    private Double furniturePrice;
    private String furnitureDescription;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "furniture_id")
    private List<Image> furnitureImages;

    public Furniture() {
    }

    public Furniture(String furnitureID, String furnitureName, String furnitureColor, Double furniturePrice, String furnitureDescription, List<Image> furnitureImages) {
        this.furnitureID = furnitureID;
        this.furnitureName = furnitureName;
        this.furnitureColor = furnitureColor;
        this.furniturePrice = furniturePrice;
        this.furnitureDescription = furnitureDescription;
        this.furnitureImages = furnitureImages;
    }

    public Long getID() {
        return ID;
    }

    public void setFurnitureID(Long ID) {
        this.ID = ID;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public String getFurnitureColor() {
        return furnitureColor;
    }

    public void setFurnitureColor(String furnitureColor) {
        this.furnitureColor = furnitureColor;
    }

    public Double getFurniturePrice() {
        return furniturePrice;
    }

    public void setFurniturePrice(Double furniturePrice) {
        this.furniturePrice = furniturePrice;
    }

    public String getFurnitureDescription() {
        return furnitureDescription;
    }

    public void setFurnitureDescription(String furnitureDescription) {
        this.furnitureDescription = furnitureDescription;
    }

    public String getFurnitureID() {
        return furnitureID;
    }

    public void setFurnitureID(String furnitureID) {
        this.furnitureID = furnitureID;
    }

    public List<Image> getFurnitureImages() {
        return furnitureImages;
    }

    public void setFurnitureImages(List<Image> furnitureImages) {
        this.furnitureImages = furnitureImages;
    }
}