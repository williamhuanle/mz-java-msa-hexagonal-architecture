package mz.co.kr.controller;

import mz.co.kr.domain.dto.EmployeeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public EmployeeDto greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new EmployeeDto(counter.incrementAndGet(), String.format(template, name), null, null, null, null, null);
	}
}