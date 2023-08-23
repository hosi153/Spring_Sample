package com.example._sampleproject_coffee.service;

import com.example._sampleproject_coffee.coffee.Coffee;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CoffeeService {

    public Coffee createCoffee(Coffee coffee){
        Coffee createdCoffee = coffee;
        return createdCoffee;
    }

    public Coffee updateCoffee(Coffee coffee){
        Coffee updatedCoffee = coffee;
        return updatedCoffee;
    }

    public Coffee findCoffee(long coffeeId){
        Coffee coffee = new Coffee(coffeeId,"아메리카노","Americano",2500);
        return coffee;
    }

    public List<Coffee> findCoffees(){
        List<Coffee> coffees = new Array(List.of(
                new Coffee(1L,"아메리카노","Americane",2500),
                new Coffee(2L,"캐러멜라떼")
        ))
    }


}
