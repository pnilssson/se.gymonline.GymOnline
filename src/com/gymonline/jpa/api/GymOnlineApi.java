package com.gymonline.jpa.api;

import com.gymonline.jpa.models.*;
import com.gymonline.jpa.repositories.*;
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
    @Inject
    private ActivityRepository ar;
    @Inject
    private ActivityTypeRepository atr;

    // -------- Customers -------- //
    // -------- Create -------- //

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/customers")
    public Response postCustomer(Customer c) {
        return cur.create(c);
    }

    // -------- Read -------- //

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
    @Path("/customers/{id}/activities")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Customer> getCustomersActivities(@PathParam("id") int id){
        return cur.getActivities(id);
    }

    // -------- Update -------- //

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/customers")
    public Response updateCustomer(Customer customer){
        return cur.update(customer);
    }

    // -------- Delete -------- //

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/customers/{id}")
    public Response deleteCustomer(@PathParam("id") int id){
        return cur.delete(id);
    }

    // -------- Gyms -------- //
    // -------- Create -------- //

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/gyms")
    public Response postGym(Gym g){
        return gr.post(g);
    }

    // -------- Read -------- //

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

    // -------- Update -------- //

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/gyms")
    public Response update(Gym gym){
        return gr.update(gym);
    }

    // -------- Delete -------- //

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/gyms/{id}")
    public Response deleteGymById(@PathParam("id") int id){
        return gr.delete(id);
    }

    // -------- Cities -------- //
    // -------- Create -------- //

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cities")
    public Response postCity(City c){
        return cr.post(c);
    }

    // -------- Read -------- //

    @GET
    @Path("/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCities(){
        return cr.getAll();
    }

    @GET
    @Path("/cities/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCityById(@PathParam("id") int id){
        return cr.getById(id);
    }

    // -------- Update -------- //

    // -------- Delete -------- //





    // -------- Instructors -------- //
    // -------- Create -------- //

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/instructors")
    public Response postInstructor(Instructor i){
        return ir.create(i);
    }


    // -------- Read -------- //

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

    @GET
    @Path("/instructors/{id}/activities")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Instructor> getActivityByInstructor(@PathParam("id") int id){
        return ir.getActivities(id);
    }

    @GET
    @Path("/instructors/{id}/activities/{activityId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Instructor> getSpecificInstructorActivities(@PathParam("id") int id, @PathParam("activityId") int activityId){
        return ir.getActivityById(id, activityId);
    }

    // -------- Update -------- //

    // -------- Delete -------- //

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/instructors/{id}")
    public Response deleteInstructorById(@PathParam("id") int id){
        return ir.delete(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/instructors/{id}")
    public Response updateInstructorById(@PathParam("id") int id, Instructor instructor){
        return ir.update(instructor);
    }

    // -------- Activities -------- //
    // -------- Create -------- //

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/activities")
    public Response postActivity(Activity a){
        return ar.post(a);
    }

    // -------- Read -------- //

    @GET
    @Path("/activities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> getActivities(){
        return ar.getAll();
    }

    @GET
    @Path("/activities/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getActivitiesById(@PathParam("id") int id){
        return ar.getById(id);
    }

    // -------- Update -------- //

    @PUT
    @Path("/activities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActivities(Activity activity){
        return ar.update(activity);
    }

    // -------- Delete -------- //

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/activities/{id}")
    public Response delete(@PathParam("id") int id){
        return ar.delete(id);
    }


    // -------- Activity_Type -------- //
    // -------- Create -------- //

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/activity_types")
    public Response postActivityType(Activity_Type at){
        return atr.post(at);
    }

    // -------- Read -------- //

    @GET
    @Path("/activity_types")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity_Type> getActivityTypes(){
        return atr.getAll();
    }

    @GET
    @Path("/activity_types/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity_Type> getActivityTypesById(@PathParam("id") int id){
        return atr.getById(id);
    }

    @GET
    @Path("/activity_types/{id}/gyms")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity_Type> getActivityTypesByGyms(@PathParam("id") int id){
        return atr.getGyms(id);
    }

    @GET
    @Path("/activity_types/{id}/gyms/{gymId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity_Type> getActivityTypesByGymsById(@PathParam("id") int id, @PathParam("gymId") int gymId){
        return atr.getGymsById(id, gymId);
    }

    @GET
    @Path("/activity_types/{id}/gyms/{gymId}/activities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity_Type> getActivityTypesByGymsByActivities(@PathParam("id") int id, @PathParam("gymId") int gymId){
        return atr.getActivities(id, gymId);
    }

    @GET
    @Path("/activity_types/{id}/gyms/{gymId}/activities/{activityId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity_Type> getActivityTypesByGymsByActivitiesById(@PathParam("id") int id, @PathParam("gymId") int gymId, @PathParam("activityId") int activityId){
        return atr.getActivitiesById(id, gymId, activityId);
    }

    // -------- Update -------- //
            // Skall ej ha
    // -------- Delete -------- //
            // Skall ej ha
}
