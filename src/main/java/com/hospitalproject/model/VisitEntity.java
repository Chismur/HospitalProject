package com.hospitalproject.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "visit", schema = "mydb", catalog = "")
public class VisitEntity {
    private int idVisit;
    private int idPatient;
    private Date dateCured;
    private Date startDateTreatment;
    private Collection<DiognosisHasVisitEntity> diognosisHasVisitsByIdVisit;
    private Collection<QueueEntity> queuesByIdVisit;
    private Collection<ServicesHasVisitEntity> servicesHasVisitsByIdVisit;
    private PatientEntity patientByIdPatient;
    private Collection<VisitHasSpecializationEntity> visitHasSpecializationsByIdVisit;

    @Id
    @Column(name = "id_visit", nullable = false)
    public int getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(int idVisit) {
        this.idVisit = idVisit;
    }

    @Basic
    @Column(name = "id_patient", nullable = false)
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    @Basic
    @Column(name = "date_cured", nullable = true)
    public Date getDateCured() {
        return dateCured;
    }

    public void setDateCured(Date dateCured) {
        this.dateCured = dateCured;
    }

    @Basic
    @Column(name = "start_date_treatment", nullable = true)
    public Date getStartDateTreatment() {
        return startDateTreatment;
    }

    public void setStartDateTreatment(Date startDateTreatment) {
        this.startDateTreatment = startDateTreatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitEntity that = (VisitEntity) o;

        if (idVisit != that.idVisit) return false;
        if (idPatient != that.idPatient) return false;
        if (dateCured != null ? !dateCured.equals(that.dateCured) : that.dateCured != null) return false;
        if (startDateTreatment != null ? !startDateTreatment.equals(that.startDateTreatment) : that.startDateTreatment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisit;
        result = 31 * result + idPatient;
        result = 31 * result + (dateCured != null ? dateCured.hashCode() : 0);
        result = 31 * result + (startDateTreatment != null ? startDateTreatment.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "visitByVisitIdVisit")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Collection<DiognosisHasVisitEntity> getDiognosisHasVisitsByIdVisit() {
        return diognosisHasVisitsByIdVisit;
    }

    public void setDiognosisHasVisitsByIdVisit(Collection<DiognosisHasVisitEntity> diognosisHasVisitsByIdVisit) {
        this.diognosisHasVisitsByIdVisit = diognosisHasVisitsByIdVisit;
    }

    @OneToMany(mappedBy = "visitByIdVisits",cascade = CascadeType.ALL)
    public Collection<QueueEntity> getQueuesByIdVisit() {
        return queuesByIdVisit;
    }

    public void setQueuesByIdVisit(Collection<QueueEntity> queuesByIdVisit) {
        this.queuesByIdVisit = queuesByIdVisit;
    }

    @OneToMany(mappedBy = "visitByVisitIdVisit")
    public Collection<ServicesHasVisitEntity> getServicesHasVisitsByIdVisit() {
        return servicesHasVisitsByIdVisit;
    }

    public void setServicesHasVisitsByIdVisit(Collection<ServicesHasVisitEntity> servicesHasVisitsByIdVisit) {
        this.servicesHasVisitsByIdVisit = servicesHasVisitsByIdVisit;
    }

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient", nullable = false)
    public PatientEntity getPatientByIdPatient() {
        return patientByIdPatient;
    }

    public void setPatientByIdPatient(PatientEntity patientByIdPatient) {
        this.patientByIdPatient = patientByIdPatient;
    }

    @OneToMany(mappedBy = "visitByVisitIdVisit")
    public Collection<VisitHasSpecializationEntity> getVisitHasSpecializationsByIdVisit() {
        return visitHasSpecializationsByIdVisit;
    }

    public void setVisitHasSpecializationsByIdVisit(Collection<VisitHasSpecializationEntity> visitHasSpecializationsByIdVisit) {
        this.visitHasSpecializationsByIdVisit = visitHasSpecializationsByIdVisit;
    }
}
