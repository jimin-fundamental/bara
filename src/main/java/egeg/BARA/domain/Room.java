package egeg.BARA.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 자동 생성

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST, orphanRemoval = false)
    @JsonManagedReference
    private List<Member> members = new ArrayList<>(); // 방 안의 사람 정보

    @Column(nullable = false)
    private String food; // 원하는 음식이나 음식점

    @Column(nullable = false)
    private Integer minPeople; // 최소 인원

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime timeLimit; // 마감 시간

    @Column(nullable = false)
    private String place; // 장소 분류

    @Column
    private String placeDetail; // 상세 장소 입력

    @Column
    private String accountNum; // 계좌번호

    @Column
    private String description; // 설명
}
