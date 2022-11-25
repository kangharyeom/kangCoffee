package SelfProject.kangCoffee.basic;

import SelfProject.kangCoffee.member.entity.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaBasicConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaBasicRunner(EntityManagerFactory emFactory){ //
        this.em = emFactory.createEntityManager(); //
        this.tx = em.getTransaction();
        return args -> {
            example();
        };
    }

    private void example() {
        tx.begin();
        em.persist(new Member("hgd1@gmail.com"));
        tx.commit();

        tx.begin();
        Member member = em.find(Member.class, 1L);
        em.remove(member);
        tx.commit();

    }
}
