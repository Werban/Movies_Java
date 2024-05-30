package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.DirectorDto;
import ru.edu.penzgtu.lab.entity.Director;
import ru.edu.penzgtu.lab.exception.ErrorType;
import ru.edu.penzgtu.lab.exception.PenzGtuException;
import ru.edu.penzgtu.lab.repo.DirectorRepository;
import ru.edu.penzgtu.lab.service.mapper.DirectorMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;
    public List<DirectorDto> findAllDirectors() {

        return directorMapper.toListDto((directorRepository.findAll()));
    }

    @SneakyThrows
    public DirectorDto findDirectorById(Long id) {
        Director director= directorRepository.findById(id).orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"CPU not found"));

        return directorMapper.toDto(director);
    }

    public void saveDirector(DirectorDto directorDto)
    {
        Director director = directorMapper.toEntity(directorDto);

        directorRepository.save(director);
    }

    public void updateDirector(DirectorDto newDirector) {
        Director oldDirector = directorRepository.findById(newDirector.getId())
                .orElseThrow(() -> new RuntimeException("Director not found"));

        oldDirector.setSurname(newDirector.getSurname());
        oldDirector.setName(newDirector.getName());
        oldDirector.setDate(newDirector.getDate());

        directorRepository.save(oldDirector);
    }

    public void deleteDirector(Long id) {directorRepository.deleteById(id);}
}