package ru.edu.penzgtu.lab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.penzgtu.lab.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
