package egeg.BARA.respository;

import egeg.BARA.domain.Member;
import egeg.BARA.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findById(int id);
    List<Room> findByPlace(String place);

    Room findByMember(Member member);
}