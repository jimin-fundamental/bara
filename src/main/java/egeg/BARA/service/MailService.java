package egeg.BARA.service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String fromAddress; // 발신자 이메일 주소

    public void sendEmail(String toEmail,
                          String title,
                          String text) {
//        SimpleMailMessage emailForm = createEmailForm(toEmail, title, text);

        try {
            MimeMessage message = emailSender.createMimeMessage();

            message.setFrom(fromAddress);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(title);
            message.setText(text);

            System.out.println("------------------");
            System.out.println("emailForm은\n"+message);
            System.out.println("------------------");

            emailSender.send(message);//여기서 에러가 나는 거야.

        } catch (MessagingException e) {
            e.printStackTrace();

            log.debug("MailService.sendEmail exception occur toEmail: {}, " +
                    "title: {}, text: {}", toEmail, title, text);
            throw new BusinessLogicException(ExceptionCode.UNABLE_TO_SEND_EMAIL);
        }
    }

    // 발신할 이메일 데이터 세팅(수신자, 제목, 들어갈 내용)
    private SimpleMailMessage createEmailForm(String toEmail, String title, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromAddress); // 발신자 이메일 주소 설정
        message.setReplyTo(toEmail);
        message.setSentDate(new Date());
        message.setSubject(title);
        message.setText(text);

        return message;
    }
}
