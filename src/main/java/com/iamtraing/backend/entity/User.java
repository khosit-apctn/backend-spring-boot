package com.iamtraing.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "m_user")
public class User extends BaseEntity {

    @Column(nullable = false,unique = true,length = 60)
    private String email;

    @Column(nullable = false,length = 120)
    private String password;

    @Column(nullable = false, length = 120)
    private String name;

}
