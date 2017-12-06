package com.hospitalproject.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by kingm on 15.11.2017.
 */
@Entity
@Table(name = "patient", schema = "mydb")
public class PatientEntity {
    private int idPatient;
    private String pName;
    private String pSurname;
    private Date bDate;
    private int idSocialStatus;
    private int idCurrentCondition;
    private SocialStatusEntity socialStatusByIdSocialStatus;
    private CurrentConditionEntity currentConditionByIdCurrentCondition;
    private Collection<VisitEntity> visitsByIdPatient;

    @Id
    @Column(name = "id_patient", nullable = false)
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    @Basic
    @Column(name = "p_name", nullable = true, length = 45)
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Basic
    @Column(name = "p_surname", nullable = true, length = 45)
    public String getpSurname() {
        return pSurname;
    }

    public void setpSurname(String pSurname) {
        this.pSurname = pSurname;
    }

    @Basic
    @Column(name = "b_date", nullable = true)
    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    @Basic
    @Column(name = "id_social_status", nullable = false)
    public int getIdSocialStatus() {
        return idSocialStatus;
    }

    public void setIdSocialStatus(int idSocialStatus) {
        this.idSocialStatus = idSocialStatus;
    }

    @Basic
    @Column(name = "id_current_condition", nullable = false)
    public int getIdCurrentCondition() {
        return idCurrentCondition;
    }

    public void setIdCurrentCondition(int idCurrentCondition) {
        this.idCurrentCondition = idCurrentCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientEntity that = (PatientEntity) o;

        if (idPatient != that.idPatient) return false;
        if (idSocialStatus != that.idSocialStatus) return false;
        if (idCurrentCondition != that.idCurrentCondition) return false;
        if (pName != null ? !pName.equals(that.pName) : that.pName != null) return false;
        if (pSurname != null ? !pSurname.equals(that.pSurname) : that.pSurname != null) return false;
        if (bDate != null ? !bDate.equals(that.bDate) : that.bDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPatient;
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        result = 31 * result + (pSurname != null ? pSurname.hashCode() : 0);
        result = 31 * result + (bDate != null ? bDate.hashCode() : 0);
        result = 31 * result + idSocialStatus;
        result = 31 * result + idCurrentCondition;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_social_status", referencedColumnName = "id_social_status", nullable = false)
    public SocialStatusEntity getSocialStatusByIdSocialStatus() {
        return socialStatusByIdSocialStatus;
    }

    public void setSocialStatusByIdSocialStatus(SocialStatusEntity socialStatusByIdSocialStatus) {
        this.socialStatusByIdSocialStatus = socialStatusByIdSocialStatus;
    }

    @ManyToOne
    @JoinColumn(name = "id_current_condition", referencedColumnName = "id_current_condition", nullable = false)
    public CurrentConditionEntity getCurrentConditionByIdCurrentCondition() {
        return currentConditionByIdCurrentCondition;
    }

    public void setCurrentConditionByIdCurrentCondition(CurrentConditionEntity currentConditionByIdCurrentCondition) {
        this.currentConditionByIdCurrentCondition = currentConditionByIdCurrentCondition;
    }

    @OneToMany(mappedBy = "patientByIdPatient")
    public Collection<VisitEntity> getVisitsByIdPatient() {
        return visitsByIdPatient;
    }

    public void setVisitsByIdPatient(Collection<VisitEntity> visitsByIdPatient) {
        this.visitsByIdPatient = visitsByIdPatient;
    }
}
