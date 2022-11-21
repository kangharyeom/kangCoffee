package SelfProject.kangCoffee.order.mapper;

import SelfProject.kangCoffee.order.Order;
import SelfProject.kangCoffee.order.OrderPostDto;
import SelfProject.kangCoffee.order.OrderResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderPostDtoToOrder(OrderPostDto orderPostDto);
    OrderResponseDto orderToOrderResponseDto(Order order);
}