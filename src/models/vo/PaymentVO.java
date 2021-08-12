package models.vo;

import java.io.Serializable;
import java.sql.Date;

public class PaymentVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int id;
    private PetVO pet;
    private PlanVO plan;
    private int subscription;
    private Date date;
       
    public PaymentVO() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PetVO getPet() {
        return pet;
    }

    public void setPet(PetVO pet) {
        this.pet = pet;
    }

    public PlanVO getPlan() {
        return plan;
    }

    public void setPlan(PlanVO plan) {
        this.plan = plan;
    }

    public int getSubscription() {
        return subscription;
    }

    public void setSubscription(int subscription) {
        this.subscription = subscription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }    
}