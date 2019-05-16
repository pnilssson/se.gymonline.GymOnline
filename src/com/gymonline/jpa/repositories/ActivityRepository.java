package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Activity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

public class ActivityRepository {
    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;

    public List<Activity> getAll(){
        Query query = em.createQuery("SELECT a FROM Activity a");
        return query.getResultList();
    }

    public List<Activity> getById(int id){
        Query query = em.createQuery("SELECT a FROM Activity a WHERE a.activityId = :activityId")
                .setParameter("activityId", id);
        return query.getResultList();
    }

    public Response delete(int id){
        Activity activity = em.find(Activity.class, id);
        em.remove(activity);
        return Response.ok(activity.getActivityId() + " " + activity.getActivityDate() + " deleted.").build();
    }
    @Transactional
    public Response post(Activity activity){
        em.persist(activity);
        return Response.ok(activity.getActivityId() + " added.").build();
    }

}
