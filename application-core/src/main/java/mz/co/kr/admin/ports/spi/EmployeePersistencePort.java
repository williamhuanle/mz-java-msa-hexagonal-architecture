package mz.co.kr.admin.ports.spi;


import mz.co.kr.admin.domain.dto.EmployeeDto;

import java.util.List;

public interface EmployeePersistencePort {

    EmployeeDto add(EmployeeDto employeeDto);

    void deleteByEmployeeId(Long employeeId);

    EmployeeDto update(EmployeeDto employeeDto);

    EmployeeDto fetchByEmployeeId(Long employeeId);

    List<EmployeeDto> fetchAll();
}
