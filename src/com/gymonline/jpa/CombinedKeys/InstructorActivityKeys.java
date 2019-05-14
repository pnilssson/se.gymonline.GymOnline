package com.gymonline.jpa.CombinedKeys;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class InstructorActivityKeys implements Serializable {
    @Column(name = "IA_Social_Security_Number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iASocialSecurityNumber;

    @Column(name = "IA_Activity_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer iAActivityId;
}
