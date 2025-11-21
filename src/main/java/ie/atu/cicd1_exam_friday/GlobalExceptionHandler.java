package ie.atu.cicd1_exam_friday;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorDetails>handleBookingNotFound(BookingNotFoundException ex, WebRequest request){
        ErrorDetails = new ErrorDetails(
                ex.getMessage(),
                "Booking not found!"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBookingDataException.class)
    public ResponseEntity<ErrorDetails>handleInvalidBookingData(InvalidBookingDataException ex, WebRequest request){
        ErrorDetails error = new ErrorDetails(
                ex.getMessage(),
                "Invalid request!"
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateRegNumberException.class)
    public ResponseEntity<ErrorDetails>handleDuplicateReg(DuplicateRegNumberException ex, WebRequest request){
        ErrorDetails error =  new ErrorDetails(
                ex.getMessage(),
                "Duplicate Error"
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
