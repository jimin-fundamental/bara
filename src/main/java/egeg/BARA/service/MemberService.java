    package egeg.BARA.service;

    import egeg.BARA.respository.MemberRepository;
    import jakarta.transaction.Transactional;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Service;

    import java.security.NoSuchAlgorithmException;
    import java.security.SecureRandom;
    import java.util.Random;

    @Slf4j
    @Service
    @Transactional
    @RequiredArgsConstructor
    public class MemberService {

        private static final String AUTH_CODE_PREFIX = "AuthCode ";

        private final MemberRepository memberRepository;

        private final MailService mailService;

        private final RedisService redisService;

//        @Value("${spring.mail.auth-code-expiration-millis}")
//        private long authCodeExpirationMillis;


        public void sendCodeToEmail(String toEmail) {
            String title = "BARA 이메일 인증 번호";
            String authCode = this.createCode();
            System.out.println("------------------");
            System.out.println("code create 완료: "+authCode);
            System.out.println("------------------");
            //여기까지 ㅇㅋ
            mailService.sendEmail(toEmail, title, authCode);
            System.out.println("------------------");
            System.out.println("email 보내기 성공, 인증 번호 저장 직전");
            System.out.println("------------------");
            // 이메일 인증 요청 시 인증 번호 Redis에 저장 ( key = "AuthCode " + Email / value = AuthCode )
            redisService.setValues(AUTH_CODE_PREFIX + toEmail, authCode);
            System.out.println("------------------");
            System.out.println("인증번호 저장 완료!");
            System.out.println("------------------");
//            redisService.setValues(AUTH_CODE_PREFIX + toEmail, authCode, Duration.ofMillis(this.authCodeExpirationMillis));
        }

    //    private void checkDuplicatedEmail(String email) {
    //        Member member = memberRepository.findByName(email);
    //        if (member.isPresent()) {
    //            log.debug("MemberServiceImpl.checkDuplicatedEmail exception occur email: {}", email);
    //            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    //        }
    //    }

        private String createCode() {
            int length = 6;
            try {
                Random random = SecureRandom.getInstanceStrong();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    builder.append(random.nextInt(10));
                }
                return builder.toString();
            } catch (NoSuchAlgorithmException e) {
                log.debug("MemberService.createCode() exception occur");
                throw new BusinessLogicException(ExceptionCode.NO_SUCH_ALGORITHM);
            }
        }

        public boolean verifiedCode(String email, String authCode) {
    //        this.checkDuplicatedEmail(email);
            String redisAuthCode = redisService.getValues(AUTH_CODE_PREFIX + email);
            boolean authResult = redisService.checkExistsValue(redisAuthCode) && redisAuthCode.equals(authCode);

            return authResult;
        }
    }

