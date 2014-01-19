/*
 *-----------------------------------------------------------------------------
 * Copyright 2014 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.pivotal.cf.broker.service.impl;

import org.junit.Test;

import com.pivotal.cf.broker.exception.ServiceInstanceBindingExistsException;
import com.pivotal.cf.broker.model.fixture.PlanFixture;
import com.pivotal.cf.broker.model.fixture.ServiceFixture;
import com.pivotal.cf.broker.model.fixture.ServiceInstanceBindingFixture;
import com.pivotal.cf.broker.model.fixture.ServiceInstanceFixture;

/**
 * @author ma250325
 */
public class OracleBindingServiceTest {
    private OracleBindingService bindingService;

    /**
     * Test method for
     * {@link com.pivotal.cf.broker.service.impl.OracleBindingService#createServiceInstanceBinding(java.lang.String, com.pivotal.cf.broker.model.ServiceInstance, java.lang.String, java.lang.String, java.lang.String)}
     * .
     * 
     * @throws ServiceInstanceBindingExistsException
     */
    @Test
    public void testCreateServiceInstanceBinding() throws ServiceInstanceBindingExistsException {

        bindingService.createServiceInstanceBinding(ServiceInstanceBindingFixture.getServiceInstanceBindingId(),
                ServiceInstanceFixture.getServiceInstance(), ServiceFixture.getService().getId(), PlanFixture.getPlanOne().getId(),
                ServiceInstanceBindingFixture.getAppGuid());
    }

    /**
     * Test method for {@link com.pivotal.cf.broker.service.impl.OracleBindingService#deleteServiceInstanceBinding(java.lang.String)}
     */
    @Test
    public void testDeleteServiceInstanceBinding() {
        bindingService.deleteServiceInstanceBinding(ServiceInstanceBindingFixture.getServiceInstanceBindingId());
    }

    /**
     * Test method for {@link com.pivotal.cf.broker.service.impl.OracleBindingService#getServiceInstanceBinding(java.lang.String)}.
     */
    @Test
    public void testGetServiceInstanceBinding() {
        bindingService.getServiceInstanceBinding(ServiceInstanceBindingFixture.getServiceInstanceBindingId());
    }

}
