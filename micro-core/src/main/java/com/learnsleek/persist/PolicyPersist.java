package com.learnsleek.persist;

import com.learnsleek.exception.PersistentException;
import com.learnsleek.model.Policy;
import org.springframework.stereotype.Repository;

@Repository
public class PolicyPersist implements IPolicyPersist {


    @Override
    public Policy getPolicyDetailFromCore(String policyNumber) throws PersistentException {
        throw new PersistentException("Persist");
        //return new Policy("A1014123");
    }
}
