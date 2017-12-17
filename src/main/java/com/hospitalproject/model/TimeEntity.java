package com.hospitalproject.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "time", schema = "mydb", catalog = "")
public class TimeEntity {
    private int idTime;
    private Time timeStart;
    private Time timeEnd;
    private Collection<QueueEntity> queuesByIdTime;

    @Id
    @Column(name = "id_time", nullable = false)
    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    @Basic
    @Column(name = "time_start", nullable = true)
    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    @Basic
    @Column(name = "time_end", nullable = true)
    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeEntity that = (TimeEntity) o;

        if (idTime != that.idTime) return false;
        if (timeStart != null ? !timeStart.equals(that.timeStart) : that.timeStart != null) return false;
        if (timeEnd != null ? !timeEnd.equals(that.timeEnd) : that.timeEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTime;
        result = 31 * result + (timeStart != null ? timeStart.hashCode() : 0);
        result = 31 * result + (timeEnd != null ? timeEnd.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "timeByIdTimetable")
    public Collection<QueueEntity> getQueuesByIdTime() {
        return queuesByIdTime;
    }

    public void setQueuesByIdTime(Collection<QueueEntity> queuesByIdTime) {
        this.queuesByIdTime = queuesByIdTime;
    }

//    @Transient
//    public StringProperty timeStartProperty(){
//        return new SimpleStringProperty(timeStart.toInstant().toString());
//    }
}
