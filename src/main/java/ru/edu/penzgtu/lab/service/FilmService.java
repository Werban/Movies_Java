package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.FilmDto;
import ru.edu.penzgtu.lab.entity.Film;
import ru.edu.penzgtu.lab.exception.ErrorType;
import ru.edu.penzgtu.lab.exception.PenzGtuException;
import ru.edu.penzgtu.lab.repo.FilmRepository;
import ru.edu.penzgtu.lab.service.mapper.FilmMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;
    public List<FilmDto> findAllfilms() {

        return filmMapper.toListDto(filmRepository.findAll());
    }

    @SneakyThrows
    public FilmDto findFilmById(Long id) {
        Film film= filmRepository.findById(id).orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"film not found"));

       return filmMapper.toDto(film);
    }

    public void saveFilm(FilmDto filmDto) {
        Film film = filmMapper.toEntity(filmDto);

        filmRepository.save(film);
    }

    public void updateFilm(FilmDto newFilm) {
        Film oldFilm = filmRepository.findById(newFilm.getId())
                .orElseThrow(() -> new RuntimeException("Film not found"));
        oldFilm.setName(newFilm.getName());
        filmRepository.save(oldFilm);
    }

    public void deleteFilmById(Long id) {
        filmRepository.deleteById(id);
    }
}