package com.spark.sql.employee.vo;

import lombok.Data;

@Data
public class EmpSearchRequest {
    private String emp_join_date;
    private String dept;
    private String loc;
}
