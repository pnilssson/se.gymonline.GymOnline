package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Activity_Type")
@XmlRootElement
@XmlType(name="Activity_Type", propOrder = {"activityGymId", "activityTypeName"})
@JsonPropertyOrder({"activityGymId", "activityTypeName"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "activityGymId")
public class Activity_Type {

    @Id
    @Column(name = "Activity_Type_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer activityGymId;

    @Column(name = "Activity_Type_Name")
    private String activityTypeName;

    public Integer getActivityGymId() {
        return activityGymId;
    }

    public void setActivityGymId(Integer activityGymId) {
        this.activityGymId = activityGymId;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }
}
