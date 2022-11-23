package com.example.employeeservice.controller;

import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.domain.PersonalDocument;
import com.example.employeeservice.service.EmployeeService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/all-employees")
//    @PreAuthorize("hasAuthority('read')")
    public List<Employee> findAllEmployees() {


        return employeeService.findAllEmployees();
    }

    @DeleteMapping(value = "/all-employees")
//    @PreAuthorize("hasAuthority('delete')")
    @ResponseBody
    public String deleteAllEmployees()
    {
        employeeService.deleteAllAllEmployees();
        return "Successfully deleted all employees";
    }

    
    @PostMapping("/employee")
//    @PreAuthorize("hasAuthority('write')")
    @ResponseBody
    public String save(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "Successfully added an employee";
    }


    @PutMapping( "/employee/{id}")
//    @PreAuthorize("hasAuthority('update')")
    @ResponseBody
    public String updateEmployee(@RequestBody Employee employee,@PathVariable String id)
    {
        employeeService.updateEmployee(employee,id);
        return "Successfully updated an employee";
    }

    @PatchMapping ( "/employee-documents/{id}")
//    @PreAuthorize("hasAuthority('update')")
    @ResponseBody
    public String updateDocuments(@RequestBody String documents, @PathVariable String id)
    {
        System.out.println(documents);
        Gson gson = new Gson();
        List<PersonalDocument> documentList = gson.fromJson(documents, new TypeToken<List<PersonalDocument>>(){}.
                getType());
        employeeService.updateDocuments(id,documentList);
        return "Successfully uploaded documents";
    }

    @DeleteMapping( "/employee/{id}")
//    @PreAuthorize("hasAuthority('delete')")
    @ResponseBody
    public String updateEmployee(@PathVariable String id)
    {
        employeeService.deleteEmployeeById(id);
        return "Successfully deleted an employee";
    }

    //find a employee by id
    @GetMapping( "/employee/{id}")
//    @PreAuthorize("hasAuthority('read')")
    public Employee getEmployeeByID(@PathVariable String id)
    {
        Optional<Employee> employee = employeeService.findEmployeeByID(id);
        if(employee.isPresent())
            return employee.get();
        else return Employee.builder().build();

    }

    @GetMapping( "/employee_userId/{userId}")
//    @PreAuthorize("hasAuthority('read')")
    public Employee getEmployeeByUserID(@PathVariable Integer userId)
    {
        Optional<Employee> employee = employeeService.findEmployeeByUserID(userId);
        if(employee.isPresent())
            return employee.get();
        else return Employee.builder().build();

    }


    @GetMapping( "/employee_houseId/{houseId}")
//    @PreAuthorize("hasAuthority('read')")
    public List<Employee> getEmployeesByHouseID(@PathVariable String houseId)
    {
        Optional<List<Employee>> employee = employeeService.findEmployeeByHouseId(houseId);
        if(employee.isPresent())
            return employee.get();
        else return null;

    }


    @GetMapping("/employees/page/{page}")
//    @PreAuthorize("hasAuthority('read')")
    public List<Employee> findTwoEmployeesByPage(@PathVariable int page) {
        return employeeService.findEmployeesByPage(page, 2);
    }

    @GetMapping("/employees/sort")
//    @PreAuthorize("hasAuthority('read')")
    public List<Employee> findEmployeesBySorting() {
        return employeeService.SortEmployeesByDefaultLastName();
    }




    //get employees by their first name and last name;
    @GetMapping( "/employee-first-last-name")
    public Employee getEmployeeByFirstNameAndLastName(@RequestParam("FirstName") String firstName
            ,@RequestParam("LastName") String lastName)
    {

        Optional<Employee> employee = employeeService.findEmployeeByFirstNameAndLastName(firstName,lastName);
        if(employee.isPresent())
            return employee.get();
        else return null;

    }


    //get employees by their email
    @GetMapping( "/employee-email")
    public Employee getEmployeeByEmail(@RequestParam("email") String email)
    {
        return employeeService.findEmployeeByEmail(email).orElse(null);
    }




}
