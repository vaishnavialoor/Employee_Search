package com.spark.sql.employee.dao;


import com.spark.sql.employee.model.Employee;
import com.spark.sql.employee.vo.*;
import org.apache.spark.sql.*;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {

    private static final SparkSession sparkSession =
            SparkSession.builder().master("local[*]").appName("SparkRESTAPI").getOrCreate();


    Dataset<Row> emp_df = sparkSession.read().
            format("jdbc").
            option("url", "jdbc:mysql://localhost:3306/employee")
            .option("dbtable", "employee")
            .option("user", "root")
            .option("password", "Sastry123$").load();
    Dataset<Row> loc_df = sparkSession.read().
            format("jdbc").
            option("url", "jdbc:mysql://localhost:3306/employee")
            .option("dbtable", "location")
            .option("user", "root")
            .option("password", "Sastry123$").load();

    public List<Employee> fetchEmployeeListBasedOnSalary(Integer salary) {
        Encoder<Employee> emp_encoder = Encoders.bean(Employee.class);
        List<Employee> result = emp_df.filter("emp_salary>" + salary).as(emp_encoder).collectAsList();
        return result;

    }

    public List<emp_loc_join> fetchEmployeeListBasedOnLocation(String location) {
        Dataset<Row> emp_loc_join = emp_df.join(loc_df, emp_df.col("emp_loc_id").equalTo(loc_df.col("loc_id")),"inner");
        Encoder<emp_loc_join> emp_loc_encoder = Encoders.bean(emp_loc_join.class);
        List<emp_loc_join> result = emp_loc_join.filter("loc_name="+location).as(emp_loc_encoder).collectAsList();
        return result;
    }

     /*   emp_df.filter("emp_join_date> '2021-01-01'")
        Dataset <Row> emp_loc_join = emp_df.join(loc_df,emp_df.col("emp_loc_id").equalTo(loc_df.col("loc_id")));
        emp_loc_join.filter("loc_name='Mumbai'");*/
}


