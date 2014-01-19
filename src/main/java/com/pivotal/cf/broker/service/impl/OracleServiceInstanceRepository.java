/*
 *-----------------------------------------------------------------------------
 * Copyright 2014 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.pivotal.cf.broker.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pivotal.cf.broker.model.ServiceInstance;

/**
 * @author ma250325
 */
public interface OracleServiceInstanceRepository extends JpaRepository<ServiceInstance, String> {

}
