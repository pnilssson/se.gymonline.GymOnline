package com.gymonline.jpa.business;

import com.gymonline.jpa.models.Gym;
import com.gymonline.jpa.repositories.GymRepository;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class GymBusinessLogic {
    @Inject
    private GymRepository gr;

    public Response post(Gym g){
        return gr.post(g);
    }
    public List<Gym> readAll(){
        return gr.getAll();
    }
    public List<Gym> readById(int id){
        return gr.getById(id);
    }
    public List<Gym> readAllByCriteria(int id){
        return gr.getActivities(id);
    }

    public List<Gym> readIdByCriteria(int id, int activityId){
        return gr.getActivityById(id, activityId);
    }

    public Response update(Gym gym){
        return gr.update(gym);
    }

    public Response delete(int id){
        return gr.delete(id);
    }


}
