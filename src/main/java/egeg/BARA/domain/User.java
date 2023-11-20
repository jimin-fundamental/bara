package egeg.BARA.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//컴퓨터가 자동생성

    @Column(unique = true, nullable = false)
    private String emailId; // emailId(사용자가 입력)

    @Column(unique = true, nullable = false)
    private String nickname; // nickname

    @Column(nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    @JsonManagedReference(value="d_user")
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Diary> diaries = new HashSet<>();
//
//    @JsonManagedReference(value="a_user")
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Analysis> analyses = new HashSet<>();


    //constructer
    public User(){}

    public User(String emailId, String nickname, String password) {
        this.emailId = emailId;
        this.nickname = nickname;
        this.password = password;
    }

//    public User(Long id, String name, String password, Set<Diary> diaries, Set<Analysis> analyses) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.diaries = diaries;
//        this.analyses = analyses;
//    }

}
