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
import ru.edu.penzgtu.lab.dto.GenreDto;
import ru.edu.penzgtu.lab.service.GenreService;
import java.util.List;
@Validated
@RestController
@RequestMapping("/geners")
@RequiredArgsConstructor
@Tag(name = "Жанры", description = "Операции над жанрами")
public class GenreController {
    private final GenreService genreService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех жанров", description = "позволяет выгрузить все жанры из бд"
    )
    @GetMapping
    public List<GenreDto> findAll() {
        return baseResponseService.wrapSuccessResponse(genreService.findAllGenres()).getBody();}

    @Operation(
            summary = "Получение жанра по ID", description = "позволяет выгрузить жанр по ID из бд"
    )
    @GetMapping("/geners/{id}")
    public ResponseWrapper<GenreDto> getById(@PathVariable @Min(0) Long id) {
        return baseResponseService.wrapSuccessResponse(genreService.findGenreById(id));}

    @Operation(
            summary = "Создать жанр", description = "позволяет объявить информацию о жанре в бд"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGenre(@RequestBody GenreDto genre) {
        genreService.saveGenre(genre);
    }

    @PutMapping("/geners/")
    public void updateGenre(@RequestBody GenreDto genre) {
        genreService.updateGenre(genre);
    }

    @Operation(
            summary = "Удалить жанр по ID", description = "позволяет удалить жанр по ID из бд"
    )
    @DeleteMapping("/geners/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGenre(@PathVariable @Min(0) Long id) {
        genreService.deleteGenre(id);}
}