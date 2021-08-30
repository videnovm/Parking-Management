package com.videnovm.parkingmanagement.service.implementation;

import com.videnovm.parkingmanagement.model.Employee;
import com.videnovm.parkingmanagement.repository.EmployeeRepository;
import com.videnovm.parkingmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setBlacklistRepository(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = employeeRepository.getOne(id);
        employeeToUpdate.setAccepted(employee.isAccepted());
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
