package SelfProject.kangCoffee.member;

import SelfProject.kangCoffee.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    // (2)
    Optional<Member> findByEmail(String email);
}