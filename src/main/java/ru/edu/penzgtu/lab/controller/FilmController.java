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
import ru.edu.penzgtu.lab.dto.FilmDto;
import ru.edu.penzgtu.lab.entity.Film;
import ru.edu.penzgtu.lab.service.FilmService;
import java.util.List;
@Validated
@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
@Tag(name = "Фильмы", description = "Операции над фильмами")
public class FilmController {
    private final FilmService filmService;
    private final BaseResponseService baseResponseService;
    @Operation(
            summary = "Получение всех фильмов", description = "позволяет выгрузить все фильмы из бд"
    )
    @GetMapping
    public List<FilmDto> findAll() {

        return baseResponseService.wrapSuccessResponse(filmService.findAllfilms()).getBody();
    }

    @Operation(
            summary = "Получение фильма по ID", description = "позволяет выгрузить фильм по ID из бд"
    )
    @GetMapping("/film/{id}")
    public ResponseWrapper<FilmDto> getById(@PathVariable @Min(0) Long id) {

        return baseResponseService.wrapSuccessResponse(filmService.findFilmById(id));
    }

    @Operation(
            summary = "Создать фильм", description = "позволяет объявить информацию об фильме в бд"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFilm(@RequestBody FilmDto film) {
        filmService.saveFilm(film);
    }

    @PutMapping("/film/")
    public void updateFilm(@RequestBody FilmDto film) {
        filmService.updateFilm(film);
    }
   
    @Operation(
            summary = "Удалить фильм по ID", description = "позволяет удалить фильм по ID из бд"
    )
    @DeleteMapping("/film/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFilm(@PathVariable @Min(0) Long id) {
        filmService.deleteFilmById(id);
    }
}