package ie.atu.cicd1_exam_friday;

public class InvalidBookingDataException extends RuntimeException{
    public InvalidBookingDataException(String message){
        super(message);
    }
}
