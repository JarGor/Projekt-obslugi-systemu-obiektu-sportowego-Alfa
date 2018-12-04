package com.ztbd.sportsfacility.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exit_logs")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.customer",
                joinColumns = @JoinColumn(name = "customer_id")),
        @AssociationOverride(name = "primaryKey.exitTime",
                joinColumns = @JoinColumn(name = "exit_time"))
})
public class ExitLog {

    @EmbeddedId
    private ExitLogId primaryKey;

    public ExitLog() {}

    public ExitLogId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ExitLogId primaryKey) {
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
    public LocalDateTime getExitTime() {
        return getPrimaryKey().getExitTime();
    }

    public void setExitTime(LocalDateTime exitTime) {
        getPrimaryKey().setExitTime(exitTime);
    }
}
