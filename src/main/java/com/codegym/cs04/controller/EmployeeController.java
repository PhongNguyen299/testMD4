package com.codegym.cs04.controller;

import com.codegym.cs04.dto.request.EmployeeRequestDto;
import com.codegym.cs04.dto.response.EmployeeReponseDto;
import com.codegym.cs04.entity.Department;
import com.codegym.cs04.entity.Employee;
import com.codegym.cs04.entity.Role;
import com.codegym.cs04.service.EmployeeService;
import com.codegym.cs04.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @ModelAttribute("roles")
    public Iterable<Role> roles(){
        return roleService.getAllRole();
    }

    @GetMapping()
    public ModelAndView getAllEmployees() {
        ModelAndView model = new ModelAndView("/views/list");
        model.addObject("employees",employeeService.getEmployees());
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView getEmployee(@PathVariable("id") Long id) {
        EmployeeReponseDto employee = employeeService.getEmployeeById(id);
        ModelAndView model = new ModelAndView("/views/detail");
        model.addObject("employee", employee);
        return model;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView model = new ModelAndView("views/create");
        model.addObject("employee", new EmployeeRequestDto());
        return model;
    }

    @PostMapping("/create")
    public ModelAndView addNewEmployee(@ModelAttribute EmployeeRequestDto employee) {
        ModelAndView model = new ModelAndView("views/list");
        employeeService.save(employee);
        return model;
    }

    @DeleteMapping("/delete/{id}")
    public void removeEmployee(@PathVariable("id") Long id) {
        EmployeeReponseDto employee = employeeService.getEmployeeById(id);
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable("id") Long id){
        ModelAndView model = new ModelAndView("/views/update/");
        EmployeeReponseDto employee = employeeService.getEmployeeById(id);
        model.addObject("employee", employee);
        return model;
    }

    @PutMapping("/update")
    public ModelAndView updateEmployee(@ModelAttribute("employee") EmployeeReponseDto employee){
        EmployeeRequestDto updateEmployee = new EmployeeRequestDto();
        BeanUtils.copyProperties(employee,updateEmployee);
        employeeService.save(updateEmployee);
        ModelAndView model = new ModelAndView("/customer/edit");
        model.addObject("updateEmployee", updateEmployee);
        model.addObject("message", "Customer updated successfully");
        return model;
    }


   
    @PostMapping("/checkin/{id}")
    public ResponseEntity<?> checkin(@PathVariable("id")  Long id) {
        employeeService.checkin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("findUserName/{username}")
    public ResponseEntity<EmployeeReponseDto> getEmployee(@PathVariable("username") String username) {
        EmployeeReponseDto employee = employeeService.getEmployeeByUsername(username);

        if (employee == null) {
            return new ResponseEntity<EmployeeReponseDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}

