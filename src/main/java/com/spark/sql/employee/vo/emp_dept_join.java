package com.spark.sql.employee.vo;

import lombok.Data;

@Data
public class emp_dept_join {
    private int emp_id;
    private String emp_name;
    private int emp_salary;
    private int emp_dept_id;
     //private Date emp_join_date;
    private int emp_loc_id;
    private String dept_name;
    private int dept_id;


}
