package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlRootElement
@XmlType(name="Instructor_Activity", propOrder = {"iAId", "iAInstructorId", "iAActivityId"})
@JsonPropertyOrder({"iAId", "iAInstructorId", "iAActivityId"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iAId")
public class Instructor_Activity {

    @Id
    @Column(name = "IA_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iAId;

    @Column(name = "IA_Instructor_Id")
    private Integer iAInstructorId;

    @Column(name = "IA_Activity_Id")
    private Integer iAActivityId;

    public Integer getiAInstructorId() {
        return iAInstructorId;
    }

    public void setiAInstructorId(Integer iAInstructorId) {
        this.iAInstructorId = iAInstructorId;
    }

    public Integer getiAId() {
        return iAId;
    }

    public void setiAId(Integer iAId) {
        this.iAId = iAId;
    }

    public Integer getiAActivityId() {
        return iAActivityId;
    }

    public void setiAActivityId(Integer iAActivityId) {
        this.iAActivityId = iAActivityId;
    }
}
