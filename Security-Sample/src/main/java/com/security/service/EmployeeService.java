package com.security.service;

import com.security.core.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    List<Employee> empList = Stream.of(
            new Employee(1,"Surya", 4500000),
            new Employee(2,"Dama", 8500000))
            .collect(Collectors.toList());
    public List<Employee> getAllEmployees() {
        return empList;
    }

    public Employee saveEmployee(Employee employee) {
        empList.add(employee);
        return employee;
    }
}
