package ru.edu.penzgtu.lab.service.mapper;

import org.springframework.stereotype.Service;
import ru.edu.penzgtu.lab.dto.RatingDto;
import ru.edu.penzgtu.lab.entity.Rating;
import ru.edu.penzgtu.lab.entity.Film;
import java.util.List;

@Service
public class RatingMapper {

    public List<RatingDto> toListDto(List<Rating> ratings){
        return ratings.stream().map(this::toDto).toList();
    }

    public RatingDto toDto(Rating rating){
        return RatingDto.builder()
                .id(rating.getId())
                .name(rating.getName())
                .rating( rating.getRating())
                .date(rating.getDate())
                .films(rating.getFilms().stream()
                        .map(Film::getName)
                        .toList())
                .build();

    }
    public Rating toEntity(RatingDto ratingDto){
        Rating rating = new Rating();

        rating.setId(rating.getId());
        rating.setName(ratingDto.getName());
        rating.setRating(ratingDto.getRating());
        rating.setDate(ratingDto.getDate());
        return rating;
    }
}
