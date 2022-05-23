package com.spark.sql.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
public class EmployeeDataSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDataSearchApplication.class, args);
	}

}
