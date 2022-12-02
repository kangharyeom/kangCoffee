package SelfProject.kangCoffee.basic;

import SelfProject.kangCoffee.coffee.entity.Coffee;
import SelfProject.kangCoffee.member.entity.Member;
import SelfProject.kangCoffee.order.entity.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaManyToOneUniDirectionConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaManyToOneRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
            mappingManyToOneUniDirection();
        };
    }

    private void mappingManyToOneUniDirection() {
        tx.begin();
        Member member = new Member("hgd@gmail.com", "Hong Gil Dong",
                "010-1111-1111");

        // (1)
        em.persist(member);

        Order order = new Order();
        member.addOrder(order);     // (2)
        order.addMember(member);     // (2)
        em.persist(order);           // (3)
        em.persist(member);           // (3)
        Coffee coffee = new Coffee();
        em.persist(coffee);
        tx.commit();

        // (4)
        Member findMember = em.find(Member.class, 1L);

        // (5) 주문에 해당하는 회원 정보를 가져올 수 있다.
        findMember.getOrders().stream().forEach(findOrder->{System.out.println("findOrder: " + findOrder.getMember().getMemberId() +
                ", " + findOrder.getMember().getEmail());
        });
    }
}