package com.wongweiye.controller;

import com.wongweiye.model.Address;
import com.wongweiye.model.Email;
import com.wongweiye.model.Employee;
import com.wongweiye.service.EmployeeEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping(path = "/v1/configurations/EmployeeEmail" , produces = "application/json")
public class EmployeeEmailController {

    @Autowired
    EmployeeEmailService employeeEmailService;

    @PostMapping(path="/create")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){


        Employee newEmployee = employeeEmailService.createEmployee(employee);

        if(newEmployee != null) {
            return ResponseEntity.ok().body(newEmployee);
        }
        else
        {
            return ResponseEntity.notFound().build();

        }
    }

    @PutMapping(path = "/update/{employeeID}", consumes = "application/json" )
    public ResponseEntity<Employee> updateEmployee(@PathVariable long employeeID, @RequestBody Employee employee) {


        Optional<Employee> newEmployee = employeeEmailService.updateEmployee(employeeID, employee);

        if(newEmployee.isPresent()) {
            return ResponseEntity.ok().body(newEmployee.get());
        }
        else
        {
            return ResponseEntity.notFound().build();

        }
    }

    @PutMapping(path = "/update/employee/{employeeID}/address/{addressID}", consumes = "application/json" )
    public ResponseEntity<Address> updateAddress(@PathVariable long addressID, @PathVariable long employeeID, @RequestBody Address address) {


        Optional<Address> newAddress = employeeEmailService.updateAddress(addressID, employeeID, address);

        if(newAddress.isPresent()) {
            return ResponseEntity.ok().body(newAddress.get());
        }
        else
        {
            return ResponseEntity.notFound().build();

        }
    }

    @PutMapping(path = "/update/email/{emailId}/address/{addressID}", consumes = "application/json" )
    public ResponseEntity<Email> updateEmailAndAddress(@PathVariable long addressID, @PathVariable long emailId, @RequestBody Email email) {


        Optional<Email> newEmail = employeeEmailService.updateEmailAndAddress(addressID, emailId, email);

        if(newEmail.isPresent()) {
            return ResponseEntity.ok().body(newEmail.get());
        }
        else
        {
            return ResponseEntity.notFound().build();

        }
    }



}
