package com.spark.sql.employee.sparksqlDao;


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

    Dataset<Row> dept_df=sparkSession.read().
            format("jdbc").
            option("url", "jdbc:mysql://localhost:3306/employee")
            .option("dbtable", "department")
            .option("user", "root")
            .option("password", "Sastry123$").load();

    public List<Employee> fetchEmployeeListBasedOnSalary(Integer salary) {
       // emp_df.createOrReplaceGlobalTempView("emp");
        emp_df.createOrReplaceTempView("emp");
        Encoder<Employee> emp_encoder = Encoders.bean(Employee.class);
        List<Employee> result = sparkSession.sql("select * from emp where emp_salary >"+salary).as(emp_encoder).collectAsList();
        return result;

    }

    public List<emp_loc_join> fetchEmployeeListBasedOnLocation(String location) {
        emp_df.createOrReplaceTempView("emp");
        loc_df.createOrReplaceTempView("loc");
        Encoder<emp_loc_join> emp_loc_encoder = Encoders.bean(emp_loc_join.class);
        List<emp_loc_join> result = sparkSession.sql("select * from emp e inner join loc l on e.emp_loc_id=l.loc_id and l.loc_name="+location).as(emp_loc_encoder).collectAsList();
        return result;
    }

    public List<Emp_loc_dept> fetchEmployeeListBasedOnQuery() {
        emp_df.createOrReplaceTempView("emp");
        loc_df.createOrReplaceTempView("loc");
        dept_df.createOrReplaceTempView("dept");
        Encoder<Emp_loc_dept> emp_encoder = Encoders.bean(Emp_loc_dept.class);

        List<Emp_loc_dept> res=sparkSession.sql("select * from emp e inner join loc l on e.emp_loc_id=l.loc_id inner join dept d on e.emp_dept_id=d.dept_id")
                                .as(emp_encoder).collectAsList();
        return res;

    }

    public List<Employee> getLeftSemiRes() {
        emp_df.createOrReplaceTempView("emp");
        dept_df.createOrReplaceTempView("dept");
        Encoder<Employee> emp_encoder = Encoders.bean(Employee.class);
        List<Employee> result = sparkSession.sql("select * from emp e left semi join dept d on e.emp_dept_id==d.dept_id").as(emp_encoder).collectAsList();
        return result;
    }

    public List<Employee> getLeftAntiRes() {
        emp_df.createOrReplaceTempView("emp");
        dept_df.createOrReplaceTempView("dept");
        Encoder<Employee> emp_encoder = Encoders.bean(Employee.class);
        List<Employee> result = sparkSession.sql("select * from emp e left anti join dept d on e.emp_dept_id=d.dept_id").as(emp_encoder).collectAsList();
        return result;
    }

    public List<emp_dept_join> getLeftOuterRes() {

        emp_df.createOrReplaceTempView("emp");
        dept_df.createOrReplaceTempView("dept");
        Encoder<emp_dept_join> emp_dept_encoder = Encoders.bean(emp_dept_join.class);
        List<emp_dept_join> result = sparkSession.sql("select * from emp e left outer join dept d on e.emp_dept_id=d.dept_id").as(emp_dept_encoder).collectAsList();
        return result;
    }
}


