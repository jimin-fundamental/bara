    package egeg.BARA.controller;
    
    import egeg.BARA.domain.Member;
    import egeg.BARA.respository.MemberRepository;
    import egeg.BARA.service.MailService;
    import egeg.BARA.service.MemberService;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.configurationprocessor.json.JSONObject;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;
    
    import java.util.*;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;
    
    @Controller
    @RestController
    @RequestMapping("/members")
    public class MemberController {
        private final MemberRepository memberRepository;
        private final MemberService memberService;
        private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
    //    private static final Pattern VALID_EWHA_EMAIL_ADDRESS_REGEX =
    //            Pattern.compile("^[A-Z0-9._%+-]+@ewhain\\.net$", Pattern.CASE_INSENSITIVE);
    
        @Autowired
        public MemberController(MemberRepository memberRepository, MemberService memberService) {
            this.memberRepository = memberRepository;
            this.memberService = memberService;
        }
    
        // Helper method to validate email format
    //    private boolean validateEmail(String emailStr) {
    //        Matcher matcher = VALID_EWHA_EMAIL_ADDRESS_REGEX.matcher(emailStr);
    //        return matcher.find();
    //    }
    
        //회원가입과 로그인
        @PostMapping("/signup")
        public ResponseEntity<Map<String, String>> signUp(@RequestBody Member member) {
            if (member.getEmailId() == null || member.getEmailId().trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Name is required"));        }
            if (memberRepository.findByEmailId(member.getEmailId()) != null) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", "User with this name already exists"));
            }
            //이메일 인증번호 보내고 맞는지 확인
    
            memberRepository.save(member);//자동으로 구현되어 있음
            return ResponseEntity.ok(Collections.singletonMap("message", "User is identified successfully"));
        }
    
    //    @PostMapping("/emails/verification-requests/{email}")
    //    public ResponseEntity sendMessage(@RequestParam("email") String email) {
    //        memberService.sendCodeToEmail(email); //인증코드 발송
    //
    //        return new ResponseEntity<>(HttpStatus.OK); //이메일 인증 코드 발송되면, HTTP 상태 코드 OK(200)를 반환
    //    }



        //mail
        @PostMapping("/emails/verification-requests")
        public ResponseEntity sendMessage(@RequestBody Map<String, String> request) {
            String email = request.get("email");
            memberService.sendCodeToEmail(email); //인증코드 발송
    
            return new ResponseEntity<>(HttpStatus.OK); //이메일 인증 코드 발송되면, HTTP 상태 코드 OK(200)를 반환
        }
    
        @PostMapping("/emails/verifications") // 클라이언트로부터 email과 authCode (인증 코드)를 받습니다.
        public ResponseEntity verificationEmail(@RequestBody Map<String, String> request) {
            String email = request.get("email"); //이건 되는데
            String authCode = request.get("authCode");//이건 안돼?
            System.out.println("-----------------------------------------------------");
            System.out.println("request에서 얻은 email: "+email+" & authCode: "+authCode);

            Map<String, Object> response = new HashMap<>();
    
            boolean isCodeValid = memberService.verifiedCode(email, authCode); // 이메일과 코드의 유효성을 검증합니다.
    
            if (isCodeValid) {
                response.put("message", "Email verification successful");
                return ResponseEntity.ok(response); // 인증이 성공적이면, HTTP 상태 코드 OK(200)를 반환합니다.
            } else {
                response.put("error", "Invalid verification code");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // 인증 실패 시, 에러 메시지와 함께 UNAUTHORIZED(401) 상태 코드를 반환합니다.
            }
        }
    
    
        @PostMapping("/signup2")
        //넘어온 이메일값으로 user 찾기 -> 해당 user table에 nickname과 비밀번호 등록
        public ResponseEntity<Map<String, String>> signUp2(@RequestBody Member member) {
            //넘어온 이메일값으로 user 찾기
    
    
            if (member.getNickname() == null || member.getNickname().trim().isEmpty()) {
                    return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Name is required"));
    
            }
            if (member.getPassword() == null || member.getPassword().trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Password is required"));
    
            }
    
            memberRepository.save(member);
            return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully"));
        }
    
    
        @PostMapping("/login")
        public ResponseEntity<Map<String, Object>> login(@RequestBody Member member) {
            Member existingUser = memberRepository.findByEmailId(member.getEmailId());
            if (existingUser == null || !existingUser.getPassword().equals(member.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Invalid name or password"));
            }
            LOGGER.info("User logged in: {}", member.getEmailId());
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User logged in");
            response.put("userId", existingUser.getId());
            return ResponseEntity.ok(response);
        }
    
    
    
    //    @GetMapping("/{name}/diaries")
    //    public ResponseEntity<List<Diary>> getUserDiaries(@PathVariable String name) {
    //        User user = userRepository.findByName(name);
    //        if (user == null) {
    //            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    //        }
    //
    //        Set<Diary> diariesSet = user.getDiaries();
    //        List<Diary> diariesList = diariesSet.stream().collect(Collectors.toList());
    //
    //        return ResponseEntity.ok(diariesList);
    //    }
    //
    //    @GetMapping("/{name}/analyses")
    //    public ResponseEntity<List<Analysis>> getUserAnalyses(@PathVariable String name) {
    //        User user = userRepository.findByName(name);
    //        if (user == null) {
    //            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    //        }
    //
    //        Set<Analysis> analysisSet = user.getAnalyses();
    //        List<Analysis> analysisList = analysisSet.stream().collect(Collectors.toList());
    //
    //        return ResponseEntity.ok(analysisList);
    //    }
    }
