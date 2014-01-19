package com.pivotal.cf.broker.service.impl;

import com.pivotal.cf.broker.exception.ServiceBrokerException;

/**
 * Exception thrown when issues with the underlying Oracle service occur.
 * 
 * @author Mark Alston
 */
public class OracleServiceException extends ServiceBrokerException {

    /**
     * Generated serial version id.
     */
    private static final long serialVersionUID = -2128439169466364344L;

    /**
     * Creates an instance of <code>OracleServiceException</code>.
     * 
     * @param message a detailed message used to describe the cause
     */
    public OracleServiceException(String message) {
        super(message);
    }

}
