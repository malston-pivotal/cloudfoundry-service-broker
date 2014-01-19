/*
 *-----------------------------------------------------------------------------
 * Copyright 2014 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.pivotal.cf.broker.service.impl;

import org.springframework.stereotype.Service;

/**
 * @author ma250325
 */
@Service
public class OracleAdminService {
    /**
     * Creates an instance of <code>OracleAdminService</code>.
     */
    public OracleAdminService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param id
     * @return
     */
    public boolean createDatabase(String id) {
        return false;
    }

    /**
     * @param database
     * @param username
     * @param password
     */
    public void createUser(String database, String username, String password) {
        // TODO Auto-generated method stub

    }

    /**
     * @param id
     * @return
     */
    public boolean databaseExists(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param id
     */
    public void deleteDatabase(String id) {
        // TODO Auto-generated method stub

    }

    /**
     * @param serviceInstanceId
     * @param id
     */
    public void deleteUser(String serviceInstanceId, String id) {
        // TODO Auto-generated method stub

    }

    /**
     * @param database
     * @param username
     * @param password
     * @return
     */
    public String getConnectionString(String database, String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    public String getSyslogDrainUrl() {
        // TODO Auto-generated method stub
        return null;
    }

}
