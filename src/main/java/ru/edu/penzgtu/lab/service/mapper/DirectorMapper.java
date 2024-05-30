package ru.edu.penzgtu.lab.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.DirectorDto;
import ru.edu.penzgtu.lab.entity.Director;
import ru.edu.penzgtu.lab.entity.Film;

import java.util.List;

@Service
public class DirectorMapper {

    public List<DirectorDto> toListDto(List<Director> directors){
        return directors.stream().map(this::toDto).toList();
    }

    public DirectorDto toDto(Director director){
        return DirectorDto.builder()
                .id(director.getId())
                .name(director.getName())
                .surname(director.getSurname())
                .date(director.getDate())
                .films(director.getFilms().stream()
                        .map(Film::getName)
                        .toList())
                .build();

    }
    public Director toEntity(DirectorDto directorDto){
        Director director = new Director();

        director.setId(director.getId());
        director.setName(directorDto.getName());
        director.setSurname(directorDto.getSurname());
        director.setDate(directorDto.getDate());
        return director;
    }
}
