package mz.co.kr.controller;

import mz.co.kr.domain.dto.EmployeeDto;
import mz.co.kr.ports.api.EmployeeServicePort;
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
    public EmployeeDto addBook(@RequestBody EmployeeDto employeeDto) {
        return employeeServicePort.add(employeeDto);
    }

    @GetMapping()
    public List<EmployeeDto> getAllBooks() {
        return employeeServicePort.fetchAll();
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long employeeId) {
        employeeServicePort.deleteByEmployeeId(employeeId);
    }
}
