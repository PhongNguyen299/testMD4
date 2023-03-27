package com.codegym.cs04.mapper;


import com.codegym.cs04.dto.request.EmployeeRequestDto;
import com.codegym.cs04.dto.response.EmployeeReponseDto;
import com.codegym.cs04.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {
    public EmployeeReponseDto EntityTransToDto(Employee employee) {
        EmployeeReponseDto employeeDto = new EmployeeReponseDto();
        BeanUtils.copyProperties(employee,employeeDto);
        return employeeDto;
    }

    public List<EmployeeReponseDto> EntitiesTransToDtos(Iterable<Employee> employeeList ){
        List<EmployeeReponseDto> employeeDtoList = new ArrayList<>();

        employeeList.forEach(employee -> {
            EmployeeReponseDto employeeDto = new EmployeeReponseDto();
            BeanUtils.copyProperties(employee,employeeDto);
            employeeDtoList.add(employeeDto);
        });
        return employeeDtoList;
    }

    public Employee DtoTransToEntity( EmployeeRequestDto saveEmployeeDto){
        Employee employee = new Employee();
        BeanUtils.copyProperties(saveEmployeeDto,employee);
        return employee;
    }
}
