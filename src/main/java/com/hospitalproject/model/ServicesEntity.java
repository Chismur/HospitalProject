package com.hospitalproject.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by kingm on 15.11.2017.
 */
@Entity
@Table(name = "services", schema = "mydb", catalog = "")
public class ServicesEntity {
    private int idServices;
    private int serviceType;
    private ServiceTypeEntity serviceTypeByServiceType;
    private Collection<ServicesHasVisitEntity> servicesHasVisitsByIdServices;

    @Id
    @Column(name = "id_services", nullable = false)
    public int getIdServices() {
        return idServices;
    }

    public void setIdServices(int idServices) {
        this.idServices = idServices;
    }

    @Basic
    @Column(name = "service_type", nullable = false)
    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServicesEntity that = (ServicesEntity) o;

        if (idServices != that.idServices) return false;
        if (serviceType != that.serviceType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idServices;
        result = 31 * result + serviceType;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "service_type", referencedColumnName = "id_service_type", nullable = false)
    public ServiceTypeEntity getServiceTypeByServiceType() {
        return serviceTypeByServiceType;
    }

    public void setServiceTypeByServiceType(ServiceTypeEntity serviceTypeByServiceType) {
        this.serviceTypeByServiceType = serviceTypeByServiceType;
    }

    @OneToMany(mappedBy = "servicesByServicesIdServices")
    public Collection<ServicesHasVisitEntity> getServicesHasVisitsByIdServices() {
        return servicesHasVisitsByIdServices;
    }

    public void setServicesHasVisitsByIdServices(Collection<ServicesHasVisitEntity> servicesHasVisitsByIdServices) {
        this.servicesHasVisitsByIdServices = servicesHasVisitsByIdServices;
    }
}
