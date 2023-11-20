package egeg.BARA.respository;

import egeg.BARA.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

//사용자(별명, 비밀번호)
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String emailId);

}
