package com.DailyDietControlApiSpringboot.service;

import com.DailyDietControlApiSpringboot.model.Meal;
import com.DailyDietControlApiSpringboot.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public Meal createMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public Meal editMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public void deleteMeal(UUID mealId) {
        Meal mealToDelete = mealRepository.findByUuid(mealId);

        mealRepository.delete(mealToDelete);
    }

    public List<Meal> findAllMeals() {
        return mealRepository.findAll();
    }

    public Meal findMealById(UUID mealId) {
        return mealRepository.findByUuid(mealId);
    }

    public long countMeals() {
        return mealRepository.count();
    }

    public long countMealsInDiet() {
        return mealRepository.countByInDiet();
    }

    public long countMealsOutDiet() {
        return mealRepository.countByOutDiet();
    }

    public long findLongestDietMealsSequence() {
        ArrayList<Meal> meals = (ArrayList<Meal>) mealRepository.findAll();
        long maxSequence = 0;
        long currentSequence = 0;

        for (Meal meal : meals) {
            if (meal.isInDiet()) {
                currentSequence++;
                maxSequence = Math.max(maxSequence, currentSequence);
            } else {
                currentSequence = 0;
            }
        }
        return maxSequence;
    }
}
