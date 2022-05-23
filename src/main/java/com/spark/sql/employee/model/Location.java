package com.spark.sql.employee.model;

public class Location {
    private String loc_name;
    private int loc_id;

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

    @Override
    public String toString() {
        return "Location{" +
                "loc_name='" + loc_name + '\'' +
                ", loc_id=" + loc_id +
                '}';
    }
}
