package com.gymonline.jpa.business;

import com.gymonline.jpa.models.Activity_Type;
import com.gymonline.jpa.repositories.ActivityTypeRepository;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class ActivtiyTypeBusinessLogic {

    @Inject
    private ActivityTypeRepository atr;



    public Response post(Activity_Type at){
        return atr.post(at);
    }

    public List<Activity_Type> readAll(){
        return atr.getAll();
    }

    public List<Activity_Type> readById(int id){
        return atr.getById(id);
    }

    public List<Activity_Type> realAllByCriteria(int id){
        return atr.getGyms(id);
    }

    public List<Activity_Type> readIdByCriteria(int id, int gymId){
        return atr.getGymsById(id, gymId);
    }

    public List<Activity_Type> realAllByMultipleCriteria(int id, int gymId){
        return atr.getActivities(id, gymId);
    }

    public List<Activity_Type> readIdByMultipleCriteria(int id, int gymId, int activityId){
        return atr.getActivitiesById(id, gymId, activityId);
    }
}
