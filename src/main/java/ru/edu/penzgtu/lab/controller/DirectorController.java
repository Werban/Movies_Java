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
import ru.edu.penzgtu.lab.dto.DirectorDto;
import ru.edu.penzgtu.lab.service.DirectorService;
import java.util.List;
@Validated
@RestController
@RequestMapping("/directors")
@RequiredArgsConstructor
@Tag(name = "Режиссеры", description = "Операции над режиссерами")
public class DirectorController {
    private final DirectorService directorService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех режиссеров", description = "позволяет выгрузить всех режиссеров из бд"
    )
    @GetMapping
    public List<DirectorDto> findAll() {
        return baseResponseService.wrapSuccessResponse(directorService.findAllDirectors()).getBody();}

    @Operation(
            summary = "Получение режиссера по ID", description = "позволяет выгрузить режиссера по ID из бд"
    )
    @GetMapping("/director/{id}")
    public ResponseWrapper<DirectorDto> getById(@PathVariable @Min(0) Long id) {
        return baseResponseService.wrapSuccessResponse(directorService.findDirectorById(id));}

    @Operation(
            summary = "Создать режиссера", description = "позволяет объявить информацию об режиссере в бд"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDirector(@RequestBody DirectorDto director) {
        directorService.saveDirector(director);
    }

    @PutMapping("/director/")
    public void updateDirector(@RequestBody DirectorDto director) {
        directorService.updateDirector(director);
    }

    @Operation(
            summary = "Удалить режисера по ID", description = "позволяет удалить режиссера по ID из бд"
    )
    @DeleteMapping("/director/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDirector(@PathVariable @Min(0) Long id) {directorService.deleteDirector(id);}
}