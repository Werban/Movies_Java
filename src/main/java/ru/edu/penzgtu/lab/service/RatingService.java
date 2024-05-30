package ru.edu.penzgtu.lab.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.RatingDto;
import ru.edu.penzgtu.lab.entity.Rating;
import ru.edu.penzgtu.lab.exception.ErrorType;
import ru.edu.penzgtu.lab.exception.PenzGtuException;
import ru.edu.penzgtu.lab.repo.RatingRepository;
import ru.edu.penzgtu.lab.service.mapper.RatingMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;
    public List<RatingDto> findAllRating() {

        return ratingMapper.toListDto(ratingRepository.findAll());
    }

    @SneakyThrows
    public RatingDto findRatingById(Long id) {
        Rating rating= ratingRepository.findById(id).orElseThrow(() -> new PenzGtuException(ErrorType.NOT_FOUND,"CPU not found"));

        return ratingMapper.toDto(rating);
    }

    public void saveRating(RatingDto ratingDto)
    {
        Rating rating = ratingMapper.toEntity(ratingDto);

        ratingRepository.save(rating);
    }

    public void updateRating(RatingDto newRating) {
        Rating oldRating = ratingRepository.findById(newRating.getId())
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        oldRating.setRating(Integer.parseInt(newRating.getRating()));
        oldRating.setName(newRating.getName());
        oldRating.setDate(newRating.getDate());

        ratingRepository.save(oldRating);
    }

    public void deleteRating(Long id) {ratingRepository.deleteById(id);}
}