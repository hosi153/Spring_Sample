package com.example._sampleproject_coffee.coffee.mapper;

import com.example._sampleproject_coffee.coffee.entity.Coffee;
import com.example._sampleproject_coffee.coffee.DTO.CoffeePatchDto;
import com.example._sampleproject_coffee.coffee.DTO.CoffeePostDto;
import com.example._sampleproject_coffee.coffee.DTO.CoffeeResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {

    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);
}
