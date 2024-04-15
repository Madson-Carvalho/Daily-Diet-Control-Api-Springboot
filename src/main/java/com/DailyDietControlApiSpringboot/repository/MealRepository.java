package com.DailyDietControlApiSpringboot.repository;

import com.DailyDietControlApiSpringboot.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    @Query("SELECT m FROM Meal m WHERE m.id = ?1")
    Meal findByUuid(UUID uuid);

    @Query("SELECT COUNT(m) FROM Meal m WHERE m.isInDiet = true")
    long countByInDiet();

    @Query("SELECT COUNT(m) FROM Meal m WHERE m.isInDiet = false")
    long countByOutDiet();
}
