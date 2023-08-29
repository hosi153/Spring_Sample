package com.example._sampleproject_coffee.coffee.entity;

import com.example._sampleproject_coffee.OrderCoffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "COFFEE")
public class Coffee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coffeeId;

    @Column(length = 100 , nullable = false)
    private String korName;

    @Column(length = 100,nullable = false)
    private String engName;

    @Column(nullable = false)
    private Integer price;

    @Column(length = 3,nullable = false,unique = true)
    private String coffeeCode;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20 ,nullable = false)
    private CoffeeStatus coffeeStatus = CoffeeStatus.COFFEE_FOR_SALE;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false,name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();



    @ManyToOne
    @JoinColumn(name="ORDER-ID")
    private OrderCoffee orderCoffee;

    public void addOrder(OrderCoffee orderCoffee){
        this.orderCoffee = orderCoffee;
    }







    public enum CoffeeStatus{
        COFFEE_FOR_SALE("판매중"),
        COFFEE_SOLD_OUT("판매 중지");

        @Getter
        private String status;

        CoffeeStatus(String status){
            this.status=status;
        }
    }
}
