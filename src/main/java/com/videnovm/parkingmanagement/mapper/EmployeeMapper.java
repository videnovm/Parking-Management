package com.videnovm.parkingmanagement.mapper;

import com.videnovm.parkingmanagement.dto.EmployeeDto;
import com.videnovm.parkingmanagement.model.Employee;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @IterableMapping(qualifiedByName = "toEmployeeDto")
    List<EmployeeDto> toEmployeeDtos(List<Employee> employees);

    @Named("toEmployee")
    Employee toEmployee(EmployeeDto employeeDto);

    @Named("toEmployeeDto")
    EmployeeDto toEmployeeDto(Employee employee);
}
