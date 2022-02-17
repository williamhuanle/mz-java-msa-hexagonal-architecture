package mz.co.kr.domain.services;

import mz.co.kr.domain.dto.UserDto;
import mz.co.kr.ports.api.UserServicePort;
import mz.co.kr.ports.spi.UserPersistencePort;

import java.util.Optional;

public class UserServiceImpl implements UserServicePort {

    private UserPersistencePort userPersistencePort;

    public UserServiceImpl(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public UserDto save(UserDto user) {
        return userPersistencePort.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userPersistencePort.existsByEmail(email);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userPersistencePort.findById(id);
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return userPersistencePort.findByEmail(email);
    }
}
