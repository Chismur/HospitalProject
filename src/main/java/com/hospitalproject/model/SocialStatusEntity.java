package com.hospitalproject.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 15.11.2017.
 */
@Entity
@Table(name = "social_status", schema = "mydb", catalog = "")
public class SocialStatusEntity {
    private int idSocialStatus;
    private String socialStatus;
    private Collection<PatientEntity> patientsByIdSocialStatus;

    @Id
    @Column(name = "id_social_status", nullable = false)
    public int getIdSocialStatus() {
        return idSocialStatus;
    }

    public void setIdSocialStatus(int idSocialStatus) {
        this.idSocialStatus = idSocialStatus;
    }

    @Basic
    @Column(name = "social_status", nullable = true, length = 45)
    public String getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(String socialStatus) {
        this.socialStatus = socialStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocialStatusEntity that = (SocialStatusEntity) o;

        if (idSocialStatus != that.idSocialStatus) return false;
        if (socialStatus != null ? !socialStatus.equals(that.socialStatus) : that.socialStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSocialStatus;
        result = 31 * result + (socialStatus != null ? socialStatus.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "socialStatusByIdSocialStatus")
    public Collection<PatientEntity> getPatientsByIdSocialStatus() {
        return patientsByIdSocialStatus;
    }

    public void setPatientsByIdSocialStatus(Collection<PatientEntity> patientsByIdSocialStatus) {
        this.patientsByIdSocialStatus = patientsByIdSocialStatus;
    }
}
