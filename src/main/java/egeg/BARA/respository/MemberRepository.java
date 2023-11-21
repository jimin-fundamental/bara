package egeg.BARA.respository;

import egeg.BARA.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//사용자(별명, 비밀번호)
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmailId(String emailId);

}
