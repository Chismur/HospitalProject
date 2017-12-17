package com.hospitalproject.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "date", schema = "mydb")
public class DateEntity {
    private int idDate;
    private String name;
    private Collection<QueueEntity> queuesByIdDate;

    @Id
    @Column(name = "id_date", nullable = false)
    public int getIdDate() {
        return idDate;
    }

    public void setIdDate(int idDate) {
        this.idDate = idDate;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateEntity that = (DateEntity) o;

        if (idDate != that.idDate) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDate;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dateByIdWeekday")
    public Collection<QueueEntity> getQueuesByIdDate() {
        return queuesByIdDate;
    }

    public void setQueuesByIdDate(Collection<QueueEntity> queuesByIdDate) {
        this.queuesByIdDate = queuesByIdDate;
    }

    @Transient
    public StringProperty nameProperty(){
        return new SimpleStringProperty(name);
    }
}
