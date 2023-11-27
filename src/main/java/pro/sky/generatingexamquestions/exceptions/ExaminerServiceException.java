package pro.sky.generatingexamquestions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExaminerServiceException extends RuntimeException {
    public ExaminerServiceException() {
    }

    public ExaminerServiceException(String message) {
        super(message);
    }

    public ExaminerServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExaminerServiceException(Throwable cause) {
        super(cause);
    }

    public ExaminerServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
