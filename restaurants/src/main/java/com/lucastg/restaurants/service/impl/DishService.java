package com.lucastg.restaurants.service.impl;

import com.lucastg.restaurants.entity.Dish;
import com.lucastg.restaurants.entity.form.DishForm;
import com.lucastg.restaurants.entity.form.DishUpdateForm;
import com.lucastg.restaurants.repository.DishRepository;
import com.lucastg.restaurants.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService implements IDishService {

    @Autowired
    private DishRepository repository;

    @Override
    public List<Dish> findAll() {
        return repository.findAll();
    }

    @Override
    public Dish findOne(Long id) {
        Optional<Dish> dish = repository.findById(id);
        if(dish.isPresent()){
            return dish.get();
        }
        return null;
    }

    @Override
    public Dish create(DishForm dishForm) {
        Dish dish = new Dish();
        dish.setDescription(dishForm.getDescription());
        dish.setPrice(dishForm.getPrice());
        dish.setName(dishForm.getName());
        return repository.save(dish);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Dish update(DishUpdateForm dishUpdateForm, Long id) {
        Optional<Dish> dish = repository.findById(id);
        if(dish.isPresent()){
            dish.get().setName(dishUpdateForm.getName());
            dish.get().setPrice(dishUpdateForm.getPrice());
            dish.get().setDescription(dishUpdateForm.getDescription());
            return repository.save(dish.get());
        }
        return null;
    }
}
