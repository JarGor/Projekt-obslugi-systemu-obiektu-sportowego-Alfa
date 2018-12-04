package com.ztbd.sportsfacility.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enter_logs")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.customer",
                joinColumns = @JoinColumn(name = "customer_id")),
        @AssociationOverride(name = "primaryKey.enterTime",
                joinColumns = @JoinColumn(name = "enter_time"))
})
public class EnterLog {

    @EmbeddedId
    private EnterLogId primaryKey;

    public EnterLog() {}

    public EnterLogId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(EnterLogId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Customer getCustomer() {
        return getPrimaryKey().getCustomer();
    }

    public void setCustomer(Customer customer) {
        getPrimaryKey().setCustomer(customer);
    }

    @Transient
    public LocalDateTime getEnterTime() {
        return getPrimaryKey().getEnterTime();
    }

    public void setEnterTime(LocalDateTime enterTime) {
        getPrimaryKey().setEnterTime(enterTime);
    }
}
