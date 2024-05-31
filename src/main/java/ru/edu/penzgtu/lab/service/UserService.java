package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.UserDto;
import ru.edu.penzgtu.lab.entity.User;
import ru.edu.penzgtu.lab.exception.ErrorType;
import ru.edu.penzgtu.lab.exception.PenzGtuException;
import ru.edu.penzgtu.lab.repo.UserRepository;
import ru.edu.penzgtu.lab.service.mapper.UserMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public List<UserDto> findAllUsers() {

        return userMapper.toListDto(userRepository.findAll());
    }

    @SneakyThrows
    public UserDto findActorById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"User not found"));

        return userMapper.toDto(user);
    }

    public void saveUser(UserDto userDto)
    {
        User user = userMapper.toEntity(userDto);

        userRepository.save(user);
    }

    public void updateUser(UserDto newUser) {
        User oldUser = userRepository.findById(newUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        oldUser.setSurname(newUser.getSurname());
        oldUser.setName(newUser.getName());
        oldUser.setDate(newUser.getDate());

        userRepository.save(oldUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);}
}