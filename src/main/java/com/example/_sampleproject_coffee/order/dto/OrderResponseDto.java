package com.example._sampleproject_coffee.order.dto;


import com.example._sampleproject_coffee.member.entity.Member;
import com.example._sampleproject_coffee.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {

    private long orderId;
    private long memberId;
    private Order.OrderStatus orderStatus;
    private List<OrderResponseDto> orderCoffees;
    private LocalDateTime createAt;

    public void setMember (Member member ){
        this.memberId = member.getMemberId();
    }
}
