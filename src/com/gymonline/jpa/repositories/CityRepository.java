package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.City;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CityRepository {
    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;

    public List<City> getById(int id){
        Query query = em.createQuery("SELECT c FROM City c WHERE c.cityId = :cityId")
                .setParameter("cityId", id);
        return query.getResultList();
    }

    public List<City> getAll(){
        Query query = em.createQuery("SELECT c FROM City c");
        return query.getResultList();
    }
}
