package com.hospitalproject.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "queue", schema = "mydb")
public class QueueEntity {
    private int idQueue;
    private Date currentDate;
    private Integer cabNum;
    private Integer visitHasSpecializationIdVisitHasSpecialization;
    private int idDoctor;
    private Integer idTimetable;
    private Integer idWeekday;
    private Integer idVisits;
    private VisitHasSpecializationEntity visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization;
    private DoctorEntity doctorByIdDoctor;
    private TimeEntity timeByIdTimetable;
    private DateEntity dateByIdWeekday;
    private VisitEntity visitByIdVisits;

    @Id
    @Column(name = "id_queue", nullable = false)
    public int getIdQueue() {
        return idQueue;
    }

    public void setIdQueue(int idQueue) {
        this.idQueue = idQueue;
    }

    @Basic
    @Column(name = "current_date", nullable = true)
    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    @Basic
    @Column(name = "cab_num", nullable = true)
    public Integer getCabNum() {
        return cabNum;
    }

    public void setCabNum(Integer cabNum) {
        this.cabNum = cabNum;
    }

    @Basic
    @Column(name = "visit_has_specialization_id_visit_has_specialization", nullable = true)
    public Integer getVisitHasSpecializationIdVisitHasSpecialization() {
        return visitHasSpecializationIdVisitHasSpecialization;
    }

    public void setVisitHasSpecializationIdVisitHasSpecialization(Integer visitHasSpecializationIdVisitHasSpecialization) {
        this.visitHasSpecializationIdVisitHasSpecialization = visitHasSpecializationIdVisitHasSpecialization;
    }

    @Basic
    @Column(name = "id_doctor", nullable = false)
    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    @Basic
    @Column(name = "id_timetable", nullable = true)
    public Integer getIdTimetable() {
        return idTimetable;
    }

    public void setIdTimetable(Integer idTimetable) {
        this.idTimetable = idTimetable;
    }

    @Basic
    @Column(name = "id_weekday", nullable = true)
    public Integer getIdWeekday() {
        return idWeekday;
    }

    public void setIdWeekday(Integer idWeekday) {
        this.idWeekday = idWeekday;
    }

    @Basic
    @Column(name = "id_visits", nullable = true)
    public Integer getIdVisits() {
        return idVisits;
    }

    public void setIdVisits(Integer idVisits) {
        this.idVisits = idVisits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueueEntity that = (QueueEntity) o;

        if (idQueue != that.idQueue) return false;
        if (idDoctor != that.idDoctor) return false;
        if (currentDate != null ? !currentDate.equals(that.currentDate) : that.currentDate != null) return false;
        if (cabNum != null ? !cabNum.equals(that.cabNum) : that.cabNum != null) return false;
        if (visitHasSpecializationIdVisitHasSpecialization != null ? !visitHasSpecializationIdVisitHasSpecialization.equals(that.visitHasSpecializationIdVisitHasSpecialization) : that.visitHasSpecializationIdVisitHasSpecialization != null)
            return false;
        if (idTimetable != null ? !idTimetable.equals(that.idTimetable) : that.idTimetable != null) return false;
        if (idWeekday != null ? !idWeekday.equals(that.idWeekday) : that.idWeekday != null) return false;
        if (idVisits != null ? !idVisits.equals(that.idVisits) : that.idVisits != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQueue;
        result = 31 * result + (currentDate != null ? currentDate.hashCode() : 0);
        result = 31 * result + (cabNum != null ? cabNum.hashCode() : 0);
        result = 31 * result + (visitHasSpecializationIdVisitHasSpecialization != null ? visitHasSpecializationIdVisitHasSpecialization.hashCode() : 0);
        result = 31 * result + idDoctor;
        result = 31 * result + (idTimetable != null ? idTimetable.hashCode() : 0);
        result = 31 * result + (idWeekday != null ? idWeekday.hashCode() : 0);
        result = 31 * result + (idVisits != null ? idVisits.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "visit_has_specialization_id_visit_has_specialization", referencedColumnName = "id_visit_has_specialization")
    public VisitHasSpecializationEntity getVisitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization() {
        return visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization;
    }

    public void setVisitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization(VisitHasSpecializationEntity visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization) {
        this.visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization = visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization;
    }

    @ManyToOne
    @JoinColumn(name = "id_doctor", referencedColumnName = "id_doctor", nullable = false)
    public DoctorEntity getDoctorByIdDoctor() {
        return doctorByIdDoctor;
    }

    public void setDoctorByIdDoctor(DoctorEntity doctorByIdDoctor) {
        this.doctorByIdDoctor = doctorByIdDoctor;
    }

    @ManyToOne
    @JoinColumn(name = "id_timetable", referencedColumnName = "id_time")
    public TimeEntity getTimeByIdTimetable() {
        return timeByIdTimetable;
    }

    public void setTimeByIdTimetable(TimeEntity timeByIdTimetable) {
        this.timeByIdTimetable = timeByIdTimetable;
    }

    @ManyToOne
    @JoinColumn(name = "id_weekday", referencedColumnName = "id_date")
    public DateEntity getDateByIdWeekday() {
        return dateByIdWeekday;
    }

    public void setDateByIdWeekday(DateEntity dateByIdWeekday) {
        this.dateByIdWeekday = dateByIdWeekday;
    }

    @ManyToOne
    @JoinColumn(name = "id_visits", referencedColumnName = "id_visit")
    public VisitEntity getVisitByIdVisits() {
        return visitByIdVisits;
    }

    public void setVisitByIdVisits(VisitEntity visitByIdVisits) {
        this.visitByIdVisits = visitByIdVisits;
    }
}
