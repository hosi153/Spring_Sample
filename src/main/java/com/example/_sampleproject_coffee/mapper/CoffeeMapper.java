package com.example._sampleproject_coffee.mapper;

import com.example._sampleproject_coffee.coffee.Coffee;
import com.example._sampleproject_coffee.coffee.DTO.CoffeePatchDto;
import com.example._sampleproject_coffee.coffee.DTO.CoffeePostDto;
import com.example._sampleproject_coffee.coffee.DTO.CoffeeResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {

    Coffee coffeePostDtoToCoffee (CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee (CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto (Coffee coffee);
}