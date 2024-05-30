package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.ActorDto;
import ru.edu.penzgtu.lab.entity.Actor;
import ru.edu.penzgtu.lab.entity.Actor;
import ru.edu.penzgtu.lab.exception.ErrorType;
import ru.edu.penzgtu.lab.exception.PenzGtuException;
import ru.edu.penzgtu.lab.repo.ActorRepository;
import ru.edu.penzgtu.lab.service.mapper.ActorMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;
    public List<ActorDto> findAllActors() {

        return actorMapper.toListDto(actorRepository.findAll());
    }

    @SneakyThrows
    public ActorDto findActorById(Long id) {
        Actor actor= actorRepository.findById(id).orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"CPU not found"));

        return actorMapper.toDto(actor);
    }

    public void saveActor(ActorDto actorDto)
    {
        Actor actor = actorMapper.toEntity(actorDto);

        actorRepository.save(actor);
    }

    public void updateActor(ActorDto newActor) {
        Actor oldActor = actorRepository.findById(newActor.getId())
                .orElseThrow(() -> new RuntimeException("Actor not found"));

        oldActor.setSurname(newActor.getSurname());
        oldActor.setName(newActor.getName());
        oldActor.setDate(newActor.getDate());

        actorRepository.save(oldActor);
    }

    public void deleteActor(Long id) {actorRepository.deleteById(id);}
}