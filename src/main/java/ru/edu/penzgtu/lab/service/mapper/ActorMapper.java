package ru.edu.penzgtu.lab.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.ActorDto;
import ru.edu.penzgtu.lab.entity.Actor;
import ru.edu.penzgtu.lab.entity.Film;

import java.util.List;

@Service
public class ActorMapper {

    public List<ActorDto> toListDto(List<Actor> actors){
        return actors.stream().map(this::toDto).toList();
    }

    public ActorDto toDto(Actor actor){
        return ActorDto.builder()
                .id(actor.getId())
                .name(actor.getName())
                .surname(actor.getSurname())
                .date(actor.getDate())
                .films(actor.getFilms().stream()
                .map(Film::getName)
                        .toList())
                .build();

    }
    public Actor toEntity(ActorDto actorDto){
        Actor actor = new Actor();

        actor.setId(actor.getId());
        actor.setName(actorDto.getName());
        actor.setSurname(actorDto.getSurname());
        actor.setDate(actorDto.getDate());

        return actor;
    }
}
