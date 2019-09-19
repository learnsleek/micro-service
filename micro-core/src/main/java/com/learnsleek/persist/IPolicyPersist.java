package com.learnsleek.persist;

import com.learnsleek.exception.PersistentException;
import com.learnsleek.model.Policy;

public interface IPolicyPersist {

    Policy getPolicyDetailFromCore(String policyNumber) throws PersistentException;
}
