package com.example._sampleproject_coffee.order.mapper;

import com.example._sampleproject_coffee.order.dto.OrderPatchDto;
import com.example._sampleproject_coffee.order.dto.OrderPostDto;
import com.example._sampleproject_coffee.order.dto.OrderResponseDto;
import com.example._sampleproject_coffee.order.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderPostDtoToOrder(OrderPostDto orderPostDto);
    Order orderPatchDtoToOrder(OrderPatchDto orderPatchDto);
    OrderResponseDto orderToOrderResponseDto(Order order);
    List<OrderResponseDto> ordersToOrderResponseDtos(List<Order> orders);
}

