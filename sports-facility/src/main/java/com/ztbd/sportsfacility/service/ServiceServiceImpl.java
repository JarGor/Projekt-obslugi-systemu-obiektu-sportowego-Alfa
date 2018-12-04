package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public void deleteService(int id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void saveService(com.ztbd.sportsfacility.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public com.ztbd.sportsfacility.model.Service getService(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<com.ztbd.sportsfacility.model.Service> getServices() {
        List<com.ztbd.sportsfacility.model.Service> services = new ArrayList<>();
        serviceRepository.findAll().forEach(e -> services.add(e));
        return services;
    }

    @Override
    public com.ztbd.sportsfacility.model.Service updateService(int id, com.ztbd.sportsfacility.model.Service service) {
        com.ztbd.sportsfacility.model.Service retService = serviceRepository.findById(id).orElse(null);
        if(service.getName() != null)
            retService.setName(service.getName());
        if(service.getPrice() != 0)
            retService.setPrice(service.getPrice());
        if(service.getPurchases() != null)
            retService.setPurchases(service.getPurchases());
        saveService(retService);
        return retService;
    }
}
