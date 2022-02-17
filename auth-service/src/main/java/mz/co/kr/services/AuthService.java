package mz.co.kr.services;

import mz.co.kr.domain.dto.UserDto;
import mz.co.kr.domain.enums.OAuth2Provider;
import mz.co.kr.exception.BadRequestException;
import mz.co.kr.payload.SignUpRequest;
import mz.co.kr.ports.api.UserServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserServicePort userServicePort;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto createUser(SignUpRequest signUpRequest) {
        if(userServicePort.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }
        UserDto user = new UserDto();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider(OAuth2Provider.local);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userServicePort.save(user);
    }
}
