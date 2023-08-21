package com.example._sampleproject_coffee.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {
    private final Map<Long, Map<String, Object>> coffees = new HashMap<>();
    //임시 DB

    @PostConstruct
    public void init() {
        Map<String, Object> coffee1 = new HashMap<>();
        long coffeeId = 1L;
        coffee1.put("coffeeId", coffeeId);
        coffee1.put("korName", "바닐라 라떼");
        coffee1.put("engName", "Vanilla Latte");
        coffee1.put("price", 4500);

        coffees.put(coffeeId, coffee1);
    }

    @GetMapping
    public ResponseEntity getCoffees(){
        return new ResponseEntity<>(coffees, HttpStatus.OK);
    }

    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//
    // 1. 커피 정보 수정을 위한 핸들러 메서드 구현
    /*
    coffeeId에 해당하는 커피 정보가 Coffees에 존재하지 않는다면 404 NOT found HTTP Status 전송
    coffeeId에 해당하는 커피 정보가 Map coffees에 존재한다면 커피 정보를 받아온 파라미터 값으로 수정한다.

     */
    @PatchMapping("/{coffee-id}")
    public ResponseEntity pathCoffee(
            @PathVariable("coffee-id") long coffeeId,
            @RequestParam("korName") String korName,
            @RequestParam ("price") int price
    ){
        Map<String ,Object> coffee = coffees.get(coffeeId);
        if (coffee == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            coffee.put("korName",korName);
            coffee.put("price",price);
        }
        return new ResponseEntity(coffee, HttpStatus.OK);
    }



    // 2. 커피 정보 삭제를 위한 핸들러 서드 구현

    /*
    커피 정보가 map Coffees에 없다면 NOT FOUND status
    커피 정보가 있다면 remove로 map에서 삭제하고 NO_CONTENT status(204)으로 return
     */

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable ("coffee-id") long coffeeId ){

        if (coffees.containsKey(coffeeId)){
            coffees.remove(coffeeId);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(HttpStatus.NO_CONTENT); //204 NO CONTENT
    }


}
