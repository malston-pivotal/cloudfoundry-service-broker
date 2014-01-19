/*
 *-----------------------------------------------------------------------------
 * Copyright 2014 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.pivotal.cf.broker.oracle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pivotal.cf.broker.exception.ServiceBrokerException;
import com.pivotal.cf.broker.exception.ServiceInstanceExistsException;
import com.pivotal.cf.broker.model.ServiceDefinition;
import com.pivotal.cf.broker.model.ServiceInstance;
import com.pivotal.cf.broker.service.ServiceInstanceService;

/**
 * @author ma250325
 */
@Service
public class OracleService implements ServiceInstanceService {

    private final OracleAdminService oracle;

    private final OracleServiceInstanceRepository repository;

    /**
     * Creates an instance of <code>OracleService</code>.
     * 
     * @param oracle
     * @param repository
     */
    @Autowired
    public OracleService(OracleAdminService oracle, OracleServiceInstanceRepository repository) {
        this.oracle = oracle;
        this.repository = repository;
    }

    /**
     * {@inheritDoc} Required implementation.
     */
    @Override
    public ServiceInstance createServiceInstance(ServiceDefinition serviceDef, String serviceInstanceId, String planId,
            String organizationGuid, String spaceGuid) throws ServiceInstanceExistsException, ServiceBrokerException {

        ServiceInstance instance = repository.findOne(serviceInstanceId);

        if (instance != null) {
            throw new ServiceInstanceExistsException(instance);
        }
        instance = new ServiceInstance(serviceInstanceId, serviceDef.getId(), planId, organizationGuid, spaceGuid, null);

        if (oracle.databaseExists(instance.getId())) {
            // ensure the instance is empty
            oracle.deleteDatabase(instance.getId());
        }
        boolean databaseExists = oracle.createDatabase(instance.getId());

        if (!databaseExists) {
            throw new ServiceBrokerException("Failed to create new DB instance: " + instance.getId());
        }

        return repository.save(instance);
    }

    /**
     * {@inheritDoc} Required implementation.
     */
    @Override
    public ServiceInstance deleteServiceInstance(String id) {// throws ServiceBrokerException {
        oracle.deleteDatabase(id);
        ServiceInstance instance = repository.findOne(id);
        repository.delete(id);
        return instance;
    }

    /**
     * {@inheritDoc} Required implementation.
     */
    @Override
    public List<ServiceInstance> getAllServiceInstances() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc} Required implementation.
     */
    @Override
    public ServiceInstance getServiceInstance(String id) {
        return repository.findOne(id);
    }

}
