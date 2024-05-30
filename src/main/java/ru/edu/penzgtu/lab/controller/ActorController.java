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
import ru.edu.penzgtu.lab.dto.ActorDto;
import ru.edu.penzgtu.lab.service.ActorService;
import java.util.List;
@Validated
@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
@Tag(name = "Актеры", description = "Операции над актерами")
public class ActorController {
    private final ActorService actorService;
    private final BaseResponseService baseResponseService;

    @Operation(
            summary = "Получение всех актеров", description = "позволяет выгрузить всех актеров из бд"
    )
    @GetMapping
    public List<ActorDto> findAll() {
        return baseResponseService.wrapSuccessResponse(actorService.findAllActors()).getBody();}

    @Operation(
            summary = "Получение актера по ID", description = "позволяет выгрузить актера по ID из бд"
    )
    @GetMapping("/actor/{id}")
    public ResponseWrapper<ActorDto> getById(@PathVariable @Min(0) Long id) {
        return baseResponseService.wrapSuccessResponse(actorService.findActorById(id));}

    @Operation(
            summary = "Создать актера", description = "позволяет объявить информацию об актере в бд"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createActor(@RequestBody ActorDto actor) {
        actorService.saveActor(actor);
    }

    @PutMapping("/actor/")
    public void updateActor(@RequestBody ActorDto actor) {
        actorService.updateActor(actor);
    }

    @Operation(
            summary = "Удалить актера по ID", description = "позволяет удалить актера по ID из бд"
    )
    @DeleteMapping("/actor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActor(@PathVariable @Min(0) Long id) {actorService.deleteActor(id);}
}