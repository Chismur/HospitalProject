package com.hospitalproject.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by kingm on 06.12.2017.
 */
public class ServicesHasVisitEntityPK implements Serializable {
    private int servicesIdServices;
    private int visitIdVisit;

    @Column(name = "services_id_services", nullable = false)
    @Id
    public int getServicesIdServices() {
        return servicesIdServices;
    }

    public void setServicesIdServices(int servicesIdServices) {
        this.servicesIdServices = servicesIdServices;
    }

    @Column(name = "visit_id_visit", nullable = false)
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

        ServicesHasVisitEntityPK that = (ServicesHasVisitEntityPK) o;

        if (servicesIdServices != that.servicesIdServices) return false;
        if (visitIdVisit != that.visitIdVisit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = servicesIdServices;
        result = 31 * result + visitIdVisit;
        return result;
    }
}
