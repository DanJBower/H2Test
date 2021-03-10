package com.danjbower.h2test;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class StartUp
{
    @PersistenceContext(unitName = "com.danjbower_h2test_war_0.0.1PU")
    private EntityManager entityManager;

    @PostConstruct
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void init()
    {
        if (entityManager.find(Test.class, 4) == null)
        {
            Test test = new Test();
            test.setId(4);
            entityManager.persist(test);
        }
    }
}
