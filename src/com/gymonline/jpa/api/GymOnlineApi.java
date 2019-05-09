package com.gymonline.jpa.api;

import com.gymonline.jpa.models.City;
import com.gymonline.jpa.models.Customer;
import com.gymonline.jpa.models.Gym;
import com.gymonline.jpa.models.Instructor;
import com.gymonline.jpa.repositories.CityRepository;
import com.gymonline.jpa.repositories.CustomerRepository;
import com.gymonline.jpa.repositories.GymRepository;
import com.gymonline.jpa.repositories.InstructorRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationPath("/gymonline")
@Path("/v1.0")
public class GymOnlineApi extends Application {

    @Inject
    private GymRepository gr;
    @Inject
    private CityRepository cr;
    @Inject
    private InstructorRepository ir;

    private CustomerRepository cur;

    @GET
    @Path("/customers")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Customer> getCustomers(){
        return cur.getAll();
    }

    @GET
    @Path("/customers/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Customer> getCustomersById(@PathParam("id") int id){
        return cur.getById(id);
    }

    @GET
    @Path("/gyms")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Gym> getGyms(){
        return gr.getAll();
    }

    @GET
    @Path("/gyms/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Gym> getGymById(@PathParam("id") int id){
            return gr.getById(id);
    }

    @GET
    @Path("/gyms/{id}/activity")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Gym> getActivityByGym(@PathParam("id") int id){
        return gr.getByActivity(id);
    }

    @GET
    @Path("/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCities(){
        return cr.getAll();
    }
<<<<<<< HEAD
=======

    @GET
    @Path("/instructors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Instructor> getInstructors(){
        return ir.getAll();
    }


>>>>>>> 348fe531a857abc2b9020e109a66a53db95c3713
}
