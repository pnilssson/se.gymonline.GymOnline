package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Gym")
@XmlRootElement
@XmlType(name="Gym", propOrder = {"gymId", "gymName", "gymRating", "gymAdress", "gymZipCode", "city"})
@JsonPropertyOrder({"gymId", "gymName", "gymRating", "gymAdress", "gymZipCode", "city"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "gymId")
public class Gym {

    @Id
    @Column(name = "Gym_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gymId;

    @Column(name = "Gym_Name")
    private String gymName;

    @Column(name = "Gym_Rating")
    private Integer gymRating;

    @Column(name = "Gym_Adress")
    private String gymAdress;

    @Column(name = "Gym_Zip_Code")
    private String gymZipCode;

    @Column(name = "Gym_City")
    private Integer gymCity;

    @ManyToOne
    @JoinColumn(name = "Gym_City")
    private City city;

    public Integer getGymId() {
        return gymId;
    }

    public void setGymId(Integer gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public Integer getGymRating() {
        return gymRating;
    }

    public void setGymRating(Integer gymRating) {
        this.gymRating = gymRating;
    }

    public String getGymAdress() {
        return gymAdress;
    }

    public void setGymAdress(String gymAdress) {
        this.gymAdress = gymAdress;
    }

    public String getGymZipCode() {
        return gymZipCode;
    }

    public void setGymZipCode(String gymZipCode) {
        this.gymZipCode = gymZipCode;
    }

    public Integer getGymCity() {
        return gymCity;
    }

    public void setGymCity(Integer gymCity) {
        this.gymCity = gymCity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
