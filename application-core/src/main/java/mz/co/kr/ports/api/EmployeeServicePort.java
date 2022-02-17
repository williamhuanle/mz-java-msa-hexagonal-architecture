package mz.co.kr.ports.api;

import mz.co.kr.domain.dto.EmployeeDto;

import java.util.List;

public interface EmployeeServicePort {

    EmployeeDto add(EmployeeDto employeeDto);

    void deleteByEmployeeId(Long employeeId);

    EmployeeDto update(EmployeeDto employeeDto);

    EmployeeDto fetchByEmployeeId(Long employeeId);

    List<EmployeeDto> fetchAll();
}
