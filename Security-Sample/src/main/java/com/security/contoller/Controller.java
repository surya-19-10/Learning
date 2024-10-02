package com.security.contoller;

import com.security.core.Employee;
import com.security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/home")
    public String getHome(HttpServletRequest request) {
        return "Welcome Home "+request.getSession().getId();
    }
    @GetMapping("/emp")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @PostMapping("/emp")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}
