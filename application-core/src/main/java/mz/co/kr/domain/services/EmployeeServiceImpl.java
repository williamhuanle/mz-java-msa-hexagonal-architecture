package mz.co.kr.domain.services;

import mz.co.kr.domain.dto.EmployeeDto;
import mz.co.kr.ports.api.EmployeeServicePort;
import mz.co.kr.ports.spi.EmployeePersistencePort;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeServicePort {

    private EmployeePersistencePort employeePersistencePort;

    public EmployeeServiceImpl(EmployeePersistencePort employeePersistencePort) {
        this.employeePersistencePort = employeePersistencePort;
    }

    @Override
    public EmployeeDto add(EmployeeDto employeeDto) {
        return employeePersistencePort.add(employeeDto);
    }

    @Override
    public void deleteByEmployeeId(Long employeeId) {
        employeePersistencePort.deleteByEmployeeId(employeeId);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeePersistencePort.update(employeeDto);
    }

    @Override
    public EmployeeDto fetchByEmployeeId(Long employeeId) {
        return employeePersistencePort.fetchByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeDto> fetchAll() {
        return employeePersistencePort.fetchAll();
    }
}
