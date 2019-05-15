package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Customer;


import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;

public class CustomerRepository {

    @PersistenceContext(type= PersistenceContextType.EXTENDED, unitName = "GymOnlinePU")
    private EntityManager em;





    public List<Customer> getAll(){
        Query query = em.createQuery("SELECT c FROM Customer c");
        return query.getResultList();
    }

    public List<Customer> getById(int id){
        Query query = em.createQuery("SELECT c FROM Customer c WHERE c.customerSocialSecurityNumber = :customerId")
                .setParameter("customerId", id);
        return query.getResultList();
    }
    @Transactional
    public Customer create (Customer c){

        em.persist  (c);
        em.flush();

        return c;
    }
}
