package com.spark.sql.employee.model;

import lombok.*;


@Data
public class Employee {
    private  Integer emp_id;
    private String emp_name;
    private  Integer emp_salary;
    private  String emp_join_date;
    private  Integer emp_loc_id;


}
