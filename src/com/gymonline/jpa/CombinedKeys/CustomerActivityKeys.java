package com.gymonline.jpa.CombinedKeys;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

public class CustomerActivityKeys implements Serializable {
    @Column(name = "CA_Social_Security_Number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer cASocialSecurityNumber;

    @Column(name = "CA_Activity_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer cAActivityId;
}
