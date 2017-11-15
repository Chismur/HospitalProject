package com.hospitalproject.model;

import javax.persistence.*;

/**
 * Created by kingm on 15.11.2017.
 */
@Entity
@Table(name = "services_has_visit", schema = "mydb", catalog = "")
@IdClass(ServicesHasVisitEntityPK.class)
public class ServicesHasVisitEntity {
    private int servicesIdServices;
    private int visitIdVisit;
    private ServicesEntity servicesByServicesIdServices;
    private VisitEntity visitByVisitIdVisit;

    @Id
    @Column(name = "services_id_services", nullable = false)
    public int getServicesIdServices() {
        return servicesIdServices;
    }

    public void setServicesIdServices(int servicesIdServices) {
        this.servicesIdServices = servicesIdServices;
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

        ServicesHasVisitEntity that = (ServicesHasVisitEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "services_id_services", referencedColumnName = "id_services", nullable = false)
    public ServicesEntity getServicesByServicesIdServices() {
        return servicesByServicesIdServices;
    }

    public void setServicesByServicesIdServices(ServicesEntity servicesByServicesIdServices) {
        this.servicesByServicesIdServices = servicesByServicesIdServices;
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
