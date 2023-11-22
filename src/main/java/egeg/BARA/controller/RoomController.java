package egeg.BARA.controller;


import egeg.BARA.domain.Member;
import egeg.BARA.domain.Room;
import egeg.BARA.respository.MemberRepository;
import egeg.BARA.respository.RoomRepository;
import egeg.BARA.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository, MemberRepository memberRepository) {
        this.roomRepository = roomRepository;
        this.memberRepository = memberRepository;
    }

    @PostMapping("/createRoom")
    public ResponseEntity<Map<String, String>> createRoom(@RequestBody Room room) {
        if (room.getFood() == null || room.getPlace() == null || room.getTimeLimit() == null || room.getMinPeople() == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "폼을 모두 작성해 주세요!"));        }
        if (roomRepository.findByMember((Member) room.getMembers()) != null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "이미 다른 방에 참여하고 있습니다."));
        }

        roomRepository.save(room); // 방 저장

        // 총대에게 방 연결
        long leaderId = ((Member) room.getMembers()).getId();
        Member leader = memberRepository.findById(leaderId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        leader.setRoom(room);


        return ResponseEntity.ok(Collections.singletonMap("message", "방 생성 완료!"));
    }
}
