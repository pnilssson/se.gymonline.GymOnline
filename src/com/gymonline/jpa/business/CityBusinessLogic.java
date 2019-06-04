package com.gymonline.jpa.business;

import com.gymonline.jpa.models.City;
import com.gymonline.jpa.repositories.CityRepository;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class CityBusinessLogic {
    @Inject
    private CityRepository cr;

    public Response post(City c){
        return cr.post(c);
    }

    public List<City> readAll(){
        return cr.getAll();
    }

    public List<City> readById(int id){
        return cr.getById(id);
    }

    public List<City> readAllByOneCriteria(int id){
        return cr.getAllGyms(id);
    }

    public List<City> readIdByOneCriteria(int id,int gymId){
        return cr.getGymsById(id, gymId);
    }

}
