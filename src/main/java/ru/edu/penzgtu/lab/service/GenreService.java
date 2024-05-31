package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.GenreDto;
import ru.edu.penzgtu.lab.entity.Genre;
import ru.edu.penzgtu.lab.exception.ErrorType;
import ru.edu.penzgtu.lab.exception.PenzGtuException;
import ru.edu.penzgtu.lab.repo.GenreRepository;
import ru.edu.penzgtu.lab.service.mapper.GenreMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;
    public List<GenreDto> findAllGenres() {

        return genreMapper.toListDto((genreRepository.findAll()));
    }

    @SneakyThrows
    public GenreDto findGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"Genre not found"));

        return genreMapper.toDto(genre);
    }

    public void saveGenre(GenreDto genreDto)
    {
        Genre genre = genreMapper.toEntity(genreDto);

        genreRepository.save(genre);
    }

    public void updateGenre(GenreDto newGenre) {
        Genre oldGenre = genreRepository.findById(newGenre.getId())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        oldGenre.setDescription(newGenre.getDescription());
        oldGenre.setName(newGenre.getName());
        oldGenre.setDate(newGenre.getDate());

        genreRepository.save(oldGenre);
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);}
}