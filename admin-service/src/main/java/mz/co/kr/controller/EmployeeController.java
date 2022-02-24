package mz.co.kr.controller;

import mz.co.kr.admin.domain.dto.EmployeeDto;
import mz.co.kr.admin.ports.api.EmployeeServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServicePort employeeServicePort;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto add(@RequestBody EmployeeDto employeeDto) {
        return employeeServicePort.add(employeeDto);
    }

    @GetMapping()
    public List<EmployeeDto> getAll() {
        return employeeServicePort.fetchAll();
    }
}
