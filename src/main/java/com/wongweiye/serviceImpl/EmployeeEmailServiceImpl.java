package com.wongweiye.serviceImpl;

import com.wongweiye.model.Address;
import com.wongweiye.model.Email;
import com.wongweiye.model.Employee;
import com.wongweiye.repository.AddressRepository;
import com.wongweiye.repository.EmailRepository;
import com.wongweiye.repository.EmployeeRepository;
import com.wongweiye.service.EmployeeEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeEmailServiceImpl implements EmployeeEmailService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    EmailRepository emailRepository;

    @Override
    public Employee createEmployee(Employee employee) {

//          // this is manually add and created the object
//          List<Email> emails = new ArrayList<>();
//
//
//          Email email = new Email("A",employee);
//          emails.add(email);
//
//
//          email.getEmailAddress().add(new Address("gmail.com",email)); //-- this is for one to many relationship
//          //emails.get(0).setAddress(new Address("gmail.com",email)); // -- this is for one to one relationship
//
//          employee.setName("test report");
//          employee.setEmails(emails);

        employee.getEmails().forEach(d -> d.setEmployee(employee));

        employee.getEmails().forEach(e-> e.getEmailAddress().forEach( s -> s.setEmail(e) )   );

       return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> updateEmployee(long employeeId, Employee employee) {

        return employeeRepository.findById(employeeId).map( emp ->{
            emp.setName(employee.getName());
//            emp.setEmails(employee.getEmails());
//            emp.getEmails().get(0).setEmployee(emp);
//            emp.getEmails().get(0).setEmailAddress( employee.getEmails().get(0).getEmailAddress() );
        return employeeRepository.save(emp);
        });
    }

    @Override
    public Optional<Address> updateAddress(long addressId, long employeeId, Address address) {

        return addressRepository.findById(addressId).map( addr ->{
            addr.setAddressName(address.getAddressName());
            return addressRepository.save(addr);
        });
    }

    @Override
    public Optional<Email> updateEmailAndAddress(long addressId, long emailId, Email inEmail) {
        List<Address> addressList = emailRepository.findById(emailId).get().getEmailAddress();
        return emailRepository.findById(emailId).map(email ->{


            email.getEmailAddress().clear();
            email.getEmailAddress().addAll(inEmail.getEmailAddress());
            email.getEmailAddress().forEach(s-> s.setEmail(email));
            return emailRepository.save(email);


        });
    }


}
