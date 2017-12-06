package com.hospitalproject.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "position", schema = "mydb", catalog = "")
public class PositionEntity {
    private int idPosition;
    private String position;
    private Collection<DoctorEntity> doctorsByIdPosition;

    @Id
    @Column(name = "id_position", nullable = false)
    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    @Basic
    @Column(name = "position", nullable = true, length = 45)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionEntity that = (PositionEntity) o;

        if (idPosition != that.idPosition) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPosition;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "positionByIdPosition")
    public Collection<DoctorEntity> getDoctorsByIdPosition() {
        return doctorsByIdPosition;
    }

    public void setDoctorsByIdPosition(Collection<DoctorEntity> doctorsByIdPosition) {
        this.doctorsByIdPosition = doctorsByIdPosition;
    }
}
