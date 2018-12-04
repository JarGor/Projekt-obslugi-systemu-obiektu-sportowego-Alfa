package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.Service;
import com.ztbd.sportsfacility.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public List<Service> getServices() {
        return serviceService.getServices();
    }

    @GetMapping("/services/{serviceId}")
    public Service getService(@PathVariable int serviceId) {
        return serviceService.getService(serviceId);
    }

    @PostMapping("/services")
    public Service addService(@RequestBody Service service) {
        serviceService.saveService(service);
        return service;
    }

    @PutMapping("/services/{serviceId}")
    public Service updateService(@PathVariable int serviceId, @RequestBody Service service) {
        return serviceService.updateService(serviceId, service);
    }

    @DeleteMapping("/services/{serviceId}")
    public void deleteService(@PathVariable int serviceId) {
        serviceService.deleteService(serviceId);
    }
}
