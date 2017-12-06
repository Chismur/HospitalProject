package com.hospitalproject.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "qualification", schema = "mydb", catalog = "")
public class QualificationEntity {
    private int idQualification;
    private String qualification;
    private Collection<DoctorEntity> doctorsByIdQualification;

    @Id
    @Column(name = "id_qualification", nullable = false)
    public int getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(int idQualification) {
        this.idQualification = idQualification;
    }

    @Basic
    @Column(name = "qualification", nullable = true, length = 45)
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QualificationEntity that = (QualificationEntity) o;

        if (idQualification != that.idQualification) return false;
        if (qualification != null ? !qualification.equals(that.qualification) : that.qualification != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQualification;
        result = 31 * result + (qualification != null ? qualification.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "qualificationByIdQualification")
    public Collection<DoctorEntity> getDoctorsByIdQualification() {
        return doctorsByIdQualification;
    }

    public void setDoctorsByIdQualification(Collection<DoctorEntity> doctorsByIdQualification) {
        this.doctorsByIdQualification = doctorsByIdQualification;
    }
}
