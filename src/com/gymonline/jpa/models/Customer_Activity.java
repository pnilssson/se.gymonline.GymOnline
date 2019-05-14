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
@XmlType(name="Instructor_Activity", propOrder = {"cASocialSecurityNumber", "cAActivityId","cARating","cAFeedback"})
@JsonPropertyOrder({"cASocialSecurityNumber", "cAActivityId","cARating","cAFeedback"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "iASocialSecurityNumber")
public class Customer_Activity implements Serializable {

    @Id
    @Column(name = "CA_Social_Security_Number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cASocialSecurityNumber;

    @Id
    @Column(name = "CA_Activity_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cAActivityId;

    @Column(name = "CA_Rating")
    private Integer cARating;

    @Column(name = "CA_Feedback")
    private String cAFeedback;

    public Integer getcASocialSecurityNumber() {
        return cASocialSecurityNumber;
    }

    public void setcASocialSecurityNumber(Integer cASocialSecurityNumber) {
        this.cASocialSecurityNumber = cASocialSecurityNumber;
    }

    public Integer getcAActivityId() {
        return cAActivityId;
    }

    public void setcAActivityId(Integer cAActivityId) {
        this.cAActivityId = cAActivityId;
    }

    public Integer getcARating() {
        return cARating;
    }

    public void setcARating(Integer cARating) {
        this.cARating = cARating;
    }

    public String getcAFeedback() {
        return cAFeedback;
    }

    public void setcAFeedback(String cAFeedback) {
        this.cAFeedback = cAFeedback;
    }
}
