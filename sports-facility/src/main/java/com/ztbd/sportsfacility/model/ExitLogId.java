package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ztbd.sportsfacility.utility.LocalDateTimeDeserializer;
import com.ztbd.sportsfacility.utility.LocalDateTimeSerializer;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class ExitLogId implements Serializable {

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE,
                           CascadeType.PERSIST, CascadeType.REFRESH })
    private Customer customer;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime exitTime;

    public ExitLogId() {}

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ExitLogId that = (ExitLogId) o;
        return Objects.equals(customer, that.customer) &&
                exitTime.equals(that.exitTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, exitTime);
    }
}