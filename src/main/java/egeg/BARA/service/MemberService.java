    package egeg.BARA.service;

    import egeg.BARA.respository.MemberRepository;
    import jakarta.transaction.Transactional;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Service;

    import java.security.NoSuchAlgorithmException;
    import java.security.SecureRandom;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Random;

    @Slf4j
    @Service
    @Transactional
    @RequiredArgsConstructor
    public class MemberService {

//        private static final String AUTH_CODE_PREFIX = "AuthCode ";

        private final MemberRepository memberRepository;

        private final MailService mailService;

//        private fina
//        l RedisService redisService;

//        @Value("${spring.mail.auth-code-expiration-millis}")
//        private long authCodeExpirationMillis;

        // 인증 코드 저장을 위한 Map 선언
        private final Map<String, String> authCodeMap = new HashMap<>();


        public void sendCodeToEmail(String toEmail) {
            String title = "BARA 이메일 인증 번호";
            String authCode = this.createCode();
            System.out.println("code create 완료: "+authCode);
            mailService.sendEmail(toEmail, title, authCode);
            // 이메일 인증 요청 시 인증 번호 Redis에 저장 ( key = "AuthCode " + Email / value = AuthCode )
//            redisService.setValues(AUTH_CODE_PREFIX + toEmail, authCode);
            authCodeMap.put(toEmail, authCode); // HashMap에 이메일과 인증코드 저장
            System.out.println("authoCodeMAp: 저장된 이메일: " + toEmail + ", 인증코드: " + authCodeMap.get(toEmail)); // 저장된 내용 확인 및 출력
            System.out.println("인증번호 저장 완료!");
//            redisService.setValues(AUTH_CODE_PREFIX + toEmail, authCode, Duration.ofMillis(this.authCodeExpirationMillis));
        }

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
            String storedAuthCode = authCodeMap.get(email);
            System.out.println("----------------------------------------------------------");
            System.out.println("String authCode: "+ authCode);
            System.out.println("조회한 이메일: " + email + ", 저장된 인증코드: " + storedAuthCode);

            return authCode.equals(storedAuthCode);
        }

//        public boolean verifiedCode(String email, String authCode) {
//    //        this.checkDuplicatedEmail(email);
//            String redisAuthCode = redisService.getValues(AUTH_CODE_PREFIX + email);
//            boolean authResult = redisService.checkExistsValue(redisAuthCode) && redisAuthCode.equals(authCode);
//
//            return authResult;
//        }
    }

