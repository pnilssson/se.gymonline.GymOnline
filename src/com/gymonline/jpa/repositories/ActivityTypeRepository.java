package com.gymonline.jpa.repositories;

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

    @Transactional
    public Response post(Activity_Type activity_type){
        em.persist(activity_type);
        return Response.ok(activity_type.getActivityTypeName() + " added.").build();
    }

    public List<Activity_Type> getAll(){
        Query query = em.createQuery("SELECT at FROM Activity_Type at");
        return query.getResultList();
    }

    public List<Activity_Type> getById(int id){
        Query query = em.createQuery("SELECT at FROM Activity_Type at WHERE at.activityTypeId = :activityTypeId")
                .setParameter("activityTypeId", id);
        return query.getResultList();
    }

    @Transactional
    public Response delete(int id){
        Activity_Type activity_type = em.find(Activity_Type.class, id);
        em.remove(activity_type);
        return Response.ok(activity_type.getActivityTypeId() + " deleted.").build();
    }


    public List<Activity_Type> getGyms (int id){
        Query query = em.createQuery("SELECT g FROM Activity_Type at JOIN Activity a on a.activityType = at.activityTypeId AND a.activityType = :activityTypeId JOIN Gym g on g.gymId = a.activityGym WHERE at.activityTypeId = :activityTypeId GROUP BY g.gymId")
                .setParameter("activityTypeId", id);
        return query.getResultList();
    }

    public List<Activity_Type> getGymsById (int id, int gymId){
        Query query = em.createQuery("SELECT g FROM Activity_Type at JOIN Activity a on a.activityType = at.activityTypeId JOIN Gym g on g.gymId = a.activityGym WHERE at.activityTypeId = :activityTypeId AND g.gymId = :gymId GROUP BY g.gymId")
                .setParameter("activityTypeId", id)
                .setParameter("gymId", gymId);
        return query.getResultList();
    }

    public List<Activity_Type> getActivities (int id, int gymId){
        Query query = em.createQuery("SELECT a FROM Activity_Type at JOIN Activity a on a.activityType = at.activityTypeId AND a.activityType = :activityTypeId JOIN Gym g on g.gymId = a.activityGym WHERE at.activityTypeId = :activityTypeId AND g.gymId = :gymId")
                .setParameter("activityTypeId", id)
                .setParameter("gymId", gymId);
        return query.getResultList();
    }

    public List<Activity_Type> getActivitiesById (int id, int gymId, int activityId) {
        Query query = em.createQuery("SELECT a FROM Activity_Type at JOIN Activity a on a.activityType = at.activityTypeId AND a.activityType = :activityTypeId JOIN Gym g on g.gymId = a.activityGym WHERE at.activityTypeId = :activityTypeId AND g.gymId = :gymId AND a.activityId = :activityId")
                .setParameter("activityTypeId", id)
                .setParameter("gymId", gymId)
                .setParameter("activityId", activityId);
        return query.getResultList();
    }
}
