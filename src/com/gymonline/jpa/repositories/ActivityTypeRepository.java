package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Activity;
import com.gymonline.jpa.models.Activity_Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

public class ActivityTypeRepository {
    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;

    public List<Activity_Type> getAll(){
        Query query = em.createQuery("SELECT a FROM Activity_Type a");
        return query.getResultList();
    }

    public List<Activity_Type> getById(int id){
        Query query = em.createQuery("SELECT at FROM Activity_Type at WHERE at.activityGymId = :activityGymId")
                .setParameter("activityGymId", id);
        return query.getResultList();
    }

    public Response delete(int id){
        Activity_Type activity_type = em.find(Activity_Type.class, id);
        em.remove(activity_type);
        return Response.ok(activity_type.getActivityGymId() + " deleted.").build();
    }

    @Transactional
    public Response post(Activity_Type activity_type){
        em.persist(activity_type);
        return Response.ok(activity_type.getActivityTypeName() + " added.").build();
    }

}