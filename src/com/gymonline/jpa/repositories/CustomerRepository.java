package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Customer;
import com.gymonline.jpa.models.Gym;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomerRepository {

    @PersistenceContext(unitName = "GymOnlinePU")
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
}
