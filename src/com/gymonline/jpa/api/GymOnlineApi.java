package com.gymonline.jpa.api;

import com.gymonline.jpa.models.City;
import com.gymonline.jpa.models.Gym;
import com.gymonline.jpa.models.Instructor;
import com.gymonline.jpa.repositories.CityRepository;
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
    @Path("/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCities(){
        return cr.getAll();
    }

    @GET
    @Path("/instructors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Instructor> getInstructors(){
        return ir.getAll();
    }


}
