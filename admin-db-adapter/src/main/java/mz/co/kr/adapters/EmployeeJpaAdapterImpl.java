package mz.co.kr.adapters;

import mz.co.kr.admin.domain.dto.EmployeeDto;
import mz.co.kr.entity.Employee;
import mz.co.kr.admin.ports.spi.EmployeePersistencePort;
import mz.co.kr.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeJpaAdapterImpl implements EmployeePersistencePort {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto add(EmployeeDto employeeDto) {
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee saved = employeeRepository.save(employee);
        return modelMapper.map(saved, EmployeeDto.class);
    }

    @Override
    public void deleteByEmployeeId(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee saved = employeeRepository.save(employee);
        return modelMapper.map(saved, EmployeeDto.class);
    }

    @Override
    public EmployeeDto fetchByEmployeeId(Long employeeId) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
        return ObjectUtils.isEmpty(employeeOpt) ? null : modelMapper.map(employeeOpt.get(), EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> fetchAll() {
        List<Employee> employees = employeeRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return employees.stream().map( e -> modelMapper.map(e, EmployeeDto.class)).collect(Collectors.toList());
    }
}
