/*
 *-----------------------------------------------------------------------------
 * Copyright 2014 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.pivotal.cf.broker.oracle;

import org.junit.Test;

import com.pivotal.cf.broker.exception.ServiceInstanceBindingExistsException;
import com.pivotal.cf.broker.model.fixture.PlanFixture;
import com.pivotal.cf.broker.model.fixture.ServiceFixture;
import com.pivotal.cf.broker.model.fixture.ServiceInstanceBindingFixture;
import com.pivotal.cf.broker.model.fixture.ServiceInstanceFixture;
import com.pivotal.cf.broker.oracle.OracleBindingService;

/**
 * @author ma250325
 */
public class OracleBindingServiceTest {
    private OracleBindingService bindingService;

    /**
     * Test method for
     * {@link com.pivotal.cf.broker.oracle.OracleBindingService#createServiceInstanceBinding(java.lang.String, com.pivotal.cf.broker.model.ServiceInstance, java.lang.String, java.lang.String, java.lang.String)}
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
     * Test method for {@link com.pivotal.cf.broker.oracle.OracleBindingService#deleteServiceInstanceBinding(java.lang.String)}
     */
    @Test
    public void testDeleteServiceInstanceBinding() {
        bindingService.deleteServiceInstanceBinding(ServiceInstanceBindingFixture.getServiceInstanceBindingId());
    }

    /**
     * Test method for {@link com.pivotal.cf.broker.oracle.OracleBindingService#getServiceInstanceBinding(java.lang.String)}.
     */
    @Test
    public void testGetServiceInstanceBinding() {
        bindingService.getServiceInstanceBinding(ServiceInstanceBindingFixture.getServiceInstanceBindingId());
    }

}
