package com.gymonline.jpa.repositories;

import com.gymonline.jpa.models.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

public class InstructorRepository {

    @PersistenceContext(unitName = "GymOnlinePU")
    private EntityManager em;

    @Transactional
    public Response create(Instructor i){
        em.persist(i);
        return Response.ok(i.getInstructorId() + " " + i.getInstructorFirstName() + " created").build();
    }

    public List<Instructor> getAll(){
        Query query = em.createQuery("SELECT i from Instructor i");
        return query.getResultList();
    }

    public List<Instructor> getById(int id){
        Query query = em.createQuery("SELECT i FROM Instructor i WHERE i.instructorId = :instructorId")
                .setParameter("instructorId", id);
        return query.getResultList();
    }

    public List<Instructor> getActivities(int id){
        Query query = em.createQuery("SELECT i.instructorId, i.instructorDOB, i.instructorFirstName, i.instructorLastName, i.instructorEmailAddress, i.instructorMobileNumber, i.instructorSalary, a.activityDate, a.activityDuration, a.activityPopularity, a.activityPrice, a.activityRating, at.activityTypeName FROM Instructor i JOIN Instructor_Activity ia ON i.instructorId = ia.instructorId JOIN Activity a ON ia.iAActivityId = a.activityId JOIN Activity_Type at ON a.activityType.id = at.id WHERE ia.iASocialSecurityNumber = :instructorId")
                .setParameter("instructorId", id);
        return query.getResultList();
    }

    public List<Instructor> getActivityById(int id, int activityId){
        Query query = em.createQuery("SELECT i.instructorId, i.instructorDOB, i.instructorFirstName, i.instructorLastName, i.instructorEmailAddress, i.instructorMobileNumber, i.instructorSalary, a.activityDate, a.activityDuration, a.activityPopularity, a.activityPrice, a.activityRating, at.activityTypeName FROM Instructor i JOIN Instructor_Activity ia ON i.instructorId = ia.instructorId JOIN Activity a ON ia.iAActivityId = a.activityId JOIN Activity_Type at ON a.activityType.id = at.id WHERE ia.iASocialSecurityNumber = :instructorId AND a.activityId = :activityId")
                .setParameter("instructorId", id)
                .setParameter("activityId", activityId);
        return query.getResultList();
    }

    @Transactional
    public Response delete(int id){
        Instructor instructor = em.find(Instructor.class, id);
        em.remove(instructor);
        return Response.ok(instructor.getInstructorId() + " " + instructor.getInstructorFirstName() + " deleted.").build();
    }
}

