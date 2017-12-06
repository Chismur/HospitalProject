package com.hospitalproject.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "visit_has_specialization", schema = "mydb", catalog = "")
public class VisitHasSpecializationEntity {
    private int idVisitHasSpecialization;
    private int visitIdVisit;
    private int specializationIdSpecialization;
    private Collection<QueueEntity> queuesByIdVisitHasSpecialization;
    private VisitEntity visitByVisitIdVisit;
    private SpecializationEntity specializationBySpecializationIdSpecialization;

    @Id
    @Column(name = "id_visit_has_specialization", nullable = false)
    public int getIdVisitHasSpecialization() {
        return idVisitHasSpecialization;
    }

    public void setIdVisitHasSpecialization(int idVisitHasSpecialization) {
        this.idVisitHasSpecialization = idVisitHasSpecialization;
    }

    @Basic
    @Column(name = "visit_id_visit", nullable = false)
    public int getVisitIdVisit() {
        return visitIdVisit;
    }

    public void setVisitIdVisit(int visitIdVisit) {
        this.visitIdVisit = visitIdVisit;
    }

    @Basic
    @Column(name = "specialization_id_specialization", nullable = false)
    public int getSpecializationIdSpecialization() {
        return specializationIdSpecialization;
    }

    public void setSpecializationIdSpecialization(int specializationIdSpecialization) {
        this.specializationIdSpecialization = specializationIdSpecialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitHasSpecializationEntity that = (VisitHasSpecializationEntity) o;

        if (idVisitHasSpecialization != that.idVisitHasSpecialization) return false;
        if (visitIdVisit != that.visitIdVisit) return false;
        if (specializationIdSpecialization != that.specializationIdSpecialization) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisitHasSpecialization;
        result = 31 * result + visitIdVisit;
        result = 31 * result + specializationIdSpecialization;
        return result;
    }

    @OneToMany(mappedBy = "visitHasSpecializationByVisitHasSpecializationIdVisitHasSpecialization")
    public Collection<QueueEntity> getQueuesByIdVisitHasSpecialization() {
        return queuesByIdVisitHasSpecialization;
    }

    public void setQueuesByIdVisitHasSpecialization(Collection<QueueEntity> queuesByIdVisitHasSpecialization) {
        this.queuesByIdVisitHasSpecialization = queuesByIdVisitHasSpecialization;
    }

    @ManyToOne
    @JoinColumn(name = "visit_id_visit", referencedColumnName = "id_visit", nullable = false)
    public VisitEntity getVisitByVisitIdVisit() {
        return visitByVisitIdVisit;
    }

    public void setVisitByVisitIdVisit(VisitEntity visitByVisitIdVisit) {
        this.visitByVisitIdVisit = visitByVisitIdVisit;
    }

    @ManyToOne
    @JoinColumn(name = "specialization_id_specialization", referencedColumnName = "id_specialization", nullable = false)
    public SpecializationEntity getSpecializationBySpecializationIdSpecialization() {
        return specializationBySpecializationIdSpecialization;
    }

    public void setSpecializationBySpecializationIdSpecialization(SpecializationEntity specializationBySpecializationIdSpecialization) {
        this.specializationBySpecializationIdSpecialization = specializationBySpecializationIdSpecialization;
    }
}
