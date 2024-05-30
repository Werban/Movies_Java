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
@Schema(description = "Информация о рейтинге")
public class RatingDto {

    @JsonProperty("id")
    @Schema(description = "ID оценки в бд", example = "345")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Имя пользователя", example = "Олег")
    private String name;

    @JsonProperty("rating")
    @NotBlank
    @Schema(description = "Рейтинг", example = "8.7")
    private Integer rating;

    @JsonProperty("date")
    @NotBlank
    @Schema(description = "Дата")
    private LocalDate date;

    @JsonProperty("films")
    @Schema(description = "Название фильма к которому выставлен рейтинг")
    private List<String> films;

}
