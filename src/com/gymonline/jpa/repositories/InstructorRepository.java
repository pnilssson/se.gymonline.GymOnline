package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import java.util.List;

public class InstructorRepository {

    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;

    public List<Instructor> getAll(){
        Query query = em.createQuery("SELECT i from Instructor i");
        return query.getResultList();
    }

    public List<Instructor> getById(int id){
        Query query = em.createQuery("SELECT i FROM Instructor i WHERE i.instructorSocialSecurityNumber = :instructorSocialSecurityNumber")
                .setParameter("instructorSocialSecurityNumber", id);
        return query.getResultList();
    }

    public List<Instructor> getActivities(int id){
        Query query = em.createQuery("SELECT i.instructorSocialSecurityNumber, i.instructorFirstName, i.instructorLastName, i.instructorEmailAddress, i.instructorMobileNumber, i.instructorSalary, a.activityDate, a.activityDuration, a.activityPopularity, a.activityPrice, a.activityRating, at.activityTypeName FROM Instructor_Activity ia JOIN ia.id iaid JOIN iaid..instructorSocialSecurityNumber = :instructorId")
                .setParameter("instructorId", id);
        return query.getResultList();
    }

    public Instructor create(Instructor i){
        em.persist(i);
        return i;
    }

    public Response delete(int id){
        Instructor instructor = em.find(Instructor.class, id);
        em.remove(instructor);
        return Response.ok(instructor.getInstructorSocialSecurityNumber() + " " + instructor.getInstructorFirstName() + " deleted.").build();
    }
}

