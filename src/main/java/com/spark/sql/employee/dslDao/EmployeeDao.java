package com.spark.sql.employee.dslDao;


import com.spark.sql.employee.model.Employee;
import com.spark.sql.employee.vo.*;
import org.apache.spark.sql.*;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
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

    Dataset<Row> dept_df=sparkSession.read().
            format("jdbc").
            option("url", "jdbc:mysql://localhost:3306/employee")
            .option("dbtable", "department")
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

    public List<Emp_loc_dept> fetchEmployeeListBasedOnQuery() {
        Encoder<Emp_loc_dept> emp_encoder = Encoders.bean(Emp_loc_dept.class);

        List<Emp_loc_dept> res=emp_df.join(loc_df,emp_df.col("emp_loc_id").equalTo(loc_df.col("loc_id")),"inner").
                                join(dept_df,emp_df.col("emp_dept_id").equalTo(dept_df.col("dept_id")),"inner")
                                .as(emp_encoder).collectAsList();
        return res;

    }

    public List<Employee> getLeftSemiRes() {
        Dataset<Row> emp_dept_join = emp_df.join(dept_df, emp_df.col("emp_dept_id").equalTo(dept_df.col("dept_id")),"leftsemi");
        Encoder<Employee> emp_encoder = Encoders.bean(Employee.class);
        List<Employee> result = emp_dept_join.as(emp_encoder).collectAsList();
        return result;
    }

    public List<Employee> getLeftAntiRes() {
        Dataset<Row> emp_dept_join = emp_df.join(dept_df, emp_df.col("emp_dept_id").equalTo(dept_df.col("dept_id")),"leftanti");
        Encoder<Employee> emp_encoder = Encoders.bean(Employee.class);
        List<Employee> result = emp_dept_join.as(emp_encoder).collectAsList();
        return result;
    }

    public List<emp_dept_join> getLeftOuterRes() {
        Dataset<Row> emp_dept_join = emp_df.join(dept_df, emp_df.col("emp_dept_id").equalTo(dept_df.col("dept_id")),"leftouter");
        Encoder<emp_dept_join> emp_encoder = Encoders.bean(emp_dept_join.class);
        List<emp_dept_join> result = emp_dept_join.as(emp_encoder).collectAsList();
        return result;
    }
}

