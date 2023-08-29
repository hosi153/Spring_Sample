package com.example._sampleproject_coffee.order.dto;


import com.example._sampleproject_coffee.order.entity.Order;
import lombok.Getter;

@Getter
public class OrderPatchDto {
    private long orderId;
    private Order.OrderStatus orderStatus;

    public void setOrderId(long orderId){
        this.orderId = orderId;
    }
}
