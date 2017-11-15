package com.hospitalproject.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by kingm on 15.11.2017.
 */
public class DiognosisHasVisitEntityPK implements Serializable {
    private int diognosisIdDiognosis;
    private int visitIdVisit;

    @Column(name = "diognosis_id_diognosis", nullable = false,insertable = false, updatable = false)
    @Id
    public int getDiognosisIdDiognosis() {
        return diognosisIdDiognosis;
    }

    public void setDiognosisIdDiognosis(int diognosisIdDiognosis) {
        this.diognosisIdDiognosis = diognosisIdDiognosis;
    }

    @Column(name = "visit_id_visit", nullable = false,insertable = false, updatable = false)
    @Id
    public int getVisitIdVisit() {
        return visitIdVisit;
    }

    public void setVisitIdVisit(int visitIdVisit) {
        this.visitIdVisit = visitIdVisit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiognosisHasVisitEntityPK that = (DiognosisHasVisitEntityPK) o;

        if (diognosisIdDiognosis != that.diognosisIdDiognosis) return false;
        if (visitIdVisit != that.visitIdVisit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diognosisIdDiognosis;
        result = 31 * result + visitIdVisit;
        return result;
    }
}
