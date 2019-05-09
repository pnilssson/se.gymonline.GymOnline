package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class InstructorRepository {

    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;


    public List<Instructor> getById(int id){
        Query query = em.createQuery("SELECT i FROM Instructor i WHERE i.instructorSocialSecurityNumber = :instructorSocialSecurityNumber")
                .setParameter("instructorSocialSecurityNumber", id);
        return query.getResultList();
    }

    public List<Instructor> getAll(){
        Query query = em.createQuery("SELECT i from Instructor i");
        return query.getResultList();
    }
    public Instructor create (Instructor i){
        em.persist(i);
        return i;
    }
}

