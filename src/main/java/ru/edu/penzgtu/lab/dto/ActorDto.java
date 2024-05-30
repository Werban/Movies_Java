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
@Schema(description = "Информация о актере")
public class ActorDto {

    @JsonProperty("id")
    @Schema(description = "ID актера в бд", example = "345")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Имя актера", example = "Кристиан")
    private String name;

    @JsonProperty("surname")
    @NotBlank
    @Schema(description = "Фамилия актера", example = "Бейл")
    private String surname;

    @JsonProperty("date")
    @NotBlank
    @Schema(description = "Год рождения", example = "30-01-1974")
    private LocalDate date;

    @JsonProperty("films")
    @Schema(description = "Названия фильмов в которых снимался актер")
    private List<String> films;

}
