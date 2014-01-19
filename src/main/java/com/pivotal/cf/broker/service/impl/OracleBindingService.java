/*
 *-----------------------------------------------------------------------------
 * Copyright 2014 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.pivotal.cf.broker.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pivotal.cf.broker.exception.ServiceInstanceBindingExistsException;
import com.pivotal.cf.broker.model.ServiceInstance;
import com.pivotal.cf.broker.model.ServiceInstanceBinding;
import com.pivotal.cf.broker.service.ServiceInstanceBindingService;

/**
 * @author Mark Alston
 */
@Service
public class OracleBindingService implements ServiceInstanceBindingService {

    private final OracleAdminService oracle;

    private final OracleServiceInstanceBindingRepository repository;

    /**
     * Creates an instance of <code>OracleBindingService</code>.
     * 
     * @param repository
     */
    @Autowired
    public OracleBindingService(OracleAdminService oracle, OracleServiceInstanceBindingRepository repository) {
        this.oracle = oracle;
        this.repository = repository;
    }

    /**
     * {@inheritDoc} Required implementation.
     */
    @Override
    public ServiceInstanceBinding createServiceInstanceBinding(String bindingId, ServiceInstance serviceInstance, String serviceId,
            String planId, String appGuid) throws ServiceInstanceBindingExistsException {// , ServiceBrokerException {
        ServiceInstanceBinding binding = repository.findOne(bindingId);
        if (binding != null) {
            throw new ServiceInstanceBindingExistsException(binding);
        }
        // Map<String, Object> credentials = oracle.getCredentials();
        String syslogDrainUrl = oracle.getSyslogDrainUrl();
        String database = serviceInstance.getId();
        String username = bindingId;
        // TODO Password Generator
        String password = "password";

        // TODO check if user already exists in the DB

        oracle.createUser(database, username, password);

        Map<String, Object> credentials = new HashMap<String, Object>();
        credentials.put("uri", oracle.getConnectionString(database, username, password));

        binding = new ServiceInstanceBinding(bindingId, serviceInstance.getId(), credentials, syslogDrainUrl, appGuid);

        return repository.save(binding);
    }

    /**
     * {@inheritDoc} Required implementation.
     */
    @Override
    public ServiceInstanceBinding deleteServiceInstanceBinding(String id) {// throws ServiceBrokerException {
        ServiceInstanceBinding binding = repository.findOne(id);
        if (binding != null) {
            oracle.deleteUser(binding.getServiceInstanceId(), binding.getId());
            repository.delete(binding.getId());
        }
        return binding;
    }

    /**
     * {@inheritDoc} Required implementation.
     */
    @Override
    public ServiceInstanceBinding getServiceInstanceBinding(String id) {
        return repository.findOne(id);
    }

}
