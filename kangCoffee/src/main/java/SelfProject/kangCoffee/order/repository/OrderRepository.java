package SelfProject.kangCoffee.order.repository;

import SelfProject.kangCoffee.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
