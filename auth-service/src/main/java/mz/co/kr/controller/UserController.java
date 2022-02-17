package mz.co.kr.controller;

import mz.co.kr.domain.dto.UserDto;
import mz.co.kr.exception.ResourceNotFoundException;
import mz.co.kr.ports.api.UserServicePort;
import mz.co.kr.security.model.CurrentUser;
import mz.co.kr.security.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServicePort userServicePort;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public UserDto getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userServicePort.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Authenticated!";
    }
}
