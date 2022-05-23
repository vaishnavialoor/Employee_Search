package com.spark.sql.employee.model;

public class Department {
    private String dept_name;
    private String dept_id;

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_name='" + dept_name + '\'' +
                ", dept_id='" + dept_id + '\'' +
                '}';
    }
}
