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
public class EnterLogId implements Serializable {

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE,
                           CascadeType.PERSIST, CascadeType.REFRESH })
    private Customer customer;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime enterTime;

    public EnterLogId() {}

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(LocalDateTime enterTime) {
        this.enterTime = enterTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        EnterLogId that = (EnterLogId) o;
        return Objects.equals(customer, that.customer) &&
                enterTime.equals(that.enterTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, enterTime);
    }
}