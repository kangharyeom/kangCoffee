package SelfProject.kangCoffee.basic;

import SelfProject.kangCoffee.coffee.entity.Coffee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaIdIdentityMappingConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaSingleMappingRunner(EntityManagerFactory emFactory){
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {

            testNull();

            /*tx.begin();
            em.persist(new Member());
            tx.commit();
            Member member = em.find(Member.class, 1L);

            System.out.println("# memberId: " + member.getMemberId());
        */

        };
    }
    private void testNull(){
        tx.begin();
        em.persist(new Coffee());

        tx.commit();
    }

}