package ru.edu.penzgtu.lab.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.UserDto;
import ru.edu.penzgtu.lab.entity.User;
import ru.edu.penzgtu.lab.entity.Film;

import java.util.List;

@Service
public class UserMapper {

    public List<UserDto> toListDto(List<User> users){
        return users.stream().map(this::toDto).toList();
    }

    public UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .date(user.getDate())
                .films(user.getFilms().stream()
                .map(Film::getName)
                        .toList())
                .build();

    }
    public User toEntity(UserDto userDto){
        User user = new User();

        user.setId(user.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setDate(userDto.getDate());

        return user;
    }
}
