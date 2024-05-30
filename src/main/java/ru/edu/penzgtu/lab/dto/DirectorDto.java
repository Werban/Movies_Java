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
@Schema(description = "Информация о режисере")
public class DirectorDto {

    @JsonProperty("id")
    @Schema(description = "ID режисера в бд", example = "345")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Имя режисера", example = "Кристофер")
    private String name;

    @JsonProperty("surname")
    @NotBlank
    @Schema(description = "Фамилия режисера", example = "Нолан")
    private String surname;

    @JsonProperty("date")
    @NotBlank
    @Schema(description = "Год рождения", example = "1970-06-30")
    private LocalDate date;

    @JsonProperty("films")
    @Schema(description = "Названия фильмов в которые снимал режисер")
    private List<String> films;

}
