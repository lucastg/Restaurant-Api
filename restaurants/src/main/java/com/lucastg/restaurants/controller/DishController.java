package com.lucastg.restaurants.controller;

import com.lucastg.restaurants.entity.Dish;
import com.lucastg.restaurants.entity.form.DishForm;
import com.lucastg.restaurants.entity.form.DishUpdateForm;
import com.lucastg.restaurants.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {
    @Autowired
    private IDishService service;

    @GetMapping
    public List<Dish> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Dish findOne(@PathVariable Long id){
        return service.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dish create(@Valid @RequestBody DishForm dishForm){
        return service.create(dishForm);
    }

    @PutMapping("/{id}")
    public Dish update(@Valid @RequestBody DishUpdateForm dishUpdateForm,@PathVariable Long id){
        return service.update(dishUpdateForm, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Successful delete";
    }

}