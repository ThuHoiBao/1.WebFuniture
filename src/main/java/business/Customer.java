package business;

import javax.persistence.Entity;


@Entity
public class Customer extends Person {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
