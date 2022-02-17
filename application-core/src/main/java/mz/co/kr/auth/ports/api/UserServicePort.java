package mz.co.kr.auth.ports.api;

import mz.co.kr.auth.domain.dto.UserDto;

import java.util.Optional;

public interface UserServicePort {

    UserDto save(UserDto userDto);

    boolean existsByEmail(String email);

    Optional<UserDto> findById(Long id);

    Optional<UserDto> findByEmail(String email);
}
