/*
 *-----------------------------------------------------------------------------
 * Copyright 2014 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.pivotal.cf.broker.service.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.pivotal.cf.broker.exception.ServiceBrokerException;
import com.pivotal.cf.broker.exception.ServiceInstanceExistsException;
import com.pivotal.cf.broker.model.ServiceDefinition;
import com.pivotal.cf.broker.model.ServiceInstance;
import com.pivotal.cf.broker.model.fixture.DataFixture;
import com.pivotal.cf.broker.model.fixture.PlanFixture;
import com.pivotal.cf.broker.model.fixture.ServiceFixture;
import com.pivotal.cf.broker.model.fixture.ServiceInstanceFixture;

/**
 * @author ma250325
 */
public class OracleServiceTest {

    /**
     * 
     */
    private OracleService serviceInstanceService;

    /**
     * Test method for
     * {@link com.pivotal.cf.broker.service.impl.OracleService#createServiceInstance(com.pivotal.cf.broker.model.ServiceDefinition, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
     * .
     * 
     * @throws ServiceBrokerException
     * @throws ServiceInstanceExistsException
     */
    @Test
    public void testCreateServiceInstance() throws ServiceInstanceExistsException, ServiceBrokerException {
        ServiceDefinition service = ServiceFixture.getService();
        ServiceInstance serviceInstance =
                serviceInstanceService.createServiceInstance(service, null, PlanFixture.getPlanOne().getId(),
                        DataFixture.getOrgOneGuid(), DataFixture.getSpaceOneGuid());
        Assert.assertNotNull("Service cannot be null", serviceInstance);
    }

    /**
     * Test method for {@link com.pivotal.cf.broker.service.impl.OracleService#deleteServiceInstance(java.lang.String)}.
     */
    @Test
    public void testDeleteServiceInstance() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.pivotal.cf.broker.service.impl.OracleService#getAllServiceInstances()}.
     */
    @Test
    public void testGetAllServiceInstances() {
        List<ServiceInstance> instances = serviceInstanceService.getAllServiceInstances();
        Assert.assertTrue(instances.size() > 0);
    }

    /**
     * Test method for {@link com.pivotal.cf.broker.service.impl.OracleService#getServiceInstance(java.lang.String)}.
     */
    @Test
    public void testGetServiceInstance() {
        ServiceInstance instance = serviceInstanceService.getServiceInstance(ServiceInstanceFixture.getServiceInstanceId());
        Assert.assertNotNull(instance);
    }

}
