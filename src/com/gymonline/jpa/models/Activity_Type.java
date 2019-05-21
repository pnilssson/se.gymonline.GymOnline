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
@XmlType(name="Activity_Type", propOrder = {"activityTypeId", "activityTypeName"})
@JsonPropertyOrder({"activityTypeId", "activityTypeName"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "activityTypeId")
public class Activity_Type {

    @Id
    @Column(name = "Activity_Type_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityTypeId;

    @Column(name = "Activity_Type_Name")
    private String activityTypeName;

    public Integer getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }
}
