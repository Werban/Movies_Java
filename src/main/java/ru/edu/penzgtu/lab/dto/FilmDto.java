package ru.edu.penzgtu.lab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "Информация о фильме")
public class FilmDto {

    @JsonProperty("id")
    @Schema(description = "ID фильма в бд", example = "345")
    private Long id;

    @JsonProperty("name")
    @NotBlank
    @Schema(description = "Название фильма", example = "Интерстеллар")
    private String name;

    @JsonProperty("user")
    @Schema(description = "Имя пользователя который оценил фильм")
    private List<String> users;

    @JsonProperty("genre")
    @Schema(description = "Жанр фильма")
    private List<String> genre;

    @JsonProperty("rating")
    @Schema(description = "Рейтинг который был выставлен фильму")
    private List<String> rating;


}
