package com.gymonline.jpa.api;

import com.gymonline.jpa.business.*;
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
    private GymBusinessLogic gr;
    @Inject
    private CityBusinessLogic cr;
    @Inject
    private InstructorBusinessLogic ir;
    @Inject
    private CustomerBusinessLogic cur;
    @Inject
    private ActivityBusinessLogic ar;
    @Inject
    private ActivtiyTypeBusinessLogic atr;

    // -------- Customers -------- //
    // -------- Create -------- //

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/customers")
    public Response postCustomer(Customer c) {
        return cur.post(c);
    }

    // -------- Read -------- //

    @GET
    @Path("/customers")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Customer> getCustomers(){
        return cur.readAll();
    }

    @GET
    @Path("/customers/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Customer> getCustomersById(@PathParam("id") int id){
        return cur.readById(id);
    }

    @GET
    @Path("/customers/{id}/activities")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Customer> getCustomersActivities(@PathParam("id") int id){
        return cur.readAllByCriteria(id);
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
        return gr.readAll();
    }

    @GET
    @Path("/gyms/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Gym> getGymById(@PathParam("id") int id){
        return gr.readById(id);
    }

    @GET
    @Path("/gyms/{id}/activities")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Gym> getActivityByGym(@PathParam("id") int id){
        return gr.readAllByCriteria(id);
    }

    @GET
    @Path("/gyms/{id}/activities/{activityId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Gym> getSpecificGymActivities(@PathParam("id") int id, @PathParam("activityId") int activityId){
        return gr.readIdByCriteria(id, activityId);
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
        return cr.readAll();
    }

    @GET
    @Path("/cities/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCityById(@PathParam("id") int id){
        return cr.readById(id);
    }

    @GET
    @Path("/cities/{id}/gyms")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCitiesByGyms(@PathParam("id") int id){
        return cr.readAllByOneCriteria(id);
    }

    @GET
    @Path("/cities/{id}/gyms/{gymId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCityByIdByGymsId(@PathParam("id") int id, @PathParam("gymId") int gymId){
        return cr.readIdByOneCriteria(id, gymId);
    }

    // -------- Update -------- //
            // Skall ej ha
    // -------- Delete -------- //
            // Skall ej ha




    // -------- Instructors -------- //
    // -------- Create -------- //

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/instructors")
    public Response postInstructor(Instructor i){
        return ir.post(i);
    }


    // -------- Read -------- //

    @GET
    @Path("/instructors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Instructor> getInstructors(){
        return ir.readAll();
    }

    @GET
    @Path("/instructors/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Instructor> getInstructorById(@PathParam("id") int id){
        return ir.readById(id);
    }

    @GET
    @Path("/instructors/{id}/activities")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Instructor> getActivityByInstructor(@PathParam("id") int id){
        return ir.readAllByCriteria(id);
    }

    @GET
    @Path("/instructors/{id}/activities/{activityId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Instructor> getSpecificInstructorActivities(@PathParam("id") int id, @PathParam("activityId") int activityId){
        return ir.readIdByCriteria(id, activityId);
    }

    // -------- Update -------- //

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/instructors/{id}")
    public Response updateInstructorById(@PathParam("id") int id, Instructor instructor){
        return ir.update(instructor);
    }

    // -------- Delete -------- //

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/instructors/{id}")
    public Response deleteInstructorById(@PathParam("id") int id){
        return ir.delete(id);
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
        return atr.readAll();
    }

    @GET
    @Path("/activity_types/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity_Type> getActivityTypesById(@PathParam("id") int id){
        return atr.readById(id);
    }

    @GET
    @Path("/activity_types/{id}/gyms")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity_Type> getActivityTypesByGyms(@PathParam("id") int id){
        return atr.realAllByCriteria(id);
    }

    @GET
    @Path("/activity_types/{id}/gyms/{gymId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity_Type> getActivityTypesByGymsById(@PathParam("id") int id, @PathParam("gymId") int gymId){
        return atr.readIdByCriteria(id, gymId);
    }

    @GET
    @Path("/activity_types/{id}/gyms/{gymId}/activities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity_Type> getActivityTypesByGymsByActivities(@PathParam("id") int id, @PathParam("gymId") int gymId){
        return atr.realAllByMultipleCriteria(id, gymId);
    }

    @GET
    @Path("/activity_types/{id}/gyms/{gymId}/activities/{activityId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity_Type> getActivityTypesByGymsByActivitiesById(@PathParam("id") int id, @PathParam("gymId") int gymId, @PathParam("activityId") int activityId){
        return atr.readIdByMultipleCriteria(id, gymId, activityId);
    }

    // -------- Update -------- //
            // Skall ej ha
    // -------- Delete -------- //
            // Skall ej ha
}
