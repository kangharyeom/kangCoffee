package SelfProject.kangCoffee.order;

import SelfProject.kangCoffee.order.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}