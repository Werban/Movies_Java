package ru.edu.penzgtu.lab.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.GenreDto;
import ru.edu.penzgtu.lab.entity.Genre;
import ru.edu.penzgtu.lab.entity.Film;

import java.util.List;

@Service
public class GenreMapper {

    public List<GenreDto> toListDto(List<Genre> genres){
        return genres.stream().map(this::toDto).toList();
    }

    public GenreDto toDto(Genre genre){
        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .description(genre.getDescription())
                .date(genre.getDate())
                .films(genre.getFilms().stream()
                        .map(Film::getName)
                        .toList())
                .build();

    }
    public Genre toEntity(GenreDto genreDto){
        Genre genre = new Genre();

        genre.setId(genre.getId());
        genre.setName(genreDto.getName());
        genre.setDescription(genreDto.getDescription());
        genre.setDate(genreDto.getDate());
        return genre;
    }
}
