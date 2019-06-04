package com.gymonline.jpa.business;

import com.gymonline.jpa.models.Gym;
import com.gymonline.jpa.repositories.GymRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class GymBusinessLogic {
    @Inject
    private GymRepository gr;

    public Response post(Gym g){
        return gr.post(g);
    }

}
