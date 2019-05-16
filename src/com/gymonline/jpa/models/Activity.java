package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "Activity")
@XmlRootElement
@XmlType(name="Activity", propOrder = {"activityId", "activityRating", "activityPrice", "activityPrice", "activityPopularity", "activityDate", "activityDuration", "activityType", "activityGym"})
@JsonPropertyOrder({"activityId", "activityRating", "activityPrice", "activityPrice", "activityPopularity", "activityDate", "activityDuration", "activityType", "activityGym"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "gymId")
public class Activity {

    @Id
    @Column(name = "Activity_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne
    @JoinColumn(name = "Activity_Type")
    private Activity_Type activityType;

    @ManyToOne
    @JoinColumn(name = "Activity_Gym_Id")
    private Gym activityGym;

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

    public com.gymonline.jpa.models.Activity_Type getActivityType() {
        return activityType;
    }

    public void setActivityType(com.gymonline.jpa.models.Activity_Type activityType) {
        this.activityType = activityType;
    }

    public com.gymonline.jpa.models.Gym getActivityGym() {
        return activityGym;
    }

    public void setActivityGym(com.gymonline.jpa.models.Gym activityGym) {
        this.activityGym = activityGym;
    }
}
