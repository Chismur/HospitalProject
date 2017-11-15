package com.hospitalproject.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 15.11.2017.
 */
@Entity
@Table(name = "specialization", schema = "mydb", catalog = "")
public class SpecializationEntity {
    private int idSpecialization;
    private String specialization;
    private Collection<DoctorEntity> doctorsByIdSpecialization;
    private Collection<VisitHasSpecializationEntity> visitHasSpecializationsByIdSpecialization;

    @Id
    @Column(name = "id_specialization", nullable = false)
    public int getIdSpecialization() {
        return idSpecialization;
    }

    public void setIdSpecialization(int idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    @Basic
    @Column(name = "specialization", nullable = true, length = 45)
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecializationEntity that = (SpecializationEntity) o;

        if (idSpecialization != that.idSpecialization) return false;
        if (specialization != null ? !specialization.equals(that.specialization) : that.specialization != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSpecialization;
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "specializationByIdSpecialization")
    public Collection<DoctorEntity> getDoctorsByIdSpecialization() {
        return doctorsByIdSpecialization;
    }

    public void setDoctorsByIdSpecialization(Collection<DoctorEntity> doctorsByIdSpecialization) {
        this.doctorsByIdSpecialization = doctorsByIdSpecialization;
    }

    @OneToMany(mappedBy = "specializationBySpecializationIdSpecialization")
    public Collection<VisitHasSpecializationEntity> getVisitHasSpecializationsByIdSpecialization() {
        return visitHasSpecializationsByIdSpecialization;
    }

    public void setVisitHasSpecializationsByIdSpecialization(Collection<VisitHasSpecializationEntity> visitHasSpecializationsByIdSpecialization) {
        this.visitHasSpecializationsByIdSpecialization = visitHasSpecializationsByIdSpecialization;
    }
}
