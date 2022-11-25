package com.example.employeeservice.controller;

import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.domain.PersonalDocument;
import com.example.employeeservice.service.EmployeeService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Api(value = "Employee RESTful endpoints")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/all-employees")
    @ApiOperation(value = "Find all employees", response = Iterable.class)
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @DeleteMapping(value = "/all-employees")
    @ResponseBody
    @ApiOperation(value = "Delete all employees", response = String.class)
    public String deleteAllEmployees()
    {
        employeeService.deleteAllAllEmployees();
        return "Successfully deleted all employees";
    }

    
    @PostMapping("/employee")
    @ResponseBody
    @ApiOperation(value = "Create a new employee", response = String.class)
    public String save(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "Successfully added an employee";
    }


    @PutMapping( "/employee/{id}")
    @ResponseBody
    @ApiOperation(value = "Update an employee by employee ID completely", response = String.class)
    public String updateEmployee(@RequestBody Employee employee,@PathVariable String id)
    {
        employeeService.updateEmployee(employee,id);
        return "Successfully updated an employee";
    }


    @DeleteMapping( "/employee/{id}")
    @ResponseBody
    @ApiOperation(value = "Update an employee by employee ID partially", response = String.class)
    public String updateEmployee(@PathVariable String id)
    {
        employeeService.deleteEmployeeById(id);
        return "Successfully deleted an employee";
    }

    //find a employee by id
    @GetMapping( "/employee/{id}")
    @ApiOperation(value = "Find an employee by employee ID", response = Employee.class)
    public Employee getEmployeeByID(@PathVariable String id)
    {
        Optional<Employee> employee = employeeService.findEmployeeByID(id);
        if(employee.isPresent())
            return employee.get();
        else return Employee.builder().build();

    }

    @GetMapping( "/employee_userId/{userId}")
    @ApiOperation(value = "Find an employee by User ID", response = Employee.class)
    public Employee getEmployeeByUserID(@PathVariable Integer userId)
    {
        Optional<Employee> employee = employeeService.findEmployeeByUserID(userId);
        if(employee.isPresent())
            return employee.get();
        else return Employee.builder().build();

    }


    @GetMapping( "/employee_houseId/{houseId}")
    @ApiOperation(value = "Find an employee by House ID", response = Iterable.class)
    public List<Employee> getEmployeesByHouseID(@PathVariable String houseId)
    {
        Optional<List<Employee>> employee = employeeService.findEmployeeByHouseId(houseId);
        if(employee.isPresent())
            return employee.get();
        else return null;

    }


    @GetMapping("/employees/page/{page}")
    @ApiOperation(value = "Find two employees each page,we can specify which page", response = Iterable.class)
    public List<Employee> findTwoEmployeesByPage(@PathVariable int page) {
        return employeeService.findEmployeesByPage(page, 2);
    }

    @GetMapping("/employees/sort")
    @ApiOperation(value = "find all sorted employees", response = Iterable.class)
    public List<Employee> findEmployeesBySorting() {
        return employeeService.SortEmployeesByDefaultLastName();
    }




    @GetMapping( "/employee-first-last-name")
    @ApiOperation(value = "Find an employee by full name", response = Employee.class)
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
    @ApiOperation(value = "Find an employee by email", response = Employee.class)
    public Employee getEmployeeByEmail(@RequestParam("email") String email)
    {
        return employeeService.findEmployeeByEmail(email).orElse(null);
    }




}
