package com.hospitalproject.model;

import javax.persistence.*;

/**
 * Created by kingm on 06.12.2017.
 */
@Entity
@Table(name = "diognosis_has_visit", schema = "mydb", catalog = "")
@IdClass(DiognosisHasVisitEntityPK.class)
public class DiognosisHasVisitEntity {
    private int diognosisIdDiognosis;
    private int visitIdVisit;
    private DiognosisEntity diognosisByDiognosisIdDiognosis;
    private VisitEntity visitByVisitIdVisit;

    @Id
    @Column(name = "diognosis_id_diognosis", nullable = false)
    public int getDiognosisIdDiognosis() {
        return diognosisIdDiognosis;
    }

    public void setDiognosisIdDiognosis(int diognosisIdDiognosis) {
        this.diognosisIdDiognosis = diognosisIdDiognosis;
    }

    @Id
    @Column(name = "visit_id_visit", nullable = false)
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

        DiognosisHasVisitEntity that = (DiognosisHasVisitEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "diognosis_id_diognosis", referencedColumnName = "id_diognosis", nullable = false)
    public DiognosisEntity getDiognosisByDiognosisIdDiognosis() {
        return diognosisByDiognosisIdDiognosis;
    }

    public void setDiognosisByDiognosisIdDiognosis(DiognosisEntity diognosisByDiognosisIdDiognosis) {
        this.diognosisByDiognosisIdDiognosis = diognosisByDiognosisIdDiognosis;
    }

    @ManyToOne
    @JoinColumn(name = "visit_id_visit", referencedColumnName = "id_visit", nullable = false)
    public VisitEntity getVisitByVisitIdVisit() {
        return visitByVisitIdVisit;
    }

    public void setVisitByVisitIdVisit(VisitEntity visitByVisitIdVisit) {
        this.visitByVisitIdVisit = visitByVisitIdVisit;
    }
}
