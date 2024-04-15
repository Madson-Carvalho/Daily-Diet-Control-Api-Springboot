package com.DailyDietControlApiSpringboot.controller;

import com.DailyDietControlApiSpringboot.model.Meal;
import com.DailyDietControlApiSpringboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/meals")
public class MealController {
    @Autowired
    private MealService mealService;

    @PostMapping("/create-meal")
    public ResponseEntity<Meal> createMeal(@RequestBody Meal meal) {
        return ResponseEntity.ok(mealService.createMeal(meal));
    }

    @PutMapping("/edit-meal")
    public ResponseEntity<Meal> editMeal(@RequestBody Meal meal) {
        return ResponseEntity.ok(mealService.editMeal(meal));
    }

    @DeleteMapping("/remove-meal/{id}")
    public void deleteMeal(@PathVariable UUID id) {
        mealService.deleteMeal(id);
    }

    @GetMapping("/find-meals")
    public List<Meal> findAllMeals() {
        return mealService.findAllMeals();
    }

    @GetMapping("/find-meal/{id}")
    public Meal findMealById(@PathVariable UUID id) {
        return mealService.findMealById(id);
    }

    @GetMapping("/count-meals")
    public Long countMeals() {
        return mealService.countMeals();
    }

    @GetMapping("/count-diet-meals")
    public Long countDietMeals() {
        return mealService.countMealsInDiet();
    }

    @GetMapping("/count-no-diet-meals")
    public Long countNoDietMeals() {
        return mealService.countMealsOutDiet();
    }

    @GetMapping("/find-longest-diet-meals-sequence")
    public Long findLongestDietMealsSequence() {
        return mealService.findLongestDietMealsSequence();
    }
}
