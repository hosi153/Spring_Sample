package com.example._sampleproject_coffee.coffee;

import com.example._sampleproject_coffee.coffee.DTO.CoffeePatchDto;
import com.example._sampleproject_coffee.coffee.DTO.CoffeePostDto;
import com.example._sampleproject_coffee.coffee.DTO.CoffeeResponseDto;
import com.example._sampleproject_coffee.mapper.CoffeeMapper;
import com.example._sampleproject_coffee.service.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v5/coffees")
@Validated
public class CoffeeController {

    private final CoffeeService coffeeService;
    private final CoffeeMapper coffeeMapper;


    public CoffeeController(CoffeeService coffeeService, CoffeeMapper coffeeMapper) {
        this.coffeeService = coffeeService;
        this.coffeeMapper = coffeeMapper;
    }


    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {
        //RequestParam -> CoffeePostDto 로 전환
        // 응답 객체 Map -> CoffeePostDto 전환

        Coffee response = coffeeService.createCoffee(coffeeMapper.coffeePostDtoToCoffee(coffeePostDto));


        return new ResponseEntity<>(coffeeMapper.coffeeToCoffeeResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                              @RequestBody CoffeePatchDto coffeePatchDto) {
        //양수만 허용해야 합니다
//        coffeePatchDto.setCoffeeId(coffeeId);
//        coffeePatchDto.setPrice(6000);


        Coffee response = coffeeService.updateCoffee(coffeeMapper.coffeePatchDtoToCoffee(coffeePatchDto));


        return new ResponseEntity<>(coffeeMapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.println("# coffeeId: " + coffeeId);

        // not implementation


        return new ResponseEntity<>(coffeeMapper.coffeeToCoffeeResponseDto(coffeeService.findCoffee(coffeeId)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# get Coffees");

        // not implementation

        // List<Member> members = memberSerivce.findMembers();
        //        // (7) 매퍼를 이용해서 List<Member>를 MemberResponseDto로 변환
        //        List<MemberResponseDto> response = members.stream().
        //                map(member -> memberMapper.memberToMemberResponseDto(member))
        //                .collect(Collectors.toList());


//        List<Coffee> coffees = coffeeService.findCoffees();
//        List<CoffeeResponseDto> response = coffees.stream().map(coffee -> coffeeMapper.coffeeToCoffeeResponseDto(coffee))
//                .collect(Collectors.toList());
//


        List<CoffeeResponseDto> response = coffeeMapper.coffeeToCoffeeResponseDtos(coffeeService.findCoffees());



        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        // No need business logic
        coffeeService.deleteCoffee(coffeeId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


//    private final Map<Long, Map<String, Object>> coffees = new HashMap<>();
//    //임시 DB
//

//
//    @GetMapping
//    public ResponseEntity getCoffees(){
//        return new ResponseEntity<>(coffees, HttpStatus.OK);
//    }
//
//    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//
//    // 1. 커피 정보 수정을 위한 핸들러 메서드 구현
//    /*
//    coffeeId에 해당하는 커피 정보가 Coffees에 존재하지 않는다면 404 NOT found HTTP Status 전송
//    coffeeId에 해당하는 커피 정보가 Map coffees에 존재한다면 커피 정보를 받아온 파라미터 값으로 수정한다.
//
//     */
//    @PatchMapping("/{coffee-id}")
//    public ResponseEntity pathCoffee(
//            @PathVariable("coffee-id") long coffeeId,
//            @RequestParam("korName") String korName,
//            @RequestParam ("price") int price
//    ){
//        Map<String ,Object> coffee = coffees.get(coffeeId);
//        if (coffee == null){
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//        else {
//            coffee.put("korName",korName);
//            coffee.put("price",price);
//        }
//        return new ResponseEntity(coffee, HttpStatus.OK);
//    }
//
//
//
//    // 2. 커피 정보 삭제를 위한 핸들러 서드 구현
//
//    /*
//    커피 정보가 map Coffees에 없다면 NOT FOUND status
//    커피 정보가 있다면 remove로 map에서 삭제하고 NO_CONTENT status(204)으로 return
//     */
//
//    @DeleteMapping("/{coffee-id}")
//    public ResponseEntity deleteCoffee(@PathVariable ("coffee-id") long coffeeId ){
//
//        if (coffees.containsKey(coffeeId)){
//            coffees.remove(coffeeId);
//        }else {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//        return  new ResponseEntity(HttpStatus.NO_CONTENT); //204 NO CONTENT
//    }


}
