package com.gymonline.jpa.business;

import com.gymonline.jpa.models.Customer;
import com.gymonline.jpa.repositories.CustomerRepository;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class CustomerBusinessLogic {

    @Inject
    private CustomerRepository cur;

    public Response post(Customer c) {
        return cur.create(c);
    }
    public List<Customer> readAll(){
        return cur.getAll();
    }
    public List<Customer> readById(int id){
        return cur.getById(id);
    }
    public List<Customer> readAllByCriteria(int id){
        return cur.getActivities(id);
    }
    public Response update(Customer customer){
        return cur.update(customer);
    }
    public Response delete(int id){
        return cur.delete(id);
    }
}
