package com.example._sampleproject_coffee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor

@Entity(name = "ORDER_COFFEE")
public class OrderCoffee {
    @Id
    private Long id;


}
