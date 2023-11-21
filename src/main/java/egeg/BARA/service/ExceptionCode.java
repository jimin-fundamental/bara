package egeg.BARA.service;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    UNABLE_TO_SEND_EMAIL(500, "Email Cannot Be Sent"),
    NO_SUCH_ALGORITHM(500, "Auth Code Error"),
    MEMBER_EXISTS(500,"The Member Already Exists" );


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
