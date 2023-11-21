//package egeg.BARA.configuration;
//
//import egeg.BARA.respository.MemberRepository;
//import egeg.BARA.service.MailService;
//import egeg.BARA.service.MemberService;
//import egeg.BARA.service.RedisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//    private final MemberRepository memberRepository;
//
//
//    //생성자 주입
//    @Autowired
//    public SpringConfig(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }
//
//    @Bean
//    public MemberService memberService(MailService mailService, RedisService redisService) {
//        return new MemberService(memberRepository, mailService, redisService);
//    }
//
//
//}
