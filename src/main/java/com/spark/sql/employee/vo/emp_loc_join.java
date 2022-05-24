package com.spark.sql.employee.vo;

import lombok.*;

@Data
public class emp_loc_join {
    private int emp_id;
    private String emp_name;
    private int emp_salary;
    //  private Date emp_join_date;
    private int emp_loc_id;
    private String loc_name;
    private int loc_id;


}
