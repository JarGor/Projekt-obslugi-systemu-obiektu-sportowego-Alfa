package com.ztbd.sportsfacility.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ztbd.sportsfacility.utility.LocalDateDeserializer;
import com.ztbd.sportsfacility.utility.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "change_logs")
public class ChangeLog {

    @Id
    @Column(nullable = false)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @Column(nullable = false)
    private String changes;

    public ChangeLog() {}

    public ChangeLog(LocalDate date, String changes) {
        this.date = date;
        this.changes = changes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }
}
