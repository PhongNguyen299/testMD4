package com.codegym.cs04.dto.request;

import com.codegym.cs04.entity.Department;
import com.codegym.cs04.entity.Role;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class EmployeeRequestDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private String username;

    private String password;

    private boolean gender;

//    private Department department;

    private String job;

    private Role role;

    private Boolean isStatus;

}
