package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.City;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

public class CityRepository {
    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;

    @Transactional
    public Response post(City city){
        em.persist(city);
        return Response.ok(city.getCityName() + " added.").build();
    }

    public List<City> getById(int id){
        Query query = em.createQuery("SELECT c FROM City c WHERE c.cityId = :cityId")
                .setParameter("cityId", id);
        return query.getResultList();
    }

    public List<City> getAll(){
        Query query = em.createQuery("SELECT c FROM City c");
        return query.getResultList();
    }

    public List<City> getGymsById(int id, int gymId){
        Query query = em.createQuery("SELECT g FROM City c JOIN Gym g on g.city = c.cityId WHERE c.cityId = :cityId AND g.gymId = :gymId")
                .setParameter("cityId", id)
                .setParameter("gymId", gymId);
        return query.getResultList();
    }

    public List<City> getAllGyms(int id){
        Query query = em.createQuery("SELECT g FROM City c JOIN Gym g on g.city = c.cityId WHERE c.cityId = :cityId")
                .setParameter("cityId", id);
        return query.getResultList();
    }
}
