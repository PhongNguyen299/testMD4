package com.codegym.cs04.dto.response;

import com.codegym.cs04.entity.Department;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class EmployeeReponseDto {

    private Long id;

    private String name;

    private String email;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth ;
//    private Department department;

    private String job;
    private Long checkIn;

    private Boolean isStatus;

}
