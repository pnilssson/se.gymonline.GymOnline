package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlRootElement
@XmlType(name="Instructor_Activity", propOrder = {"iAId", "iASocialSecurityNumber", "iAActivityId"})
@JsonPropertyOrder({"iAId", "iASocialSecurityNumber", "iAActivityId"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iASocialSecurityNumber")
public class Instructor_Activity {

    @Id
    @Column(name = "IA_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iAId;

    @Column(name = "IA_Social_Security_Number")
    private Integer iASocialSecurityNumber;

    @Column(name = "IA_Activity_Id")
    private Integer iAActivityId;

    public Integer getiAId() {
        return iAId;
    }

    public void setiAId(Integer iAId) {
        this.iAId = iAId;
    }

    public Integer getiASocialSecurityNumber() {
        return iASocialSecurityNumber;
    }

    public void setiASocialSecurityNumber(Integer iASocialSecurityNumber) {
        this.iASocialSecurityNumber = iASocialSecurityNumber;
    }

    public Integer getiAActivityId() {
        return iAActivityId;
    }

    public void setiAActivityId(Integer iAActivityId) {
        this.iAActivityId = iAActivityId;
    }
}
