package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Entity
@XmlRootElement
@XmlType(name="Instructor_Activity", propOrder = {"iASocialSecurityNumber", "iAActivityId"})
@JsonPropertyOrder({"iASocialSecurityNumber", "iAActivityId"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iASocialSecurityNumber")
public class Instructor_Activity implements Serializable {

    @Id
    @Column(name = "IA_Social_Security_Number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iASocialSecurityNumber;

    @Id
    @Column(name = "IA_Activity_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iAActivityId;

    /*@Column(name = "IA_Activity_Id")
    private Integer iAActivityId;
    */

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