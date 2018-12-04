package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.Service;

import java.util.List;

public interface ServiceService {
    void deleteService(int id);
    void saveService(Service service);
    Service getService(int id);
    List<Service> getServices();
    Service updateService(int id, Service service);
}
