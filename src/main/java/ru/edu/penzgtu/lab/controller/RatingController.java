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
import ru.edu.penzgtu.lab.dto.RatingDto;
import ru.edu.penzgtu.lab.service.RatingService;

import java.util.List;
@Validated
@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
@Tag(name = "Рейтинг", description = "Операции над рейтингом")
public class RatingController {
    private final RatingService ratingService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех рейтингов", description = "позволяет выгрузить все оценки из бд"
    )
    @GetMapping
    public List<RatingDto> findAll() {
        return baseResponseService.wrapSuccessResponse(ratingService.findAllRating()).getBody();}

    @Operation(
            summary = "Получение рейтинга по ID", description = "позволяет выгрузить рейтинг по ID из бд"
    )
    @GetMapping("/rating/{id}")
    public ResponseWrapper<RatingDto> getById(@PathVariable @Min(0) Long id) {
        return baseResponseService.wrapSuccessResponse(ratingService.findRatingById(id));}

    @Operation(
            summary = "Создать рейтинг", description = "позволяет объявить информацию об рейтинге в бд"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRating(@RequestBody RatingDto rating) {
        ratingService.saveRating(rating);
    }

    @PutMapping("/rating/")
    public void updateRating(@RequestBody RatingDto rating) {
        ratingService.updateRating(rating);
    }

    @Operation(
            summary = "Удалить рейтинг по ID", description = "позволяет удалить рейтинг по ID из бд"
    )
    @DeleteMapping("/rating/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRating(@PathVariable @Min(0) Long id) {ratingService.deleteRating(id);}
}