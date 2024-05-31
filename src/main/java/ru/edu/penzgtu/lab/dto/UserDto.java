package ru.edu.penzgtu.lab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Schema(description = "Информация о пользователе")
public class UserDto {

    @JsonProperty("id")
    @Schema(description = "ID актера в бд", example = "345")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Имя пользователя", example = "Олег")
    private String name;

    @JsonProperty("surname")
    @NotBlank
    @Schema(description = "Фамилия пользователя", example = "Гончаров")
    private String surname;

    @JsonProperty("date")
    @NotBlank
    @Schema(description = "Дата регистрации", example = "30-01-2023")
    private LocalDate date;

    @JsonProperty("films")
    @Schema(description = "Фильмы которые смотрел")
    private List<String> films;

}
