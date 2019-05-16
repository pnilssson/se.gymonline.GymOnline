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
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Inject
    private CustomerRepository cur;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/customers")
    public Customer postCustomer(Customer c) {
        c = cur.create(c);
        return c;
    }

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/gyms")
    public Response postGym(Gym g){
        return gr.post(g);
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
    @Path("/gyms/{id}/activities")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Gym> getActivityByGym(@PathParam("id") int id){
        return gr.getActivities(id);
    }

    @GET
    @Path("/gyms/{id}/activities/{activityId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Gym> getSpecificGymActivities(@PathParam("id") int id, @PathParam("activityId") int activityId){
        return gr.getActivityById(id, activityId);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/gyms/{id}")
    public Response deleteGymById(@PathParam("id") int id){
        return gr.delete(id);
    }

    @GET
    @Path("/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCities(){
        return cr.getAll();
    }

    @GET
    @Path("/cities/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCitiesById(@PathParam("id") int id){
        return cr.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/instructors")
    public Response postInstructor(Instructor i){
        i = ir.create(i);
        return Response.ok(i.getInstructorSocialSecurityNumber() + " created").build();
    }

    @GET
    @Path("/instructors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Instructor> getInstructors(){
        return ir.getAll();
    }

    @GET
    @Path("/instructors/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Instructor> getInstructorById(@PathParam("id") int id){
        return ir.getById(id);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/instructors/{id}")
    public Response deleteInstructorById(@PathParam("id") int id){
        return ir.delete(id);
    }
}
