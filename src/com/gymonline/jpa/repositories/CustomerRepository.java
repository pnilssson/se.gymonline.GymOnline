package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import java.util.List;

public class CustomerRepository {
    @PersistenceContext(type= PersistenceContextType.EXTENDED, unitName = "GymOnlinePU")
    private EntityManager em;

    public List<Customer> getAll(){
        Query query = em.createQuery("SELECT c FROM Customer c");
        return query.getResultList();
    }

    public List<Customer> getById(int id){
        Query query = em.createQuery("SELECT c FROM Customer c WHERE c.customerId = :customerId")

                .setParameter("customerId", id);
        return query.getResultList();
    }

    public List<Customer> getActivities(int id){

        Query query = em.createQuery("SELECT c.customerFirstName, at.activityTypeName, a.activityDate FROM Customer c join Customer_Activity ca on c.id = ca.cACustomerId join Activity a on ca.cAActivityId = a.activityId join Activity_Type at on a.activityType = at.id WHERE c.id = :customerId") .setParameter("customerId", id);
        return query.getResultList();
    }

    @Transactional
    public Response create(Customer customer){
        em.persist(customer);
        return Response.ok(customer.getCustomerFirstName() + " added.").build();
    }

    @Transactional
    public Response delete(int id){
        Customer customer = em.find(Customer.class, id);
        em.remove(customer);
        return Response.ok(customer.getCustomerFirstName() + " deleted.").build();
    }

    @Transactional
    public Response update(Customer customer){
        em.merge(customer);
        return Response.ok(customer.getCustomerFirstName() + " updated.").build();
    }
}
