package com.hospitalproject.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "diognosis", schema = "mydb")
public class DiognosisEntity {
    private int idDiognosis;
    private String diognosis;
    private Collection<DiognosisHasVisitEntity> diognosisHasVisitsByIdDiognosis;

    @Id
    @Column(name = "id_diognosis", nullable = false)
    public int getIdDiognosis() {
        return idDiognosis;
    }

    public void setIdDiognosis(int idDiognosis) {
        this.idDiognosis = idDiognosis;
    }

    @Basic
    @Column(name = "diognosis", nullable = true, length = 45)
    public String getDiognosis() {
        return diognosis;
    }

    public void setDiognosis(String diognosis) {
        this.diognosis = diognosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiognosisEntity that = (DiognosisEntity) o;

        if (idDiognosis != that.idDiognosis) return false;
        if (diognosis != null ? !diognosis.equals(that.diognosis) : that.diognosis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDiognosis;
        result = 31 * result + (diognosis != null ? diognosis.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "diognosisByDiognosisIdDiognosis")
    public Collection<DiognosisHasVisitEntity> getDiognosisHasVisitsByIdDiognosis() {
        return diognosisHasVisitsByIdDiognosis;
    }

    public void setDiognosisHasVisitsByIdDiognosis(Collection<DiognosisHasVisitEntity> diognosisHasVisitsByIdDiognosis) {
        this.diognosisHasVisitsByIdDiognosis = diognosisHasVisitsByIdDiognosis;
    }

    @Transient
    public StringProperty  diognosisProperty(){
        return new SimpleStringProperty(diognosis);
    }
}
