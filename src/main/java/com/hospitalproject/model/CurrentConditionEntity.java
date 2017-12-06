package com.hospitalproject.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "current_condition", schema = "mydb", catalog = "")
public class CurrentConditionEntity {
    private int idCurrentCondition;
    private String currentCondition;
    private Collection<PatientEntity> patientsByIdCurrentCondition;

    @Id
    @Column(name = "id_current_condition", nullable = false)
    public int getIdCurrentCondition() {
        return idCurrentCondition;
    }

    public void setIdCurrentCondition(int idCurrentCondition) {
        this.idCurrentCondition = idCurrentCondition;
    }

    @Basic
    @Column(name = "current_condition", nullable = true, length = 45)
    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentConditionEntity that = (CurrentConditionEntity) o;

        if (idCurrentCondition != that.idCurrentCondition) return false;
        if (currentCondition != null ? !currentCondition.equals(that.currentCondition) : that.currentCondition != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCurrentCondition;
        result = 31 * result + (currentCondition != null ? currentCondition.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "currentConditionByIdCurrentCondition")
    public Collection<PatientEntity> getPatientsByIdCurrentCondition() {
        return patientsByIdCurrentCondition;
    }

    public void setPatientsByIdCurrentCondition(Collection<PatientEntity> patientsByIdCurrentCondition) {
        this.patientsByIdCurrentCondition = patientsByIdCurrentCondition;
    }
}
