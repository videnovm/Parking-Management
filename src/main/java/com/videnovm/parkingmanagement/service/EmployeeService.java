package com.videnovm.parkingmanagement.service;

import com.videnovm.parkingmanagement.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
