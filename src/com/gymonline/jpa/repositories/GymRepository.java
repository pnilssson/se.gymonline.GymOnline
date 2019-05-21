package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Gym;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

public class GymRepository {
    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;

    @Transactional
    public Response post(Gym gym){
        em.persist(gym);
        return Response.ok(gym.getGymName() + " added.").build();
    }

    public List<Gym> getAll(){
        Query query = em.createQuery("SELECT g FROM Gym g");
        return query.getResultList();
    }

    public List<Gym> getById(int id){
        Query query = em.createQuery("SELECT g FROM Gym g WHERE g.gymId = :gymId")
                .setParameter("gymId", id);
        return query.getResultList();
    }

    public List<Gym> getActivities(int id){
        Query query = em.createQuery("SELECT g.gymName, g.gymRating, g.gymAdress, g.gymZipCode, g.city, a.activityId, a.activityRating, a.activityPrice, a.activityPopularity, a.activityDate, a.activityDuration, at.activityTypeName FROM Activity a JOIN a.activityType at JOIN a.activityGym g WHERE g.gymId = :gymId")
                .setParameter("gymId", id);
        return query.getResultList();
    }

    public List<Gym> getActivityById(int id, int activityId){
        Query query = em.createQuery("SELECT g.gymName, g.gymRating, g.gymAdress, g.gymZipCode, g.city, a.activityId, a.activityRating, a.activityPrice, a.activityPopularity, a.activityDate, a.activityDuration, at.activityTypeName FROM Activity a JOIN a.activityType at JOIN a.activityGym g WHERE g.gymId = :gymId AND a.activityId = :activityId")
                .setParameter("gymId", id)
                .setParameter("activityId", activityId);
        return query.getResultList();
    }

    @Transactional
    public Response delete(int id){
        Gym gym = em.find(Gym.class, id);
        em.remove(gym);
        return Response.ok(gym.getGymName() + " deleted.").build();
    }

    @Transactional
    public Response update(Gym gym){
        em.merge(gym);
        return Response.ok(gym.getGymName() + " updated.").build();
    }

}
