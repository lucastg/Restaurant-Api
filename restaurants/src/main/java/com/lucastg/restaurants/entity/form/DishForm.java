package com.lucastg.restaurants.entity.form;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DishForm {
    @NotBlank(message = "Missing name")
    @Size(min = 5, max = 45)
    private String name;

    @NotNull
    @PositiveOrZero
    private Float price;

    @NotBlank(message = "Missing name")
    @Size(min = 5, max = 45)
    private String description;
}
