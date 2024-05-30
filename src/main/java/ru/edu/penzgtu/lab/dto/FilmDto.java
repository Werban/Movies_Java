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

    @JsonProperty("actors")
    @Schema(description = "Названия фильмов в которых снимался актер")
    private List<String> actors;

    @JsonProperty("director")
    @Schema(description = "Названия фильмов в которых он был режисером")
    private List<String> director;

    @JsonProperty("rating")
    @Schema(description = "Рейтинг который был выставлен фильму")
    private List<String> rating;


}
