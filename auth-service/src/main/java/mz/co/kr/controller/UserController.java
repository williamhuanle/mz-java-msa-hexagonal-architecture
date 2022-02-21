package mz.co.kr.controller;

import mz.co.kr.auth.domain.dto.UserDto;
import mz.co.kr.exception.ResourceNotFoundException;
import mz.co.kr.auth.ports.api.UserServicePort;
import mz.co.kr.controller.payload.response.GetUserResponse;
import mz.co.kr.security.model.CurrentUser;
import mz.co.kr.security.model.UserPrincipal;
import org.modelmapper.ModelMapper;
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
    public GetUserResponse getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        UserDto userDto = userServicePort.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        ModelMapper mapper = new ModelMapper();
        return mapper.map(userDto, GetUserResponse.class);
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Authenticated!";
    }
}
