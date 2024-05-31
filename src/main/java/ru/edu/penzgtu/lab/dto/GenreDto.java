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
@Schema(description = "Информация о жанре")
public class GenreDto {

    @JsonProperty("id")
    @Schema(description = "ID жанра в бд", example = "345")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Название жанра", example = "Ужасы")
    private String name;

    @JsonProperty("description")
    @NotBlank
    @Schema(description = "Описание жанра", example = "Будет страшно")
    private String description;

    @JsonProperty("date")
    @NotBlank
    @Schema(description = "Дата обновления информации", example = "1970-06-30")
    private LocalDate date;

    @JsonProperty("films")
    @Schema(description = "Названия фильмов в данном жанре")
    private List<String> films;

}
