package mz.co.kr.adapters;

import mz.co.kr.admin.domain.dto.EmployeeDto;
import mz.co.kr.admin.ports.spi.EmployeePersistencePort;
import mz.co.kr.entity.Employee;
import mz.co.kr.repository.EmployeeMongoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeMongoDbAdapterImpl implements EmployeePersistencePort {

    @Autowired
    private EmployeeMongoRepository employeeMongoRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public EmployeeDto add(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee saved = employeeMongoRepository.save(employee);
        return modelMapper.map(saved, EmployeeDto.class);
    }

    @Override
    public void deleteByEmployeeId(Long employeeId) {

    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto fetchByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public List<EmployeeDto> fetchAll() {
        List<Employee> employees = employeeMongoRepository.findAll();
        return employees.stream().map( e -> modelMapper.map(e, EmployeeDto.class)).collect(Collectors.toList());
    }
}
