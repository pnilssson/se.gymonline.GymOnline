package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Activity")
@XmlRootElement
@XmlType(name="Activity", propOrder = {"activityId", "activityRating", "activityPrice", "activityPopularity", "activityDate", "activityDuration", "activityType", "activityGym"})
@JsonPropertyOrder({"activityId", "activityRating", "activityPrice", "activityPrice", "activityPopularity", "activityDate", "activityDuration", "activityType", "activityGym"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "activityId")
public class Activity {

    @Id
    @Column(name = "Activity_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;

    @Column(name = "Activity_Rating")
    private Integer activityRating;

    @Column(name = "Activity_Price")
    private Integer activityPrice;

    @Column(name = "Activity_Popularity")
    private Integer activityPopularity;

    @Column(name = "Activity_Date")
    private String activityDate;

    @Column(name = "Activity_Duration")
    private Integer activityDuration;

    @Column(name = "Activity_Type")
    private Integer activityType;

    @Column(name = "Activity_Gym_Id")
    private Integer activityGym;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getActivityRating() {
        return activityRating;
    }

    public void setActivityRating(Integer activityRating) {
        this.activityRating = activityRating;
    }

    public Integer getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Integer activityPrice) {
        this.activityPrice = activityPrice;
    }

    public Integer getActivityPopularity() {
        return activityPopularity;
    }

    public void setActivityPopularity(Integer activityPopularity) {
        this.activityPopularity = activityPopularity;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public Integer getActivityDuration() {
        return activityDuration;
    }

    public void setActivityDuration(Integer activityDuration) {
        this.activityDuration = activityDuration;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getActivityGym() {
        return activityGym;
    }

    public void setActivityGym(Integer activityGym) {
        this.activityGym = activityGym;
    }
}
