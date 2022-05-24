package com.spark.sql.employee.vo;

import lombok.Data;

@Data
public class Emp_loc_dept {
    private int emp_id;
    private String emp_name;
    private int emp_salary;
     private String emp_join_date;
    private int emp_loc_id;
    private String loc_name;
    private int loc_id;
    private int dept_id;
    private String dept_name;
    private int emp_dept_id;

}
