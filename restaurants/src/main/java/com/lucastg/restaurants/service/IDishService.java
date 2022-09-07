package com.lucastg.restaurants.service;
import com.lucastg.restaurants.entity.Dish;
import com.lucastg.restaurants.entity.form.DishForm;
import com.lucastg.restaurants.entity.form.DishUpdateForm;

import java.util.List;

public interface IDishService {
    List<Dish> findAll();
    Dish create(DishForm dishForm);
    void delete(Long Id);
    Dish update(DishUpdateForm dishUpdateForm, Long id);
    Dish findOne(Long id);
}


