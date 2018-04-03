package com.mycompany.model.entity;

import com.mycompany.model.entity.Designation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-03T15:04:08")
@StaticMetamodel(Staff.class)
public class Staff_ { 

    public static volatile SingularAttribute<Staff, String> firstName;
    public static volatile SingularAttribute<Staff, String> lastName;
    public static volatile SingularAttribute<Staff, String> phoneNumber;
    public static volatile SingularAttribute<Staff, Long> id;
    public static volatile SingularAttribute<Staff, Designation> designation;

}