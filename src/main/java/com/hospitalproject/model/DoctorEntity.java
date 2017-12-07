package com.hospitalproject.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "doctor", schema = "mydb")
public class DoctorEntity {
    private int idDoctor;
    private String dName;
    private String dSurname;
    private int idPosition;
    private int idQualification;
    private int idSpecialization;
    private PositionEntity positionByIdPosition;
    private QualificationEntity qualificationByIdQualification;
    private SpecializationEntity specializationByIdSpecialization;
    private Collection<QueueEntity> queuesByIdDoctor;

    @Id
    @Column(name = "id_doctor", nullable = false)
    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    @Basic
    @Column(name = "d_name", nullable = true, length = 45)
    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Basic
    @Column(name = "d_surname", nullable = true, length = 45)
    public String getdSurname() {
        return dSurname;
    }

    public void setdSurname(String dSurname) {
        this.dSurname = dSurname;
    }

    @Basic
    @Column(name = "id_position", nullable = false)
    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    @Basic
    @Column(name = "id_qualification", nullable = false)
    public int getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(int idQualification) {
        this.idQualification = idQualification;
    }

    @Basic
    @Column(name = "id_specialization", nullable = false)
    public int getIdSpecialization() {
        return idSpecialization;
    }

    public void setIdSpecialization(int idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorEntity that = (DoctorEntity) o;

        if (idDoctor != that.idDoctor) return false;
        if (idPosition != that.idPosition) return false;
        if (idQualification != that.idQualification) return false;
        if (idSpecialization != that.idSpecialization) return false;
        if (dName != null ? !dName.equals(that.dName) : that.dName != null) return false;
        if (dSurname != null ? !dSurname.equals(that.dSurname) : that.dSurname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDoctor;
        result = 31 * result + (dName != null ? dName.hashCode() : 0);
        result = 31 * result + (dSurname != null ? dSurname.hashCode() : 0);
        result = 31 * result + idPosition;
        result = 31 * result + idQualification;
        result = 31 * result + idSpecialization;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_position", referencedColumnName = "id_position", nullable = false)
    public PositionEntity getPositionByIdPosition() {
        return positionByIdPosition;
    }

    public void setPositionByIdPosition(PositionEntity positionByIdPosition) {
        this.positionByIdPosition = positionByIdPosition;
    }

    @ManyToOne
    @JoinColumn(name = "id_qualification", referencedColumnName = "id_qualification", nullable = false)
    public QualificationEntity getQualificationByIdQualification() {
        return qualificationByIdQualification;
    }

    public void setQualificationByIdQualification(QualificationEntity qualificationByIdQualification) {
        this.qualificationByIdQualification = qualificationByIdQualification;
    }

    @ManyToOne
    @JoinColumn(name = "id_specialization", referencedColumnName = "id_specialization", nullable = false)
    public SpecializationEntity getSpecializationByIdSpecialization() {
        return specializationByIdSpecialization;
    }

    public void setSpecializationByIdSpecialization(SpecializationEntity specializationByIdSpecialization) {
        this.specializationByIdSpecialization = specializationByIdSpecialization;
    }

    @OneToMany(mappedBy = "doctorByIdDoctor")
    public Collection<QueueEntity> getQueuesByIdDoctor() {
        return queuesByIdDoctor;
    }

    public void setQueuesByIdDoctor(Collection<QueueEntity> queuesByIdDoctor) {
        this.queuesByIdDoctor = queuesByIdDoctor;
    }

    @Transient
    public StringProperty positionByIdPositionProperty(){
        return new SimpleStringProperty(positionByIdPosition.getPosition());
    }

    @Transient
    public StringProperty qualificationByIdQualificationProperty(){
        return new SimpleStringProperty(qualificationByIdQualification.getQualification());
    }

    @Transient
    public StringProperty specialisationByIdSpecialisationProperty(){
        return new SimpleStringProperty(specializationByIdSpecialization.getSpecialization());
    }

    @Transient
    public StringProperty dSurnameProperty(){
        return new SimpleStringProperty(dSurname);
    }

    @Transient
    public StringProperty dNameProperty(){
        return new SimpleStringProperty(dName);
    }

    @Transient
    public StringProperty specializationByIdSpecializationProperty(){
        return new SimpleStringProperty(specializationByIdSpecialization.getSpecialization());
    }
}
