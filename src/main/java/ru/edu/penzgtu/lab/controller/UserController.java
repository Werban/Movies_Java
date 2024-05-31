package ru.edu.penzgtu.lab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.edu.penzgtu.lab.baseresponse.BaseResponseService;
import ru.edu.penzgtu.lab.baseresponse.ResponseWrapper;
import ru.edu.penzgtu.lab.dto.UserDto;
import ru.edu.penzgtu.lab.service.UserService;
import java.util.List;
@Validated
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Пользователи", description = "Операции над пользователями")
public class UserController {
    private final UserService userService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех пользователей", description = "позволяет выгрузить всех пользователей из бд"
    )
    @GetMapping
    public List<UserDto> findAll() {
        return baseResponseService.wrapSuccessResponse(userService.findAllUsers()).getBody();}

    @Operation(
            summary = "Получение пользователя по ID", description = "позволяет выгрузить пользователя по ID из бд"
    )
    @GetMapping("/user/{id}")
    public ResponseWrapper<UserDto> getById(@PathVariable @Min(0) Long id) {
        return baseResponseService.wrapSuccessResponse(userService.findActorById(id));}

    @Operation(
            summary = "Создать пользователя", description = "позволяет объявить информацию об пользователе в бд"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto user) {
        userService.saveUser(user);
    }

    @PutMapping("/user/")
    public void updateUser(@RequestBody UserDto user) {
        userService.updateUser(user);
    }

    @Operation(
            summary = "Удалить пользователя по ID", description = "позволяет удалить пользователя по ID из бд"
    )
    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable @Min(0) Long id) {
        userService.deleteUser(id);}
}