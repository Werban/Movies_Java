package ru.edu.penzgtu.lab.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.FilmDto;
import ru.edu.penzgtu.lab.entity.User;
import ru.edu.penzgtu.lab.entity.Genre;
import ru.edu.penzgtu.lab.entity.Film;
import ru.edu.penzgtu.lab.entity.Rating;

import java.util.List;

@Service
public class FilmMapper {
    public List<FilmDto> toListDto(List<Film> films){
        return films.stream().map(this::toDto).toList();
    }

    public FilmDto toDto(Film film){
        return FilmDto.builder()
                .id(film.getId())
                .name(film.getName())
                .users(film.getUsers().stream()
                        .map(User::getName)
                        .toList())
                .director(film.getGenres().stream()
                        .map(Genre::getName)
                        .toList())
                .rating(film.getRatings().stream()
                        .map(Rating::getName)
                        .toList())
                .build();

    }

    public Film toEntity(FilmDto filmDto){
        Film film = new Film();

        film.setId(film.getId());
        film.setName(filmDto.getName());

        return film;
    }
}
