package com.example.employeeservice.repository;


import com.example.employeeservice.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {

    @Override
    List<Employee> findAll();

    Optional<Employee> findByUserID(Integer UserID);
    Optional<Employee> findById(String ID);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByFirstNameAndLastName(String FirstName,String LastName);

    Optional<List<Employee>> findByHouseID(String houseId);

    @Override
    Employee save(Employee employee);



    @Override
    boolean existsById(String s);

    @Override
    long count();

    @Override
    void delete(Employee employee);

    @Override
    void deleteById(String Id);

    @Override
    void deleteAll();


    // find (by name)
//    @Query("From Employee where FirstName=?1 and LastName=?2")
//    List<Employee> findEmployeeByFirstNameAndLastName( String firstName, String LastName);



    // find (sort by one field)







}