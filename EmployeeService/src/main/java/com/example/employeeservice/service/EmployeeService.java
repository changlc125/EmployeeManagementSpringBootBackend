package com.example.employeeservice.service;

import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.domain.PersonalDocument;
import com.example.employeeservice.repository.EmployeeRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private  final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // find
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }


    public Optional<Employee> findEmployeeByUserID(Integer UserID) {return employeeRepo.findByUserID(UserID);}


    public Optional<Employee> findEmployeeByID(String id)
    {
        return employeeRepo.findById(id);
    }


    public Optional<Employee> findEmployeeByFirstNameAndLastName(String FirstName,String LastName)
    {
        return employeeRepo.findByFirstNameAndLastName(FirstName, LastName);
    }


    public Optional<Employee> findEmployeeByEmail(String email)
    {
        return employeeRepo.findByEmail(email);
    }


  public Optional<List<Employee>> findEmployeeByHouseId(String houseId)
  {
    return employeeRepo.findByHouseID(houseId);
   }

    public void deleteAllAllEmployees(){
        employeeRepo.deleteAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }


    public void updateEmployee(Employee employee,String id) {

       if(employeeRepo.existsById(id))
       {
           employee.setId(id);
           employeeRepo.save(employee);
       }
    }

    public void updateDocuments(String id, List<PersonalDocument> personalDocumentList)
    {
        if(employeeRepo.existsById(id))
        {
            Employee employee = findEmployeeByID(id).get();
            employee.setId(id);
            employee.setPersonalDocuments(personalDocumentList);
            employeeRepo.save(employee);
        }
    }


    public void deleteEmployeeById(String id)
    {
        if(employeeRepo.existsById(id))
            employeeRepo.deleteById(id);
    }





    //find( pagination)
    public List<Employee> findEmployeesByPage(int page, int size)
    {
        return employeeRepo.findAll(PageRequest.of(page, size)).getContent();
    }


    public  List<Employee> SortEmployeesByDefaultLastName()
    {
        Sort sort = Sort.by("LastName").ascending();
        List<Employee> all = employeeRepo.findAll(sort);
        return all;
    }


//    public  List<Employee> SortEmployeesByField(String field)
//    {
//
//        Sort sort = Sort.by("LastName").ascending();
//        List<Employee> all = employeeRepo.findAll(sort);
//        return all;
//    }



}
