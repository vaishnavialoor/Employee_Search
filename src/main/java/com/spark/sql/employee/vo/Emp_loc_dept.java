package com.spark.sql.employee.vo;

import lombok.Data;

@Data
public class Emp_loc_dept {
    private Integer emp_id;
    private String emp_name;
    private Integer emp_salary;
     private String emp_join_date;
    private Integer emp_loc_id;
    private String loc_name;
    private Integer loc_id;
    private Integer dept_id;
    private String dept_name;
    private Integer emp_dept_id;

}
