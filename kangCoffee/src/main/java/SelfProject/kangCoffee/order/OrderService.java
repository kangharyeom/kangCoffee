package SelfProject.kangCoffee.order;

import SelfProject.kangCoffee.coffee.service.CoffeeService;
import SelfProject.kangCoffee.exception.BusinessLogicException;
import SelfProject.kangCoffee.exception.ExceptionCode;
import SelfProject.kangCoffee.member.service.MemberService;
import SelfProject.kangCoffee.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    final private OrderRepository orderRepository;
    final private MemberService memberService;
    final private CoffeeService coffeeService;

    public OrderService(OrderRepository orderRepository,
                        MemberService memberService,
                        CoffeeService coffeeService) {
        this.orderRepository = orderRepository;
        this.memberService = memberService;
        this.coffeeService = coffeeService;
    }
    public Order createOrder(Order order) {
        // (1) 회원이 존재하는지 확인
        memberService.findVerifiedMember(order.getMemberId().getId());

        // (2) 커피가 존재하는지 조회해야 됨
        order.getOrderCoffees()
                .stream()
                .forEach(coffeeRef -> {
                    coffeeService.findVerifiedCoffee(coffeeRef.getCoffeeId());
                });
        return orderRepository.save(order);
    }


    public Order findOrder(long orderId) {
        return findVerifiedOrder(orderId);
    }

    // 주문 수정 메서드는 사용하지 않습니다.

    public List<Order> findOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public void cancelOrder(long orderId) {
        Order findOrder = findVerifiedOrder(orderId);
        int step = findOrder.getOrderStatus().getStepNumber();

        // (4) OrderStatus의 step이 2미만일 경우(ORDER_CONFIRM)에만 주문취소가 되도록한다.
        if (step >= 2) {
            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
        }
        findOrder.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
        orderRepository.save(findOrder);
    }

    private Order findVerifiedOrder(long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order findOrder =
                optionalOrder.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));
        return findOrder;
    }
}
