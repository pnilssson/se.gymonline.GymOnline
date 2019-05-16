package com.gymonline.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "Customer")
@XmlRootElement
@XmlType(name="Customer", propOrder = {"customerId", "customerDOB", "customerFirstName","customerLastName","customerMobileNumber","customerEmailAddress"})
@JsonPropertyOrder({"customerId", "customerDOB", "customerFirstName","customerLastName","customerMobileNumber","customerEmailAddress"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerSocialSecurityNumber")
public class Customer {

    @Id
    @Column(name = "Customer_Id")
    private Integer customerId;

    @Column(name = "Customer_DOB")
    private Integer customerDOB;

    @Column(name = "Customer_First_Name")
    private String customerFirstName;

    @Column(name = "Customer_Last_Name")
    private String customerLastName;

    @Column(name = "Customer_Mobile_Number")
    private String customerMobileNumber;

    @Column(name = "Customer_Email_Address")
    private String customerEmailAddress;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerDOB() {
        return customerDOB;
    }

    public void setCustomerDOB(Integer customerDOB) {
        this.customerDOB = customerDOB;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }
}
