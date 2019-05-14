package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gymonline.jpa.CombinedKeys.InstructorActivityKeys;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Entity
@XmlRootElement
@XmlType(name="Instructor_Activity", propOrder = {"iASocialSecurityNumber", "iAActivityId"})
@JsonPropertyOrder({"iASocialSecurityNumber", "iAActivityId"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iASocialSecurityNumber")
@IdClass(InstructorActivityKeys.class)
public class Instructor_Activity {

    @Id
    private Integer iASocialSecurityNumber;

    @Id
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
