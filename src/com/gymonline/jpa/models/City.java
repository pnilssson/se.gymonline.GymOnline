package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "City")
@XmlRootElement
@XmlType(name="City", propOrder = {"cityId", "cityName"})
@JsonPropertyOrder({"cityId", "cityName"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cityId")
public class City {

    @Id
    @Column(name = "City_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cityId;

    @Column(name = "City_Name")
    private String cityName;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
