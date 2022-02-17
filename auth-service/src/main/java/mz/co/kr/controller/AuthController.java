package mz.co.kr.controller;

import mz.co.kr.domain.dto.UserDto;
import mz.co.kr.payload.ApiResponse;
import mz.co.kr.payload.AuthResponse;
import mz.co.kr.payload.SignInRequest;
import mz.co.kr.payload.SignUpRequest;
import mz.co.kr.security.jwt.TokenProvider;
import mz.co.kr.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse authenticateUser(@Valid @RequestBody SignInRequest signInRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getEmail(),
                        signInRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return new AuthResponse(token, "Bearer");
    }

    @PostMapping("/signup")
    public ApiResponse registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        UserDto userDto = authService.createUser(signUpRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(userDto.getId()).toUri();

        return new ApiResponse(true, "User registered successfully!");
    }

}
