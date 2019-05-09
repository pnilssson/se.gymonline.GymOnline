package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Gym;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class GymRepository {
    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;

    public List<Gym> getAll(){
        Query query = em.createQuery("SELECT g FROM Gym g");
        return query.getResultList();
    }

    public List<Gym> getById(int id){
        Query query = em.createQuery("SELECT g FROM Gym g WHERE g.gymId = :gymId")
                .setParameter("gymId", id);
        return query.getResultList();
    }

    public List<Gym> getByActivity(int id){
        Query query = em.createQuery("SELECT g FROM Gym g ")
    }
}
