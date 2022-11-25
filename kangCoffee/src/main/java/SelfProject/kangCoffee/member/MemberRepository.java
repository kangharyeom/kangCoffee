package SelfProject.kangCoffee.member;

import SelfProject.kangCoffee.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    // ‘find + By + SQL 쿼리문에서 WHERE 절의 컬럼명 + (WHERE 절 컬럼의 조건이 되는 데이터) ’
    Optional<Member> findByEmail(String email);
}