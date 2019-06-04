package com.gymonline.jpa.business;

import com.gymonline.jpa.models.Activity;
import com.gymonline.jpa.repositories.ActivityRepository;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class ActivityBusinessLogic {

    @Inject
    private ActivityRepository ar;
    public Response post(Activity a){
        return ar.post(a);
    }
    public List<Activity> getAll(){
        return ar.getAll();
    }
    public List<Activity> getById(int id){
        return ar.getById(id);
    }
    public Response update(Activity activity){
        return ar.update(activity);
    }
    public Response delete(int id){
        return ar.delete(id);
    }


}
