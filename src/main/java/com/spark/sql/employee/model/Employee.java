package com.spark.sql.employee.model;

import java.util.Date;

public class Employee {
    private int emp_id;
    private String emp_name;
    private int emp_salary;
  //  private Date emp_join_date;
    private int emp_loc_id;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(int emp_salary) {
        this.emp_salary = emp_salary;
    }

    /*public Date getEmp_join_date() {
        return emp_join_date;
    }

    public void setEmp_join_date(Date emp_join_date) {
        this.emp_join_date = emp_join_date;
    }*/

    public int getEmp_loc_id() {
        return emp_loc_id;
    }

    public void setEmp_loc_id(int emp_loc_id) {
        this.emp_loc_id = emp_loc_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_salary=" + emp_salary +
               /* ", emp_join_date=" + emp_join_date +*/
                ", emp_loc_id=" + emp_loc_id +
                '}';
    }
}
