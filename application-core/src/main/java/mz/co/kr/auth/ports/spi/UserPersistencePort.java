package mz.co.kr.auth.ports.spi;

import mz.co.kr.auth.domain.dto.UserDto;

import java.util.Optional;

public interface UserPersistencePort {

    UserDto save(UserDto userDto);

    Optional<UserDto> findById(Long id);

    Optional<UserDto> findByEmail(String email);

    Boolean existsByEmail(String email);
}
