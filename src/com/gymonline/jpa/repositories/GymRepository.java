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

    /*SELECT Gym_Name, Gym_Rating, Gym_Adress, Gym_Zip_Code, Gym_City, Activity_Rating, Activity_Price, Activity_Popularity, Activity_Date, Activity_Duration, Activity_Type_Name FROM Gym
    INNER JOIN Activity A on Gym.Gym_Id = A.Acitivty_Gym_Id
    INNER JOIN Activity_Type T on A.Activity_Type = T.Activity_Type_Id
    WHERE Gym.Gym_Id = 5;
     */
    public List<Gym> getByActivity(int id){
        Query query = em.createQuery("SELECT g.gymName, g.gymRating, g.gymAdress, g.gymZipCode, g.city, a.activityRating, a.activityPrice, a.activityPopularity, a.activityDate, a.activityDuration, a.activityType" +
                " FROM Gym g JOIN Activity a JOIN Activity_Type at WHERE g.gymId = :gymId")
                .setParameter("gymId", id);
        return query.getResultList();
    }
}
