package com.spark.sql.employee.vo;

import lombok.Data;


@Data
public class emp_dept_join {
    private Integer emp_id;
    private String emp_name;
    private Integer emp_salary;
    private Integer emp_dept_id;
     //private Date emp_join_date;
    private Integer emp_loc_id;
    private String dept_name;
    private Integer dept_id;


}
