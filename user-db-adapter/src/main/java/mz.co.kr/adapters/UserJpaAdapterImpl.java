package mz.co.kr.adapters;

import mz.co.kr.auth.domain.dto.UserDto;
import mz.co.kr.entity.User;
import mz.co.kr.auth.ports.spi.UserPersistencePort;
import mz.co.kr.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class UserJpaAdapterImpl implements UserPersistencePort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        User saved = userRepository.save(user);
        return modelMapper.map(saved, UserDto.class);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<User> userOpt = userRepository.findById(id);
        return ObjectUtils.isEmpty(userOpt) ? Optional.empty() : Optional.of(modelMapper.map(userOpt.get(), UserDto.class));
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<User> userOpt = userRepository.findByEmail(email);
        return ObjectUtils.isEmpty(userOpt) ? Optional.empty() : Optional.of(modelMapper.map(userOpt.get(), UserDto.class));
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
