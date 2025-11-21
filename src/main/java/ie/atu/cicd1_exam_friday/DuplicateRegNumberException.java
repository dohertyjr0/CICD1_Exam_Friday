package ie.atu.cicd1_exam_friday;

public class DuplicateRegNumberException extends RuntimeException{
    public DuplicateRegNumberException(String message){
        super(message);
    }
}
