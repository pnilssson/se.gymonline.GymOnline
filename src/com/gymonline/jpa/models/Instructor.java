package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
@XmlType(name="Instructor", propOrder = {"instructorSocialSecurityNumber", "instructorFirstName", "instructorLastName", "instructorMobileNumber", "instructorEmailAddress", "instructorSalary"})
@JsonPropertyOrder({"instructorSocialSecurityNumber", "instructorFirstName", "instructorLastName", "instructorMobileNumber", "instructorEmailAddress", "instructorSalary"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "instructorSocialSecurityNumber")
public class Instructor {


    @Id
    @Column(name = "Instructor_Social_Security_Number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer instructorSocialSecurityNumber;


    @Column(name = "Instructor_First_Name")
    private String instructorFirstName;

    @Column(name = "Instructor_Last_Name")
    private String instructorLastName;

    @Column(name = "Instructor_Mobile_Number")
    private String instructorMobileNumber;

    @Column(name = "Instructor_Email_Address")
    private String instructorEmailAddress;

    @Column(name = "Instructor_Salary")
    private Integer instructorSalary;

    public Integer getInstructorSocialSecurityNumber() {
        return instructorSocialSecurityNumber;
    }

    public void setInstructorSocialSecurityNumber(Integer instructorSocialSecurityNumber) {
        this.instructorSocialSecurityNumber = instructorSocialSecurityNumber;
    }

    public String getInstructorFirstName() {
        return instructorFirstName;
    }

    public void setInstructorFirstName(String instructorFirstName) {
        this.instructorFirstName = instructorFirstName;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {
        this.instructorLastName = instructorLastName;
    }

    public String getInstructorMobileNumber() {
        return instructorMobileNumber;
    }

    public void setInstructorMobileNumber(String instructorMobilerNumber) {
        this.instructorMobileNumber = instructorMobilerNumber;
    }

    public String getInstructorEmailAddress() {
        return instructorEmailAddress;
    }

    public void setInstructorEmailAddress(String instructorEmailAddress) {
        this.instructorEmailAddress = instructorEmailAddress;
    }

    public Integer getInstructorSalary() {
        return instructorSalary;
    }

    public void setInstructorSalary(Integer instructorSalary) {
        this.instructorSalary = instructorSalary;
    }
}
