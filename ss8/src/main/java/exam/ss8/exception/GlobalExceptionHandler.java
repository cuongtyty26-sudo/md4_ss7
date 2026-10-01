package exam.ss8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Lỗi chia cho 0
    @ExceptionHandler(ArithmeticException.class)
    public ErrorResponse handleArithmeticException(
            ArithmeticException exception) {

        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Không thể chia cho 0",
                LocalDateTime.now()
        );
    }

    // 2. Lỗi nhập chữ thay vì số
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception) {

        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Dữ liệu nhập vào phải là số",
                LocalDateTime.now()
        );
    }

    // 3. Các lỗi còn lại
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception exception) {

        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Đã xảy ra lỗi trên máy chủ",
                LocalDateTime.now()
        );
    }
}