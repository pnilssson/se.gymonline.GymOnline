package com.gymonline.jpa.business;

import com.gymonline.jpa.models.Instructor;
import com.gymonline.jpa.repositories.InstructorRepository;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class InstructorBusinessLogic {
    @Inject
    private InstructorRepository ir;


    public Response post(Instructor i){
        return ir.create(i);
    }

    public List<Instructor> readAll(){
        return ir.getAll();
    }

    public List<Instructor> readById(int id){
        return ir.getById(id);
    }

    public List<Instructor> readAllByCriteria(int id){
        return ir.getActivities(id);
    }

    public List<Instructor> readIdByCriteria(int id, int activityId){
        return ir.getActivityById(id, activityId);
    }

    public Response update(Instructor instructor){
        return ir.update(instructor);
    }


    public Response delete(int id){
        return ir.delete(id);
    }

}
