package com.hospitalproject.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by kingm on 15.11.2017.
 */
@Entity
@Table(name = "service_type", schema = "mydb", catalog = "")
public class ServiceTypeEntity {
    private int idServiceType;
    private String serviceName;
    private BigDecimal servicePrice;
    private Collection<ServicesEntity> servicesByIdServiceType;

    @Id
    @Column(name = "id_service_type", nullable = false)
    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }

    @Basic
    @Column(name = "service_name", nullable = true, length = 45)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @Column(name = "service_price", nullable = true, precision = 2)
    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceTypeEntity that = (ServiceTypeEntity) o;

        if (idServiceType != that.idServiceType) return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;
        if (servicePrice != null ? !servicePrice.equals(that.servicePrice) : that.servicePrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idServiceType;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (servicePrice != null ? servicePrice.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "serviceTypeByServiceType")
    public Collection<ServicesEntity> getServicesByIdServiceType() {
        return servicesByIdServiceType;
    }

    public void setServicesByIdServiceType(Collection<ServicesEntity> servicesByIdServiceType) {
        this.servicesByIdServiceType = servicesByIdServiceType;
    }
}
