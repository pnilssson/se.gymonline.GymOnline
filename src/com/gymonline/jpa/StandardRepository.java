package com.gymonline.jpa;

import javax.ws.rs.core.Response;
import java.util.List;

public interface StandardRepository {
    Response create(Object o);

    List getAll();
    List getById(int id);
    List getActivities(int id);
    List getActivityById(int id, int activityId);

    Response update(Object o);

    Response delete(Object o);
}