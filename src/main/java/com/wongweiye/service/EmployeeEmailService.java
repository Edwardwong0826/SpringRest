package com.wongweiye.service;

import com.wongweiye.model.Address;
import com.wongweiye.model.Email;
import com.wongweiye.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeEmailService {

    public Employee createEmployee(Employee employee);
    public Optional<Employee> updateEmployee(long employeeId, Employee employee);

    public Optional<Address> updateAddress(long addressId, long employeeId, Address address);

    public Optional<Email> updateEmailAndAddress(long addressId, long emailId, Email address);

    public List<Email> checkEmail(long employeeId);
}
