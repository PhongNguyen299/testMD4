package com.codegym.cs04.entity;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone",length = 10, nullable = false)
    private String phone;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth", length = 200, nullable = false)
    private Date birth;

    @Column(name = "username", length = 200, nullable = false)
    private String username;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "gender", nullable = false)
    private boolean gender;

//    @ManyToOne(targetEntity = Department.class)
//    @JoinColumn(name = "department_id", referencedColumnName = "id")
//    private Department department;

    @Column(name = "job")
    private String job;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "check_in")
    private Long checkIn;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Column(name = "status", nullable = false)
    private Boolean isStatus;
}
