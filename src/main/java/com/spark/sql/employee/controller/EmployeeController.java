package com.spark.sql.employee.controller;

import com.spark.sql.employee.dao.EmployeeDao;
import com.spark.sql.employee.exception.InvalidInputException;
import com.spark.sql.employee.exception.NoResultsFoundException;
import com.spark.sql.employee.model.Employee;
import com.spark.sql.employee.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/salary")
    public ResponseEntity<List<Employee>> getEmployeeListBasedOnSalary(@RequestParam Integer salary) {
        if(salary<0) throw new InvalidInputException();
        List<Employee> res = employeeDao.fetchEmployeeListBasedOnSalary(salary);

        if(res.size()==0) {
            throw new NoResultsFoundException();
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity<List<emp_loc_join>> getEmployeeListBasedOnLocation(@RequestParam String location) {
        List<emp_loc_join> res = employeeDao.fetchEmployeeListBasedOnLocation(location);

        if(res.size()==0) {
            throw new NoResultsFoundException();
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

  /*  @GetMapping("/date_of_joining")
    public ResponseEntity<List<Emp_loc_dept>> getEmployeeListBasedOnLocation(@RequestBody EmpSearchRequest empSearchRequest) {
        List<Emp_loc_dept> res = employeeDao.fetchEmployeeListBasedOnQuery(empSearchRequest);

        if(res.size()==0) {
            throw new NoResultsFoundException();
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }*/

    @GetMapping("/date_of_joining")
    public ResponseEntity<List<Emp_loc_dept>> getEmployeeListBasedOnLocation() {
        List<Emp_loc_dept> res = employeeDao.fetchEmployeeListBasedOnQuery();

        if(res.size()==0) {
            throw new NoResultsFoundException();
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
