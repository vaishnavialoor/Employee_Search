package com.spark.sql.employee.vo;

public class emp_loc_join {
    private int emp_id;
    private String emp_name;
    private int emp_salary;
    //  private Date emp_join_date;
    private int emp_loc_id;
    private String loc_name;
    private int loc_id;

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

    public int getEmp_loc_id() {
        return emp_loc_id;
    }

    public void setEmp_loc_id(int emp_loc_id) {
        this.emp_loc_id = emp_loc_id;
    }

    public String getLoc_name() {
        return loc_name;
    }

    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }

    public int getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(int loc_id) {
        this.loc_id = loc_id;
    }
}
