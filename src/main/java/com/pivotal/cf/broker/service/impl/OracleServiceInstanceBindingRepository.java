/*
 *-----------------------------------------------------------------------------
 * Copyright 2014 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.pivotal.cf.broker.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pivotal.cf.broker.model.ServiceInstanceBinding;

/**
 * @author ma250325
 */
public interface OracleServiceInstanceBindingRepository extends JpaRepository<ServiceInstanceBinding, String> {

}
