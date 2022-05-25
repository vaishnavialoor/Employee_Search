package com.spark.sql.employee.vo;

import lombok.*;

@Data
public class emp_loc_join {
    private Integer emp_id;
    private String emp_name;
    private Integer emp_salary;
    //  private Date emp_join_date;
    private Integer emp_loc_id;
    private String loc_name;
    private Integer loc_id;

}
