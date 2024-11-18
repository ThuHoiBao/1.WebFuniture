package business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
public class Coupon implements Serializable {
    @Id
    private String couponID;
    private String couponName;
    private String couponType;
    private double couponValue;
    @Temporal(TemporalType.DATE)                
    private Date startDate;
    @Temporal(TemporalType.DATE)                
    private Date endDate;
    private String useCondition;
    private double minOrderValue;
    @OneToMany    
    private List<Category> applicableFurniture;
    private int useLimit;
    private int currentUsage;



    // Getters and Setters

    public String getCouponID() {
        return couponID;
    }

    public void setCouponID(String couponID) {
        this.couponID = couponID;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public double getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(double couponValue) {
        this.couponValue = couponValue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(String useCondition) {
        this.useCondition = useCondition;
    }

    public double getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(double minOrderValue) {
        this.minOrderValue = minOrderValue;
    }



    public int getUseLimit() {
        return useLimit;
    }

    public void setUseLimit(int useLimit) {
        this.useLimit = useLimit;
    }

    public int getCurrentUsage() {
        return currentUsage;
    }

    public void setCurrentUsage(int currentUsage) {
        this.currentUsage = currentUsage;
    }

    public List<Category> getApplicableFurniture() {
        return applicableFurniture;
    }

    public void setApplicableFurniture(List<Category> applicableFurniture) {
        this.applicableFurniture = applicableFurniture;
    }
}
