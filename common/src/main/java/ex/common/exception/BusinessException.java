package ex.common.exception;

import ex.common.message.ExceptionMessage;
import java.util.Map;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;

    public BusinessException(HttpStatus httpStatus, String message, String code) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
        this.code = code;
    }

    public BusinessException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.httpStatus = exceptionMessage.getHttpStatus();
        this.message = exceptionMessage.getMessage();
        this.code = exceptionMessage.getCode();
    }

    public BusinessException(HttpStatus httpStatus, Map<String, String> feignErrorInfo) {
        super(feignErrorInfo.get("message"));
        this.httpStatus = httpStatus;
        this.message = feignErrorInfo.get("message");
        this.code = feignErrorInfo.get("code");
    }
}
