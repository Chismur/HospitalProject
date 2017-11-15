package com.hospitalproject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by kingm on 15.11.2017.
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
    private VisitHasSpecializationEntity visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization;
    private DoctorEntity doctorByIdDoctor;
    private TimeEntity timeByIdTimetable;
    private DateEntity dateByIdWeekday;
    private Collection<VisitEntity> visitsByIdQueue;

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

    @ManyToOne
    @JoinColumn(name = "visit_has_specialization_id_visit_has_specialization", referencedColumnName = "id_visit_has_specialization")
    public VisitHasSpecializationEntity getVisitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization() {
        return visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization;
    }

    public void setVisitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization(VisitHasSpecializationEntity visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization) {
        this.visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization = visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization;
    }

    @ManyToOne
    @JoinColumn(name = "id_doctor", referencedColumnName = "id_doctor", nullable = false ,insertable= false, updatable=false)
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

    @OneToMany(mappedBy = "queueByIdQueue")
    public Collection<VisitEntity> getVisitsByIdQueue() {
        return visitsByIdQueue;
    }

    public void setVisitsByIdQueue(Collection<VisitEntity> visitsByIdQueue) {
        this.visitsByIdQueue = visitsByIdQueue;
    }
}
